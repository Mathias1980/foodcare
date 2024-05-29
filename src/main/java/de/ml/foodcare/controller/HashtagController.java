package de.ml.foodcare.controller;

import de.ml.foodcare.model.gericht.Hashtag;
import de.ml.foodcare.model.gericht.HashtagService;
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
@RequestMapping("/hashtags")
public class HashtagController {
    
    private HashtagService hs;
    
    public HashtagController(HashtagService hs){
        this.hs = hs;
    }
    
    @GetMapping()
    public ResponseEntity<List<Hashtag>> getHashtags() {
        return ResponseEntity.ok(hs.findAll());
    }
    
    @GetMapping("/username")
    public ResponseEntity<List<Hashtag>> findByUsername(@AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(hs.findByUsername(userDetails.getUsername()));
    }
    
}
