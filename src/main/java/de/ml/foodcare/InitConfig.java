package de.ml.foodcare;

import de.ml.foodcare.auth.Role;
import de.ml.foodcare.auth.User;
import de.ml.foodcare.data.BLSRepository;
import de.ml.foodcare.data.DateiaufbauRepository;
import de.ml.foodcare.data.Import;
import de.ml.foodcare.data.UserRepository;
import java.util.Optional;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author mathi
 */

@Configuration
public class InitConfig {

    @Bean
    public ApplicationRunner initializer(UserRepository urep, PasswordEncoder passwordEncoder, BLSRepository brep, DateiaufbauRepository dateiaufbau, Import i) {
        return args -> {
            
            if (!urep.existsByUsername("anonymous")) {
                User anonymous = new User();
                anonymous.setUsername("anonymous");
                anonymous.setEmail("anonymous@example.com");
                anonymous.setPassword(passwordEncoder.encode("anonymous")); 
                anonymous.setEnabled(true);
                anonymous.setAge(43);
                anonymous.setGender("m");
                anonymous.setPal(1.4);
                anonymous.setHeight(186);
                anonymous.setWeight(94);
                anonymous.setPhytatzufuhr(1);
                anonymous.setPregnant(false);
                anonymous.setBreastfeeding(false);
                urep.save(anonymous);
            }
            
            Optional<User> mathias = urep.findByUsername("Mathias");
            if(mathias.isPresent()){
                if(!mathias.get().getRoles().stream().filter(r -> r.getName().equals("ADMIN")).findFirst().isPresent()){
                    mathias.get().getRoles().add(new Role("ADMIN"));
                    urep.save(mathias.get());
                }
            }
            
            if(brep.count()!=14814){
                i.importBls();               
            }
            
            if(dateiaufbau.count()!=142){
                i.importDateiaufbau();
            }
        };
    }
}
