package de.ml.foodcare.bls;

import de.ml.foodcare.Util;
import de.ml.foodcare.auth.user.User;
import de.ml.foodcare.auth.user.UserService;
import de.ml.foodcare.bls.dateiaufbau.DateiaufbauRepository;
import de.ml.foodcare.exceptions.ResourceNotFoundException;
import de.ml.foodcare.bls.dateiaufbau.Dateiaufbau;
import de.ml.foodcare.bls.dateiaufbau.DateiaufbauZuordnung;
import de.ml.foodcare.dge.DGEService;
import de.ml.foodcare.data.DataService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author mathi
 */
@Service
public class BLSService {
    
    private BLSRepository bls;
    private DateiaufbauRepository datei;
    private DataService dservice;
    private UserService uservice;
    private DGEService dgeservice;
    
    public BLSService(BLSRepository bls, DateiaufbauRepository datei, DataService dservice, UserService uservice, DGEService dgeservice){
        this.bls = bls;
        this.datei = datei;
        this.dservice = dservice;
        this.uservice = uservice;
        this.dgeservice = dgeservice;
    }
    
    public boolean existsBLSBySBLS(String sbls){
        return bls.existsBLSBySBLS(sbls);
    }
    
    public List<BLSReduced> reducedBls(){
        return bls.findAllReduced();
    } 
    
    public List<BLSReduced> reducedByUntergruppe(String untergruppe){
        return bls.findReducedByUntergruppe(untergruppe);
    }
    
    public BLS blsBySbls(String sbls){
        return bls.findBySBLS(sbls).orElseThrow(() -> new ResourceNotFoundException("BLS nicht vorhanden"));
    }
    
    public List<BLS> findMaxValuesUG() {
        return bls.findMaxValuesUG();
    }
    
    public List<BLS> findAvgValuesUG() {
        return bls.findAvgValuesUG();
    }
    
    public List<BLS> findMaxValuesByUntergruppe(String untergruppe) {
        return bls.findMaxValuesByUntergruppe(untergruppe);
    }
    
    public BLS findAvgValuesByUntergruppe(String untergruppe) {
        BLS res = bls.findAvgValuesByUntergruppe(untergruppe).getFirst();
        Util.rundeAttribute(res);
        return res;
    }
    
    public BLS findAvgValuesByHauptgruppe(String hauptgruppe) {
        BLS res = bls.findAvgValuesByHauptgruppe(hauptgruppe).getFirst();
        Util.rundeAttribute(res);
        return res;
    }
    
    public BLS findAvgValuesGesamt() {
        BLS res = bls.findAvgValuesGesamt();
        Util.rundeAttribute(res);
        return res;
    }
    
    public List<Dateiaufbau> findDateiaufbau(){
        return datei.findAll();
    }
    
    public List<DateiaufbauZuordnung> findZuordnung(){
        return datei.findZuordnung();
    }
    
    public List<BLSReduced> findZutaten(){
        return bls.findZutaten();
    }
    
    public List<BLSReduced> findZutatenByUserAndHashtags(String username, List<String> hashtags){
        return bls.findZutatenByUserAndHashtags(username, hashtags);
    }
    
    public List<BLSReduced> findZutatenByHashtags(List<String> hashtags){
        return bls.findZutatenByHashtags(hashtags);
    }
        
    public List<BLSReduced> findZutatenByUser(String username){
        return bls.findZutatenByUser(username);
    }
            
    public List<BLSReduced> findZutatenByKategorie(String kategorie){
        return bls.findZutatenByKategorie(kategorie);
    }
                
    public List<BLSReduced> findZutatenByUserAndKategorie(String username, String kategorie){
        return bls.findZutatenByUserAndKategorie(username, kategorie);
    }
                    
    public List<BLSReduced> findZutatenByHashtagsAndKategorie(List<String> hashtags, String kategorie){
        return bls.findZutatenByHashtagsAndKategorie(hashtags, kategorie);
    }
    
    public List<BLSReduced> findZutatenByHashtagsAndKategorieAndUsername(List<String> hashtags, String kategorie, String username){
        return bls.findZutatenByHashtagsAndKategorieAndUsername(hashtags, kategorie, username);
    }
    
    public BLSDto toDto(BLS b) throws IllegalArgumentException, IllegalAccessException{
        List<Dateiaufbau> dliste = findDateiaufbau();
        BLS avgG = findAvgValuesGesamt();
        BLS avgHG = findAvgValuesByHauptgruppe(b.getSBLS().substring(0, 1));
        BLS avgUG = findAvgValuesByUntergruppe(b.getSBLS().substring(0, 2));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = uservice.findByUsername(authentication.getName()).get();
        Map<String, Object> userDGE = dgeservice.findDGEByUser(user);
        
        return new BLSDto(b.getSBLS(), b.getST(), dservice.dto(b, dliste, Optional.of(avgG), Optional.of(avgHG), Optional.of(avgUG), Optional.of(userDGE), Optional.of(user)));
    }
    
    public List<BLSDto> listeToDto(List<BLS> bliste) throws IllegalArgumentException, IllegalAccessException{
        List<BLSDto> res = new ArrayList<>();
        
        List<Dateiaufbau> dliste = findDateiaufbau();
        BLS avgG = findAvgValuesGesamt();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = uservice.findByUsername(authentication.getName()).get();
        Map<String, Object> userDGE = dgeservice.findDGEByUser(user);
        
        for(BLS b:bliste){
            BLS avgHG = findAvgValuesByHauptgruppe(b.getSBLS().substring(0, 1));
            BLS avgUG = findAvgValuesByUntergruppe(b.getSBLS().substring(0, 2));
            res.add(new BLSDto(b.getSBLS(), b.getST(), dservice.dto(b, dliste, Optional.of(avgG), Optional.of(avgHG), Optional.of(avgUG), Optional.of(userDGE), Optional.of(user))));
        }
        return res;                     
    }
    
}
