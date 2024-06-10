package de.ml.foodcare.controller;

import de.ml.foodcare.auth.UserService;
import de.ml.foodcare.service.GerichtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable String username) {
        gs.deleteUserAndAssignAnonymous(username);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
