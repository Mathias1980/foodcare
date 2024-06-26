package de.ml.foodcare.data;

import de.ml.foodcare.model.gericht.Hashtag;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;

/**
 *
 * @author mathi
 */
public interface HashtagRepository extends ListCrudRepository<Hashtag, Long>{

    @Query("SELECT DISTINCT h FROM Hashtag h JOIN h.gerichte g WHERE g.user.username = :username")
    List<Hashtag> findByUsername(String username);
    
}
