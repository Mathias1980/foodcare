package de.ml.foodcare.controller;

import de.ml.foodcare.auth.User;
import de.ml.foodcare.auth.UserService;
import de.ml.foodcare.service.DataService;
import de.ml.foodcare.model.BLS;
import de.ml.foodcare.model.BLSReduced;
import de.ml.foodcare.service.BLSService;
import de.ml.foodcare.model.SBLS.Hauptgruppe;
import de.ml.foodcare.service.SBLS_Service;
import de.ml.foodcare.model.SBLS.Untergruppe;
import de.ml.foodcare.model.dto.GerichtDto;
import de.ml.foodcare.service.GerichtService;
import de.ml.foodcare.model.gericht.Hashtag;
import de.ml.foodcare.service.DGEService;
import de.ml.foodcare.service.DateiaufbauService;
import de.ml.foodcare.service.HashtagService;
import de.ml.foodcare.service.ZutatService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.annotation.SessionScope;

/**
 *
 * @author mathi
 */
@Controller
@SessionScope
public class WebController {
    
    private BLSService blsservice;
    private SBLS_Service sblsservice;
    private UserService userservice;
    private DataService data;
    private ZutatService zs;
    private GerichtService gs; 
    private HashtagService hs;
    private DateiaufbauService ds;
    private DGEService dge;
    
    public WebController(DGEService dge, BLSService blsservice, SBLS_Service sblsservice, DataService data, UserService userservice, ZutatService zs, GerichtService gs, HashtagService hs, DateiaufbauService ds){
        this.blsservice = blsservice;
        this.sblsservice = sblsservice;
        this.data = data;
        this.userservice = userservice;
        this.zs = zs;
        this.gs = gs;
        this.hs = hs;
        this.ds = ds;
        this.dge = dge;
    }
    
    private static final Logger log = LoggerFactory.getLogger(WebController.class);
    
    @GetMapping("/liste")
    public String bls(@AuthenticationPrincipal UserDetails userDetails, Model model) {

        User user = userservice.findByUsername(userDetails.getUsername()).get();        
        
        List<Hauptgruppe> hg = sblsservice.getHauptgruppen();
        List<Untergruppe> ug = sblsservice.getUntergruppen();
        
        BLS avgG = blsservice.findAvgValuesGesamt();
        
        model.addAttribute("hg", hg);
        model.addAttribute("ug", ug);
        model.addAttribute("user", user);
        model.addAttribute("avgG", avgG);
        
        return "blslist.xhtml";    
    }
    
    @GetMapping("/suche")
    public String blssuche(@AuthenticationPrincipal UserDetails userDetails, Model model) {

        User user = userservice.findByUsername(userDetails.getUsername()).get();
        
        List<BLSReduced> blsReduced = blsservice.reducedBls();
        BLS avgG = blsservice.findAvgValuesGesamt();
        
        model.addAttribute("blsReduced", blsReduced);
        model.addAttribute("avgG", avgG);
        model.addAttribute("user", user);
        
        return "blssuche.xhtml";    
    }
    
    @GetMapping("/rezepte")
    public String rezepte(@AuthenticationPrincipal UserDetails userDetails, Model model) throws IllegalArgumentException, IllegalAccessException {

        User user = userservice.findByUsername(userDetails.getUsername()).get();
        List<BLSReduced> blsReduced = blsservice.reducedBls();
        List<BLSReduced> zutatenUser = zs.findBLSReducedByUsername(userDetails.getUsername());
        List<GerichtDto> gerichte = gs.listeToDto(gs.getGerichteByUser(user), false);
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
    
    @GetMapping("/gliste")
    public String gliste(@AuthenticationPrincipal UserDetails userDetails, Model model) throws IllegalArgumentException, IllegalAccessException {

        User user = userservice.findByUsername(userDetails.getUsername()).get();
        List<GerichtDto> gerichte = gs.listeToDto(gs.getGerichteByUser(user), false);
        List<String> usernames = userservice.findAllUsernames();
        List<String> kategorien = gs.findDistinctKategorieByUsername(userDetails.getUsername());
                         
        model.addAttribute("user", user);
        model.addAttribute("gerichte", gerichte);
        model.addAttribute("usernames", usernames);
        model.addAttribute("kategorien", kategorien);
        return "gliste.xhtml";    
    }
    
} 
