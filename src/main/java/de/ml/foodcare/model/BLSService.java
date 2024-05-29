package de.ml.foodcare.model;

import de.ml.foodcare.Util;
import de.ml.foodcare.data.BLSRepository;
import de.ml.foodcare.data.DateiaufbauRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

/**
 *
 * @author mathi
 */
@Service
public class BLSService {
    
    private BLSRepository bls;
    private DateiaufbauRepository datei;
    
    public BLSService(BLSRepository bls, DateiaufbauRepository datei){
        this.bls = bls;
        this.datei = datei;
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
    
//    public List<BLS> blsByUntergruppe(String untergruppe) {
//        return bls.findBySBLSStartingWith(untergruppe);
//    }
    
    public Optional<BLS> blsBySbls(String sbls){
        return bls.findBySBLS(sbls).stream().findFirst();
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
    
}
