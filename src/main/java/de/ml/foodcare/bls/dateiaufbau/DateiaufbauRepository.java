package de.ml.foodcare.bls.dateiaufbau;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;

/**
 *
 * @author mathi
 */
public interface DateiaufbauRepository extends ListCrudRepository<Dateiaufbau, Long>{
    
    @Query(value = "SELECT new de.ml.foodcare.model.DateiaufbauZuordnung( d.zuordnung, count(*)) FROM Dateiaufbau d GROUP BY d.zuordnung", nativeQuery = false)
    List<DateiaufbauZuordnung> findZuordnung();
    
}
