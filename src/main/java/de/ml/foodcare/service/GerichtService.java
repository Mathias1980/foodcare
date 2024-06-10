package de.ml.foodcare.service;

import de.ml.foodcare.model.dto.ZutatDto;
import de.ml.foodcare.model.dto.GerichtDto;
import de.ml.foodcare.auth.User;
import de.ml.foodcare.auth.UserService;
import de.ml.foodcare.data.GerichtRepository;
import de.ml.foodcare.exceptions.ResourceNotFoundException;
import de.ml.foodcare.model.BLS;
import de.ml.foodcare.model.dto.HashtagDto;
import de.ml.foodcare.model.gericht.Gericht;
import de.ml.foodcare.model.gericht.Hashtag;
import de.ml.foodcare.model.gericht.Zutat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.NonNull;
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
        return Collections.unmodifiableList(grep.findAll());      // Kapselung bleibt erhalten
    }
    
    public List<Gericht> getGerichteByUser(@NonNull String username){
        User user = uservice.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("Benutzer nicht vorhanden"));
        return grep.findByUser(user);
    }
    
    public Optional<Gericht> getGericht(long id) {
        return grep.findById(id);
    }
    
    private long addGericht(Gericht g) {
        grep.save(g);
        return g.getId();
    }
    
    @Transactional
    public long create(GerichtDto dto) {
        User user = uservice.findByUsername(dto.getUsername()).orElseThrow(() -> new ResourceNotFoundException("Benutzer nicht vorhanden"));
        Gericht g = grep.save(new Gericht(dto.getTitel(), dto.getKategorie(), dto.getAnleitung(), user));
        dto.getHashtags().forEach(e -> { 
            addHashtag(g, e.getId());
        });
        dto.getZutaten().forEach(e -> {
            addZutat(g, e.getSbls(), e.getMenge());
        });
        return g.getId();
    }
    
    @Transactional
    public Gericht update(Gericht g, GerichtDto dto) {
        User user = uservice.findByUsername(dto.getUsername()).orElseThrow(() -> new ResourceNotFoundException("Benutzer nicht vorhanden"));
        g.setTitel(dto.getTitel());
        g.setKategorie(dto.getKategorie());
        g.setAnleitung(dto.getAnleitung());
        g.setUser(user);
        g.setModified(LocalDateTime.now());
        g.getHashtags().clear();
        for (HashtagDto hDto : dto.getHashtags()) {
            addHashtag(g, hDto.getId());
        }
        g.getZutaten().clear();
        for (ZutatDto zutatDTO : dto.getZutaten()) {
            addZutat(g, zutatDTO.getSbls(), zutatDTO.getMenge());
        }
        return grep.save(g);
    }
    
    public void addHashtag(Gericht g, long id){
        Hashtag h = hservice.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hashtag nicht vorhanden"));
        g.getHashtags().add(h);
        grep.save(g);   
    }
    
    public void addZutat(Gericht g, String sbls, double menge) {
        BLS bls = bservice.blsBySbls(sbls).orElseThrow(() -> new ResourceNotFoundException("BLS nicht vorhanden"));
        g.getZutaten().add(new Zutat(g, bls, menge));
        grep.save(g); 
    }
    
    public void removeGericht(int id) {
        grep.delete(getGericht(id).orElseThrow(() -> new ResourceNotFoundException("Gericht nicht vorhanden")));
    }
    
    public boolean existsGerichtByTitelKategorie(String titel, String kategorie){
        return grep.existsGerichtByTitelKategorie(titel, kategorie);
    }
    
    public static GerichtDto gerichtToDto(Gericht g){
        GerichtDto gdto = new GerichtDto(g.getId(), g.getTitel(), g.getKategorie(), g.getAnleitung(), g.getUser().getUsername());
        g.getZutaten().forEach((el) -> gdto.getZutaten().add(new ZutatDto(el.getBls().getSBLS(), el.getMenge())));
        g.getHashtags().forEach((el) -> gdto.getHashtags().add(new HashtagDto(el.getId(), el.getBez())));
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
    
    @Transactional
    public void deleteUserAndAssignAnonymous(String username) {
        User user = uservice.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Benutzer nicht vorhanden"));

        User anonymous = uservice.findByUsername("anonymous")
                .orElseThrow(() -> new ResourceNotFoundException("Anonymous nicht vorhanden"));

        List<Gericht> gerichte = grep.findByUser(user);
        for (Gericht gericht : gerichte) {
            gericht.setUser(anonymous);
        }
        grep.saveAll(gerichte);
        uservice.delete(user);
    }
    
}
