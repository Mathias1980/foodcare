package de.ml.foodcare.controller;

import de.ml.foodcare.auth.User;
import de.ml.foodcare.auth.UserService;
import de.ml.foodcare.data.DataService;
import de.ml.foodcare.model.BLS;
import de.ml.foodcare.model.BLSReduced;
import de.ml.foodcare.model.BLSService;
import de.ml.foodcare.model.BLS_Dto;
import de.ml.foodcare.model.Dateiaufbau;
import de.ml.foodcare.model.DateiaufbauZuordnung;
import de.ml.foodcare.model.SBLS.Hauptgruppe;
import de.ml.foodcare.model.SBLS.SBLS_Service;
import de.ml.foodcare.model.SBLS.Untergruppe;
import de.ml.foodcare.model.gericht.GerichtDto;
import de.ml.foodcare.model.gericht.GerichtService;
import de.ml.foodcare.model.gericht.Hashtag;
import de.ml.foodcare.model.gericht.HashtagService;
import de.ml.foodcare.model.gericht.ZutatService;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.SessionScope;

/**
 *
 * @author mathi
 */
@Controller
@RequestMapping("/bls")
@SessionScope
public class BLSController {
    
    @Autowired
    private BLSService blsservice;
    @Autowired
    private SBLS_Service sblsservice;
    @Autowired
    private UserService userservice;
    @Autowired
    private DataService data;
    @Autowired
    private ZutatService zs;
    @Autowired
    private GerichtService gs; 
    @Autowired
    private HashtagService hs;
    
    private static final Logger log = LoggerFactory.getLogger(BLSController.class);
    
    @GetMapping("/liste")
    public String bls(@AuthenticationPrincipal UserDetails userDetails, Model model) {

        User user = userservice.findUserByUsername(userDetails.getUsername());
        
        Map<String, Object> highcolors = data.highchartsColumnColors();
        
        List<Hauptgruppe> hg = sblsservice.getHauptgruppen();
        List<Untergruppe> ug = sblsservice.getUntergruppen();
        
        BLS avgG = blsservice.findAvgValuesGesamt();
        
        model.addAttribute("hg", hg);
        model.addAttribute("ug", ug);
        model.addAttribute("user", user);
        model.addAttribute("colors", highcolors);
        model.addAttribute("avgG", avgG);
        
        return "blslist.xhtml";    
    }
    
    @GetMapping("/suche")
    public String blssuche(@AuthenticationPrincipal UserDetails userDetails, Model model) {

        User user = userservice.findUserByUsername(userDetails.getUsername());
        
        List<BLSReduced> blsReduced = blsservice.reducedBls();
        Map<String, Object> highcolors = data.highchartsColumnColors();
        BLS avgG = blsservice.findAvgValuesGesamt();
        
        model.addAttribute("blsReduced", blsReduced);
        model.addAttribute("colors", highcolors);
        model.addAttribute("avgG", avgG);
        model.addAttribute("user", user);
        
        return "blssuche.xhtml";    
    }
    
    @GetMapping("/rezepte")
    public String rezepte(@AuthenticationPrincipal UserDetails userDetails, Model model) {

        User user = userservice.findUserByUsername(userDetails.getUsername());
        List<BLSReduced> blsReduced = blsservice.reducedBls();
        List<BLSReduced> zutatenUser = zs.findBLSReducedByUsername(userDetails.getUsername());
        List<GerichtDto> gerichte = gs.gerichteToDto(gs.getGerichteByUser(userDetails.getUsername()));
        List<Hashtag> hashtags = hs.findAll();
        List<String> kategorien = gs.findDistinctKategorie();
        
        model.addAttribute("zutatenUser", zutatenUser);
        model.addAttribute("bls", blsReduced);
        model.addAttribute("gerichte", gerichte);
        model.addAttribute("hashtags", hashtags);
        model.addAttribute("kategorien", kategorien);
        model.addAttribute("user", user);
        
        return "rezepte.xhtml";    
    }
    
    @GetMapping("/untergruppen/{hauptgruppe}")                   
    public ResponseEntity<List<Untergruppe>> getUntergruppenByHauptgruppe(
        @PathVariable String hauptgruppe
    ) {
        // curl localhost:8080/bls/untergruppen/B
        return ResponseEntity.ok(sblsservice.getUntergruppenByHauptgruppe(hauptgruppe));
    }
    
    @GetMapping("/untergruppen")
    @ResponseBody
    public ResponseEntity<List<Untergruppe>> getUntergruppen() {
        // curl localhost:8080/bls/untergruppen
        return ResponseEntity.ok(sblsservice.getUntergruppen());
    }
    
    @GetMapping("/reducedbls/{untergruppe}")                   
    public ResponseEntity<List<BLSReduced>> getReducedByUntergruppe(
        @PathVariable String untergruppe
    ) {
        // curl localhost:8080/bls/reducedbls/B1
        return ResponseEntity.ok(blsservice.reducedByUntergruppe(untergruppe));
    }
    
    @GetMapping("/maxbls/{untergruppe}")                   
    public ResponseEntity<List<BLS>> findMaxValuesByUntergruppe(
        @PathVariable String untergruppe
    ) {
        // curl localhost:8080/bls/maxbls/B1
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
    public ResponseEntity<BLS> findBLSBySBLS(
        @PathVariable String sbls
    ) {
        // curl localhost:8080/bls/B100000
        return ResponseEntity.of(blsservice.blsBySbls(sbls));
    }
    
    @GetMapping("/dto/{sbls}")                 
    public ResponseEntity<List<BLS_Dto>> findBLSDTObySBLS(
        @PathVariable String sbls
    ) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        // curl localhost:8080/bls/user/B100000
        return ResponseEntity.ok(data.findBLSDTObySBLS(sbls));
    }
    
    @GetMapping("/dateiaufbau") 
    @ResponseBody
    public List<Dateiaufbau> findDateiaufbau(){
        // curl localhost:8080/bls/dateiaufbau
        return blsservice.findDateiaufbau();
    }
    
    @GetMapping("/zuordnung") 
    @ResponseBody
    public List<DateiaufbauZuordnung> findZuordnung(){
        // curl localhost:8080/bls/zuordnung
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
