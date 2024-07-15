package de.ml.foodcare.bls.dateiaufbau;

import de.ml.foodcare.bls.dateiaufbau.DateiaufbauRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author mathi
 */

@Service
public class DateiaufbauService {
    
    private DateiaufbauRepository drep;
    
    public DateiaufbauService(DateiaufbauRepository drep){
        this.drep = drep;
    }
    
    public List<Dateiaufbau> getDateiaufbau(){
        return drep.findAll();
    }
    
}
