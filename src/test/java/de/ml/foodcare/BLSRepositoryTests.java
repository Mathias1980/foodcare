package de.ml.foodcare;

import de.ml.foodcare.bls.BLS;
import de.ml.foodcare.bls.BLSRepository;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 *
 * @author mathi
 */
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class BLSRepositoryTests {
    
    @Autowired
    private BLSRepository brep;
    
    @Test
    public void findBySBLS(){
        Optional<BLS> bls = brep.findBySBLS("B101000");
        
        assertEquals(bls.get().getSBLS(), "B101000");
        
    }
    
}
