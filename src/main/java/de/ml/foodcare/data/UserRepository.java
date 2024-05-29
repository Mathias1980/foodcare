package de.ml.foodcare.data;

import de.ml.foodcare.auth.User;
import java.util.Optional;
import org.springframework.data.repository.*;

/**
 *
 * @author mathi
 */
public interface UserRepository extends ListCrudRepository<User, Long>{
    
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
    
}
