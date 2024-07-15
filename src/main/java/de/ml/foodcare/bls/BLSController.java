package de.ml.foodcare.bls;

import de.ml.foodcare.bls.BLS;
import de.ml.foodcare.bls.BLSReduced;
import de.ml.foodcare.bls.dateiaufbau.Dateiaufbau;
import de.ml.foodcare.bls.dateiaufbau.DateiaufbauZuordnung;
import de.ml.foodcare.bls.sbls.SBLS_Service;
import de.ml.foodcare.bls.sbls.Untergruppe;
import de.ml.foodcare.bls.BLSDto;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author mathi
 */
@Controller
@RequestMapping("/bls")
public class BLSController {
    
    private BLSService blsservice;
    private SBLS_Service sblsservice;
    
    public BLSController(BLSService blsservice, SBLS_Service sblsservice){
        this.blsservice = blsservice;
        this.sblsservice = sblsservice;
    }
    
    private static final Logger log = LoggerFactory.getLogger(BLSController.class);
    
    @GetMapping("/untergruppen/{hauptgruppe}")                   
    public ResponseEntity<List<Untergruppe>> getUntergruppenByHauptgruppe(
        @PathVariable String hauptgruppe
    ) {
        return ResponseEntity.ok(sblsservice.getUntergruppenByHauptgruppe(hauptgruppe));
    }
    
    @GetMapping("/untergruppen")
    @ResponseBody
    public ResponseEntity<List<Untergruppe>> getUntergruppen() {
        return ResponseEntity.ok(sblsservice.getUntergruppen());
    }
    
    @GetMapping("/reducedbls/{untergruppe}")                   
    public ResponseEntity<List<BLSReduced>> getReducedByUntergruppe(
        @PathVariable String untergruppe
    ) {
        return ResponseEntity.ok(blsservice.reducedByUntergruppe(untergruppe));
    }
    
    @GetMapping("/maxbls/{untergruppe}")                   
    public ResponseEntity<List<BLS>> findMaxValuesByUntergruppe(
        @PathVariable String untergruppe
    ) {
        return ResponseEntity.ok(blsservice.findMaxValuesByUntergruppe(untergruppe));
    }
    
    @GetMapping("/avgUG/{untergruppe}")                   
    public ResponseEntity<BLS> findAvgValuesByUntergruppe(
        @PathVariable String untergruppe
    ) {
        return ResponseEntity.ok(blsservice.findAvgValuesByUntergruppe(untergruppe));
    }
    
    @GetMapping("/avgHG/{hauptgruppe}")                   
    public ResponseEntity<BLS> findAvgValuesByHauptgruppe(
        @PathVariable String hauptgruppe
    ) {
        return ResponseEntity.ok(blsservice.findAvgValuesByHauptgruppe(hauptgruppe));
    }
    
    @GetMapping("/avgG")                   
    public ResponseEntity<BLS> findAvgValuesByHauptgruppe() {
        return ResponseEntity.ok(blsservice.findAvgValuesGesamt());
    }
    
    @GetMapping("/{sbls}")                 
    public ResponseEntity<BLSDto> findBLSBySBLS(
        @PathVariable String sbls
    ) throws IllegalArgumentException, IllegalAccessException {
        return ResponseEntity.ok(blsservice.toDto(blsservice.blsBySbls(sbls)));
    }   
    
    @GetMapping("/dateiaufbau") 
    @ResponseBody
    public List<Dateiaufbau> findDateiaufbau(){
        return blsservice.findDateiaufbau();
    }
    
    @GetMapping("/zuordnung") 
    @ResponseBody
    public List<DateiaufbauZuordnung> findZuordnung(){
        return blsservice.findZuordnung();
    } 
    
    @GetMapping("/zutaten")
    public ResponseEntity<List<BLSReduced>> getZutaten(){
        return ResponseEntity.ok(blsservice.findZutaten());
    }
    
    @GetMapping("/zutaten/user")
    public ResponseEntity<List<BLSReduced>> getZutatenByUser(@AuthenticationPrincipal UserDetails userDetails){
        return ResponseEntity.ok(blsservice.findZutatenByUser(userDetails.getUsername()));
    }
    
    @GetMapping("/zutaten/hashtags")
    public ResponseEntity<List<BLSReduced>> getZutatenByHashtags(@RequestParam List<String> hashtags){
        return ResponseEntity.ok(blsservice.findZutatenByHashtags(hashtags));
    }
    
    @GetMapping("/zutaten/kategorie")
    public ResponseEntity<List<BLSReduced>> getZutatenByKategorie(@RequestParam String kategorie){
        return ResponseEntity.ok(blsservice.findZutatenByKategorie(kategorie));
    }
    
    @GetMapping("/zutaten/user/hashtags")
    public ResponseEntity<List<BLSReduced>> getZutatenByUserAndHashtags(@AuthenticationPrincipal UserDetails userDetails, @RequestParam List<String> hashtags){
        return ResponseEntity.ok(blsservice.findZutatenByUserAndHashtags(userDetails.getUsername(), hashtags));
    }
    
    @GetMapping("/zutaten/user/kategorie")
    public ResponseEntity<List<BLSReduced>> getZutatenByUserAndKategorie(@AuthenticationPrincipal UserDetails userDetails, @RequestParam String kategorie){
        return ResponseEntity.ok(blsservice.findZutatenByUserAndKategorie(userDetails.getUsername(), kategorie));
    }
    
    @GetMapping("/zutaten/hashtags/kategorie")
    public ResponseEntity<List<BLSReduced>> getZutatenByHashtagsAndKategorie(@RequestParam List<String> hashtags, @RequestParam String kategorie ){
        return ResponseEntity.ok(blsservice.findZutatenByHashtagsAndKategorie(hashtags, kategorie));
    }
    
    @GetMapping("/zutaten/user/hashtags/kategorie")
    public ResponseEntity<List<BLSReduced>> getZutatenByHashtagsAndKategorieAndUsername(@RequestParam List<String> hashtags, @RequestParam String kategorie, @AuthenticationPrincipal UserDetails userDetails){
        return ResponseEntity.ok(blsservice.findZutatenByHashtagsAndKategorieAndUsername(hashtags, kategorie, userDetails.getUsername()));
    }
    
}
