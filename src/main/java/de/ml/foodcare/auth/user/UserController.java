package de.ml.foodcare.auth.user;

import de.ml.foodcare.auth.user.UserService;
import de.ml.foodcare.gericht.GerichtDto;
import de.ml.foodcare.gericht.GerichtService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author mathi
 */

@Controller
@RequestMapping("/users")
public class UserController {
    
    private UserService us;
    private GerichtService gs;
    
    public UserController(UserService us, GerichtService gs){
        this.us = us;
        this.gs = gs;
    }
    
    @GetMapping("/names")                    
    public ResponseEntity<List<String>> getUsernames(){
        return ResponseEntity.ok( us.findAllUsernames());
    }  
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable String username) {
        gs.deleteUserAndAssignAnonymous(username);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}