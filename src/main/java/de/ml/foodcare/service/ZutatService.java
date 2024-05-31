package de.ml.foodcare.service;

import de.ml.foodcare.auth.UserService;
import de.ml.foodcare.data.ZutatRepository;
import de.ml.foodcare.model.BLSReduced;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author mathi
 */
@Service
public class ZutatService {
    
    private ZutatRepository zrep;
    private BLSService bservice;
    private UserService uservice;
    
    public ZutatService(ZutatRepository zrep, BLSService bservice, UserService uservice){
        this.zrep = zrep;
        this.uservice = uservice;
        this.bservice = bservice;
    }
    
    public List<BLSReduced> findBLSReducedByUsername(String username){
        return zrep.findBLSReducedByUsername(username);
    }
    
}
