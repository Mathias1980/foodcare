package de.ml.foodcare.controller;

import de.ml.foodcare.model.BLSReduced;
import de.ml.foodcare.model.gericht.ZutatService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author mathi
 */
@Controller
@RequestMapping("/zutaten")
public class ZutatenController {
    
    private ZutatService zs;
    
    public ZutatenController(ZutatService zs){
        this.zs = zs;
    }
    
    @GetMapping("/reducedBLSByUsername")
    public ResponseEntity<List<BLSReduced>> getBLSReducedByUsername(@AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(zs.findBLSReducedByUsername(userDetails.getUsername()));
    }
    
}
