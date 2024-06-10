package de.ml.foodcare.data;

import de.ml.foodcare.auth.User;
import de.ml.foodcare.model.gericht.Gericht;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;

/**
 *
 * @author mathi
 */
public interface GerichtRepository extends ListCrudRepository<Gericht, Long>{
    
    @Query("select case when count(g)> 0 then true else false end from Gericht g where g.titel = :titel and g.kategorie = :kategorie")
    boolean existsGerichtByTitelKategorie(String titel, String kategorie);
    
    boolean existsGerichtByTitelAndKategorie(String titel, String kategorie);
    
    @Query("SELECT DISTINCT g.kategorie FROM Gericht as g")
    List<String> findDistinctKategorie();
    
    List<Gericht> findByUser(User user);
    
}
