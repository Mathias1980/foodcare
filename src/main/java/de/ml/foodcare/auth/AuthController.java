package de.ml.foodcare.auth;

import de.ml.foodcare.data.UserRepository;
import jakarta.validation.Valid;
import java.security.Principal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author mathi
 */
@Controller
public class AuthController {
    
    private UserRepository userrep;
    private PasswordEncoder passwordEncoder;
    private UserService userservice;
    
    public AuthController(UserRepository userrep, PasswordEncoder passwordEncoder, UserService userservice){
        this.passwordEncoder = passwordEncoder;
        this.userrep = userrep;
        this.userservice = userservice;
    }
    
    @GetMapping("/")
    String index(Principal principal) {
        return principal != null ? "home.xhtml" : "anmeldung.xhtml";
    }
    
    @GetMapping("/home")
    public String showHomePage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        User user = userservice.findByUsername(userDetails.getUsername()).get();
        model.addAttribute("user", user);
        return "home.xhtml";
    }
    
    @GetMapping("/admin")
    public String showAdminPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        User user = userservice.findByUsername(userDetails.getUsername()).get();
        model.addAttribute("user", user);
        return "admin.xhtml";
    }
    
    @GetMapping("/anmeldung")
    public String showLoginPage() {
        return "anmeldung.xhtml";
    }

    @GetMapping("/register")
    public String showRegistrationPage(User user) {
        return "register.xhtml"; 
    }
    
    @PostMapping("/register")
    public String checkRegistration(@Valid User user, BindingResult bindingResult) {    
        
        if (bindingResult.hasErrors()) {
            return "register.xhtml";
        }else if(user.isBreastfeeding() && user.isPregnant()){
            bindingResult.addError((new FieldError("user", "pregnant", "Gleichzeitig schwanger und stillend geht nicht.")));
            bindingResult.addError((new FieldError("user", "breastfeeding", "Gleichzeitig schwanger und stillend geht nicht.")));
            return "register.xhtml";
        }else if(user.getGender().equals("m") && user.isPregnant()){
            bindingResult.addError((new FieldError("user", "pregnant", "Männliche Personen können nicht schwanger sein.")));
            return "register.xhtml";
        }else if(user.getGender().equals("m") && user.isBreastfeeding()){
            bindingResult.addError((new FieldError("user", "breastfeeding", "Männliche Personen können nicht stillen.")));
            return "register.xhtml";
        }else if(userrep.existsByUsername(user.getUsername())){
            bindingResult.addError((new FieldError("user", "username", "Benutzername bereits vorhanden.")));
            return "register.xhtml";
        }else{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userrep.save(user);
        }
        return "result.xhtml";
    }
      
}
