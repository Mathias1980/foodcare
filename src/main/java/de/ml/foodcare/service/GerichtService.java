package de.ml.foodcare.service;

import de.ml.foodcare.model.dto.ZutatDto;
import de.ml.foodcare.model.dto.GerichtDto;
import de.ml.foodcare.auth.User;
import de.ml.foodcare.auth.UserService;
import de.ml.foodcare.data.GerichtRepository;
import de.ml.foodcare.exceptions.ResourceNotFoundException;
import de.ml.foodcare.model.BLS;
import de.ml.foodcare.model.Dateiaufbau;
import de.ml.foodcare.model.dto.HashtagDto;
import de.ml.foodcare.model.gericht.Gericht;
import de.ml.foodcare.model.gericht.Hashtag;
import de.ml.foodcare.model.gericht.Zutat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private DataService dservice;
    private DGEService dgeservice;
    private ZutatService zservice;
    
    private static final Logger log = LoggerFactory.getLogger(GerichtService.class);
    
    public GerichtService(GerichtRepository grep, BLSService bservice, UserService uservice, HashtagService hservice, DataService dservice, DGEService dgeservice, ZutatService zservice){
        this.grep = grep;
        this.uservice = uservice;
        this.bservice = bservice;
        this.hservice = hservice;
        this.dservice = dservice;
        this.dgeservice = dgeservice;
        this.zservice = zservice;
    }
    
    public List<Gericht> getGerichte() {
        return Collections.unmodifiableList(grep.findAll());      // Kapselung bleibt erhalten
    }
    
    public List<Gericht> getGerichteByUsername(@NonNull String username){
        User user = uservice.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("Benutzer nicht vorhanden"));
        return grep.findByUser(user);
    }
    
    public List<Gericht> getGerichteByUser(User user){
        return grep.findByUser(user);
    }
    
    public Gericht getGericht(long id) {
        return grep.findById(id).orElseThrow(() -> new ResourceNotFoundException("Gericht nicht vorhanden"));
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
        BLS bls = bservice.blsBySbls(sbls);
        g.getZutaten().add(new Zutat(g, bls, menge));
        grep.save(g); 
    }
    
    public void removeGericht(int id) {
        grep.delete(getGericht(id));
    }
    
    public boolean existsGerichtByTitelKategorie(String titel, String kategorie){
        return grep.existsGerichtByTitelKategorie(titel, kategorie);
    }
    
    public GerichtDto toDto(Gericht g, boolean ns) throws IllegalArgumentException, IllegalAccessException{
        List<Dateiaufbau> dliste = bservice.findDateiaufbau();
        BLS avgG = bservice.findAvgValuesGesamt();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = uservice.findByUsername(authentication.getName()).get();
        Map<String, Object> userDGE = dgeservice.findDGEByUser(user);
        
        GerichtDto gdto = new GerichtDto(g.getId(), g.getTitel(), g.getKategorie(), g.getAnleitung(), g.getUser().getUsername());
        for(Zutat el:g.getZutaten()){
            BLS avgHG = bservice.findAvgValuesByHauptgruppe(el.getBls().getSBLS().substring(0, 1));
            BLS avgUG = bservice.findAvgValuesByUntergruppe(el.getBls().getSBLS().substring(0, 2));
            List<Map<String, Object>> _ns = new ArrayList<>();
            if(ns){
                _ns = dservice.dto(el, dliste, Optional.of(avgG), Optional.of(avgHG), Optional.of(avgUG), Optional.of(userDGE), Optional.of(user));
            }
            gdto.getZutaten().add(new ZutatDto(g.getId(), el.getBls().getSBLS(), el.getBls().getST(), el.getMenge(), _ns));
        } 
        g.getHashtags().forEach((el) -> gdto.getHashtags().add(new HashtagDto(el.getId(), el.getBez())));
        gdto.setGewicht(gdto.getZutaten().stream().mapToDouble(ZutatDto::getMenge).sum());
        gdto.setNs(dservice.dto(g, dliste, Optional.of(avgG), Optional.empty(), Optional.empty(), Optional.of(userDGE), Optional.of(user)));
        return gdto;
    }
    
    public List<GerichtDto> listeToDto(List<Gericht> gerichte, boolean ns) throws IllegalArgumentException, IllegalAccessException{
        List<GerichtDto> res = new ArrayList<>();
        
        List<Dateiaufbau> dliste = bservice.findDateiaufbau();
        BLS avgG = bservice.findAvgValuesGesamt();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = uservice.findByUsername(authentication.getName()).get();
        Map<String, Object> userDGE = dgeservice.findDGEByUser(user);
        
        for(Gericht g:gerichte){
            GerichtDto gdto = new GerichtDto(g.getId(), g.getTitel(), g.getKategorie(), g.getAnleitung(), g.getUser().getUsername());
            for(Zutat el:g.getZutaten()){
                BLS avgHG = bservice.findAvgValuesByHauptgruppe(el.getBls().getSBLS().substring(0, 1));
                BLS avgUG = bservice.findAvgValuesByUntergruppe(el.getBls().getSBLS().substring(0, 2));
                List<Map<String, Object>> _ns = new ArrayList<>();
                if(ns){
                    _ns = dservice.dto(el, dliste, Optional.of(avgG), Optional.of(avgHG), Optional.of(avgUG), Optional.of(userDGE), Optional.of(user));
                }
                gdto.getZutaten().add(new ZutatDto(g.getId(), el.getBls().getSBLS(), el.getBls().getST(), el.getMenge(), _ns));
            }
            g.getHashtags().forEach((el) -> gdto.getHashtags().add(new HashtagDto(el.getId(), el.getBez())));
            gdto.setGewicht(gdto.getZutaten().stream().mapToDouble(ZutatDto::getMenge).sum());
            gdto.setNs(dservice.dto(g, dliste, Optional.of(avgG), Optional.empty(), Optional.empty(), Optional.of(userDGE), Optional.of(user)));
            res.add(gdto);
        }
        return res;                     
    }
    
    public List<String> findDistinctKategorie(){
        return grep.findDistinctKategorie();
    }
    
    public List<String> findDistinctKategorieByUsername(String username){
        return grep.findDistinctKategorieByUsername(username);
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
