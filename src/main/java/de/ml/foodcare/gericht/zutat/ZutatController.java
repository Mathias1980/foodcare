package de.ml.foodcare.gericht.zutat;

import de.ml.foodcare.bls.BLSReduced;
import de.ml.foodcare.gericht.zutat.ZutatService;
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
public class ZutatController {
    
    private ZutatService zs;
    
    public ZutatController(ZutatService zs){
        this.zs = zs;
    }
    
    @GetMapping("/reducedBLSByUsername")
    public ResponseEntity<List<BLSReduced>> getBLSReducedByUsername(@AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(zs.findBLSReducedByUsername(userDetails.getUsername()));
    }
    
}
