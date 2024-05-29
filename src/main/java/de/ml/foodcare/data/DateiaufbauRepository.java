package de.ml.foodcare.data;

import de.ml.foodcare.model.Dateiaufbau;
import de.ml.foodcare.model.DateiaufbauZuordnung;
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
