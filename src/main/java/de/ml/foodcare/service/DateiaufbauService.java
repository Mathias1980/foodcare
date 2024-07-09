package de.ml.foodcare.service;

import de.ml.foodcare.data.DateiaufbauRepository;
import de.ml.foodcare.model.Dateiaufbau;
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
