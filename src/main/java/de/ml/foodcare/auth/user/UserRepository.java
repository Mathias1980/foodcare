package de.ml.foodcare.auth.user;

import de.ml.foodcare.auth.user.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;

/**
 *
 * @author mathi
 */
public interface UserRepository extends ListCrudRepository<User, Long>{
    
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
    Long deleteByUsername(String username);
    
    @Query("SELECT u.username FROM User u ORDER BY u.username ASC")
    List<String> findAllUsernames();
    
}
