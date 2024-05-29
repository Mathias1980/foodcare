package de.ml.foodcare.model.gericht;

import de.ml.foodcare.auth.User;
import de.ml.foodcare.auth.UserService;
import de.ml.foodcare.data.GerichtRepository;
import de.ml.foodcare.model.BLS;
import de.ml.foodcare.model.BLSService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mathi
 */
@Service
public class GerichtService {
    
    private GerichtRepository grep;
    private BLSService bservice;
    private UserService uservice;
    private HashtagService hservice;
    
    private static final Logger log = LoggerFactory.getLogger(GerichtService.class);
    
    public GerichtService(GerichtRepository grep, BLSService bservice, UserService uservice, HashtagService hservice){
        this.grep = grep;
        this.uservice = uservice;
        this.bservice = bservice;
        this.hservice = hservice;
    }
    
    public List<Gericht> getGerichte() {
        return Collections.unmodifiableList(grep.findAll());      // Kapselung bleibt erhalten - List is backed
    }
    
    public List<Gericht> getGerichteByUser(String username){
        User user = uservice.findUserByUsername(username);
        return grep.findGerichtByUser(user);
    }
    
    public Optional<Gericht> getGericht(long id) {
        return grep.findById(id);
    }
    
    private long addGericht(Gericht g) {
        grep.save(g);
        return g.getId();
    }
    
    @Transactional
    public long addGericht(String titel, String kategorie, String anleitung, String username, List<ZutatDto> zutaten, List<Hashtag> hashtags) {
        User user = uservice.findUserByUsername(username);
        long gid = addGericht(new Gericht(titel, kategorie, anleitung, user));
        hashtags.forEach(e -> { 
            addHashtag(gid, e.getId());
        });
        zutaten.forEach(e -> {
            addZutat(gid, e.getSbls(), e.getMenge());
        });
        return gid;
    }
    
    @Transactional
    public Gericht updateGericht(Gericht g, GerichtDto dto) {
        User user = uservice.findUserByUsername(dto.getUsername());
        g.setTitel(dto.getTitel().trim());
        g.setKategorie(dto.getKategorie().trim());
        g.setAnleitung(dto.getAnleitung().trim());
        g.setUser(user);
        g.setModified(LocalDateTime.now());
        g.setHashtags(dto.getHashtags());
        g.getZutaten().clear();
        for (ZutatDto zutatDTO : dto.getZutaten()) {
            g.getZutaten().add(new Zutat(g, bservice.blsBySbls(zutatDTO.getSbls()).get(), zutatDTO.getMenge()));
        }
        return grep.save(g);
    }
    
    public void removeGericht(int id) {
        grep.delete(getGericht(id).orElse(null));
    }
    
    public void addHashtag(long gid, long id){
        Optional<Gericht> gericht = getGericht(gid);
        if(gericht.isPresent()){
            Hashtag h = hservice.findById(id);
            gericht.get().getHashtags().add(h);
            grep.save(gericht.get());
        }
    }
    
    public void addZutat(long id, String sbls, double menge) {
        Optional<Gericht> gericht = getGericht(id);
        Optional<BLS> bls = bservice.blsBySbls(sbls);
        if (gericht.isPresent() && bls.isPresent()) {
            gericht.get().getZutaten().add(new Zutat(gericht.get(), bls.get(), menge));
            grep.save(gericht.get()); 
        }
    }
    
    public boolean existsGerichtByTitelKategorie(String titel, String kategorie){
        return grep.existsGerichtByTitelKategorie(titel, kategorie);
    }
    
    public static GerichtDto gerichtToDto(Gericht g){
        GerichtDto gdto = new GerichtDto(g.getId(), g.getTitel(), g.getKategorie(), g.getAnleitung(), g.getUser().getUsername());
        g.getZutaten().forEach((el) -> gdto.getZutaten().add(new ZutatDto(el.getBls().getSBLS(), el.getMenge())));
        gdto.setHashtags(g.getHashtags());
        return gdto;
    }
    
    public List<GerichtDto> gerichteToDto(List<Gericht> gerichte){
        return gerichte.stream().map(GerichtService::gerichtToDto).collect(Collectors.toList());                     
    }
    
    public List<GerichtDto> getGerichteDto(){
        List<Gericht> g = getGerichte();
        List<GerichtDto> gdto = new ArrayList<>();
        g.forEach((el) -> gdto.add(gerichtToDto(el)));
        return gdto;
    }
    
    public List<String> findDistinctKategorie(){
        return grep.findDistinctKategorie();
    }
    
}
