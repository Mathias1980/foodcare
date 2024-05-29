package de.ml.foodcare.data;

import de.ml.foodcare.model.BLSReduced;
import de.ml.foodcare.model.gericht.Zutat;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;

/**
 *
 * @author mathi
 */
public interface ZutatRepository extends ListCrudRepository<Zutat, Long>{
    
    @Query("SELECT DISTINCT new de.ml.foodcare.model.BLSReduced(z.bls.id, z.bls.SBLS, z.bls.ST) FROM Zutat as z WHERE z.gericht.user.username = :username")
    List<BLSReduced> findBLSReducedByUsername(String username);
    
}
