package de.ml.foodcare.auth;

import de.ml.foodcare.data.UserRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author mathi
 */
@Service
public class UserService {
    
    private UserRepository userrep;
    
    public UserService(UserRepository userrep){
        this.userrep = userrep;
    }
    
    public User findUserByUsername(String username){
        return userrep.findByUsername(username).get();
    }
    
}
