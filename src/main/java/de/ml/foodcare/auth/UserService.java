package de.ml.foodcare.auth;

import de.ml.foodcare.data.UserRepository;
import java.util.Optional;
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
    
    public Optional<User> findByUsername(String username){
        return userrep.findByUsername(username);
    }
    
    public long delete(User user){
        return userrep.deleteByUsername(user.getUsername());
    }
    
    
}
