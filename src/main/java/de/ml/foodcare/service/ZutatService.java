package de.ml.foodcare.service;

import de.ml.foodcare.auth.User;
import de.ml.foodcare.auth.UserService;
import de.ml.foodcare.data.ZutatRepository;
import de.ml.foodcare.model.BLS;
import de.ml.foodcare.model.BLSReduced;
import de.ml.foodcare.model.Dateiaufbau;
import de.ml.foodcare.model.dto.ZutatDto;
import de.ml.foodcare.model.gericht.Zutat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private DGEService dgeservice;
    private DataService dservice;
    
    public ZutatService(ZutatRepository zrep, BLSService bservice, UserService uservice, DGEService dgeservice, DataService dservice){
        this.zrep = zrep;
        this.uservice = uservice;
        this.bservice = bservice;
        this.dgeservice = dgeservice;
        this.dservice = dservice;
    }
    
    public List<BLSReduced> findBLSReducedByUsername(String username){
        return zrep.findBLSReducedByUsername(username);
    }
    
    public ZutatDto toDto(Zutat z) throws IllegalArgumentException, IllegalAccessException{
        List<Dateiaufbau> dliste = bservice.findDateiaufbau();
        BLS avgG = bservice.findAvgValuesGesamt();
        BLS avgHG = bservice.findAvgValuesByHauptgruppe(z.getBls().getSBLS().substring(0, 1));
        BLS avgUG = bservice.findAvgValuesByUntergruppe(z.getBls().getSBLS().substring(0, 2));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = uservice.findByUsername(authentication.getName()).get();
        Map<String, Object> userDGE = dgeservice.findDGEByUser(user);

        return new ZutatDto(0, z.getBls().getSBLS(), z.getBls().getST(), z.getMenge(), dservice.dto(z, dliste, Optional.of(avgG), Optional.of(avgHG), Optional.of(avgUG), Optional.of(userDGE), Optional.of(user)));
    }
    
    public List<ZutatDto> listeToDto(List<Zutat> liste) throws IllegalArgumentException, IllegalAccessException{
        List<ZutatDto> res = new ArrayList<>();
        
        List<Dateiaufbau> dliste = bservice.findDateiaufbau();
        BLS avgG = bservice.findAvgValuesGesamt();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = uservice.findByUsername(authentication.getName()).get();
        Map<String, Object> userDGE = dgeservice.findDGEByUser(user);
        
        for(Zutat z:liste){
            BLS avgHG = bservice.findAvgValuesByHauptgruppe(z.getBls().getSBLS().substring(0, 1));
            BLS avgUG = bservice.findAvgValuesByUntergruppe(z.getBls().getSBLS().substring(0, 2));
            res.add(new ZutatDto(0, z.getBls().getSBLS(), z.getBls().getST(), z.getMenge(), dservice.dto(z, dliste, Optional.of(avgG), Optional.of(avgHG), Optional.of(avgUG), Optional.of(userDGE), Optional.of(user))));
        } 
        return res;                     
    }
    
}
