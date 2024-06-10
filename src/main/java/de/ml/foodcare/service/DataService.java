package de.ml.foodcare.service;

import de.ml.foodcare.auth.User;
import de.ml.foodcare.auth.UserService;
import de.ml.foodcare.data.DateiaufbauRepository;
import de.ml.foodcare.model.BLS;
import de.ml.foodcare.model.dto.BLS_Dto;
import de.ml.foodcare.model.Dateiaufbau;
import de.ml.foodcare.model.dge.Ballaststoffe;
import de.ml.foodcare.model.dge.Energie;
import de.ml.foodcare.model.dge.FettEF;
import de.ml.foodcare.model.dge.Mengenelement;
import de.ml.foodcare.model.dge.Protein;
import de.ml.foodcare.model.dge.Spurenelement;
import de.ml.foodcare.model.dge.Vitamin;
import de.ml.foodcare.model.dge.Wasser;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.math3.util.Precision;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author mathi
 */
@Service
public class DataService {
    
    private BLSService bls;
    private DGEService dge;
    private UserService userservice;
    private DateiaufbauRepository drep; 
    
    public DataService(BLSService bls, DGEService dge, DateiaufbauRepository drep, UserService userservice){
        this.bls = bls;
        this.dge = dge;
        this.drep = drep;
        this.userservice = userservice;
    }
    
    public Map<String, Object> highchartsColumnColors(){
        
        Map<String, Object> colors = new HashMap<>(); 
        colors.put("default", "#eb8934");
        colors.put("Zusammensetzung", "#eb8934");
        colors.put("Vitamine", "#34baeb");
        colors.put("Mineralstoffe", "#2054d6");
        colors.put("Spurenelemente", "#2054d6");
        colors.put("Kohlenhydratzusammensetzung", "#e8b754");
        colors.put("Ballaststoffzusammensetzung", "#9e7f18");
        colors.put("Eiweißzusammensetzung", "#18529e");
        colors.put("Fettzusammensetzung", "#88189e");
        colors.put("Gesamtkennzahlen", "#eb8934");
        
        return colors;
    }
    
    public List<BLS_Dto> findBLSDTObySBLS(String sbls) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{
        List<BLS_Dto> res = new ArrayList();
        
        Authentication authuser = SecurityContextHolder.getContext().getAuthentication();
        User user = userservice.findByUsername(authuser.getName()).get();
        
        Map<String, Object> userDGE = dge.findDGEByUser(user);
        BLS sblsBLS = bls.blsBySbls(sbls).get();
        List<Dateiaufbau> dlist = drep.findAll();
        
        Energie e = (Energie) userDGE.get("energie");
        Protein p = (Protein) userDGE.get("protein");
        FettEF f = (FettEF) userDGE.get("fett");
        Ballaststoffe b = (Ballaststoffe) userDGE.get("blst");
        Wasser w = (Wasser) userDGE.get("wasser");
        List<Vitamin> v = (List<Vitamin>) userDGE.get("vitamine");
        List<Mengenelement> m = (List<Mengenelement>) userDGE.get("mengene");
        List<Spurenelement> s = (List<Spurenelement>) userDGE.get("spur");
        
        Class<?> blsClass = BLS.class;
        Field[] fields = blsClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.getType() == double.class) {
                Dateiaufbau d = dlist.stream().filter(obj -> obj.getKurz().equals(field.getName())).findFirst().get();
                                
                BLS_Dto dto = new BLS_Dto();
                dto.setSbls(sblsBLS.getSBLS());
                dto.setFeld(d.getFeld());
                dto.setKurz(field.getName().toUpperCase());
                dto.setName(d.getVariable());
                dto.setArt(d.getArt());
                dto.setDimension(d.getDimension());
                dto.setZuordnung(d.getZuordnung());
                dto.setAbs( (double) sblsBLS.getClass().getMethod("get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1)).invoke(sblsBLS));
                               
                switch(dto.getKurz()){
                    case "GCAL":      
                        dto.setY(Precision.round( (dto.getAbs() * 100) / e.getKcalProTag(), 2));
                        dto.setInfo("user");
                        break;
                        
                    case "ZW":                      
                        dto.setY(Precision.round( ((dto.getAbs()/1000) * 100) / (w.getZufuhrMlProKgProTag()*user.getWeight()), 2));
                        dto.setInfo("user");
                        break;
                        
                    case "ZE":                      
                        dto.setY(Precision.round( ((dto.getAbs()/1000) * 100) / (p.getgProKgGewichtProTag()*user.getWeight()), 2));
                        dto.setInfo("user");
                        break;
                        
                    case "ZF":                      
                        dto.setY(Precision.round( ((dto.getAbs()*9/1000) * 100) / (f.getFettProzentEnergie()*dto.getAbs()/100), 2));
                        dto.setInfo("user");
                        break;
                        
                    case "ZK":                      
                        dto.setY(Precision.round(dto.getAbs()/1000, 2));
                        dto.setInfo("prozent");
                        break;
                          
                    case "ZB":                      
                        dto.setY(Precision.round(dto.getAbs()/1000, 2));
                        dto.setInfo("prozent");
                        break;
                        
                    case "VA":                      
                        dto.setY(Precision.round( dto.getAbs()*100 /  v.stream().filter( obj -> obj.getBez().equals("Retinol")).findFirst().get().getEinheitProTag() , 2));
                        dto.setInfo("user");
                        break;
                        
                    case "VD":                      
                        dto.setY(Precision.round( dto.getAbs()*100 /  v.stream().filter( obj -> obj.getBez().equals("D")).findFirst().get().getEinheitProTag() , 2));
                        dto.setInfo("user");
                        break;
                        
                    case "VEAT":                      
                        dto.setY(Precision.round( (dto.getAbs()/1000)*100 /  v.stream().filter( obj -> obj.getBez().equals("Tocopherol")).findFirst().get().getEinheitProTag() , 2));
                        dto.setInfo("user");
                        break;
                        
                    case "VK":                      
                        dto.setY(Precision.round( dto.getAbs()*100 /  v.stream().filter( obj -> obj.getBez().equals("K")).findFirst().get().getEinheitProTag() , 2));
                        dto.setInfo("user");
                        break;
                        
                    case "VB1":                      
                        dto.setY(Precision.round( (dto.getAbs()/1000)*100 /  v.stream().filter( obj -> obj.getBez().equals("Thiamin")).findFirst().get().getEinheitProTag() , 2));
                        dto.setInfo("user");
                        break;
                        
                    case "VB2":                      
                        dto.setY(Precision.round( (dto.getAbs()/1000)*100 /  v.stream().filter( obj -> obj.getBez().equals("Riboflavin")).findFirst().get().getEinheitProTag() , 2));
                        dto.setInfo("user");
                        break;
                        
                    case "VB3":                      
                        dto.setY(Precision.round( (dto.getAbs()/1000)*100 /  v.stream().filter( obj -> obj.getBez().equals("Niacin")).findFirst().get().getEinheitProTag() , 2));
                        dto.setInfo("user");
                        break;
                        
                    case "VB6":                      
                        dto.setY(Precision.round( (dto.getAbs()/1000)*100 /  v.stream().filter( obj -> obj.getBez().equals("B6")).findFirst().get().getEinheitProTag() , 2));
                        dto.setInfo("user");
                        break;
                        
                    case "VB9G":                      
                        dto.setY(Precision.round( dto.getAbs()*100 /  v.stream().filter( obj -> obj.getBez().equals("Folat")).findFirst().get().getEinheitProTag() , 2));
                        dto.setInfo("user");
                        break;
                        
                    case "VB5":                      
                        dto.setY(Precision.round( (dto.getAbs()/1000)*100 /  v.stream().filter( obj -> obj.getBez().equals("Pantothen")).findFirst().get().getEinheitProTag() , 2));
                        dto.setInfo("user");
                        break;
                        
                    case "VB7":                      
                        dto.setY(Precision.round( dto.getAbs()*100 /  v.stream().filter( obj -> obj.getBez().equals("Biotin")).findFirst().get().getEinheitProTag() , 2));
                        dto.setInfo("user");
                        break;
                        
                    case "VB12":                      
                        dto.setY(Precision.round( dto.getAbs()*100 /  v.stream().filter( obj -> obj.getBez().equals("B12")).findFirst().get().getEinheitProTag() , 2));
                        dto.setInfo("user");
                        break;
                        
                    case "VC":                      
                        dto.setY(Precision.round( (dto.getAbs()/1000)*100 /  v.stream().filter( obj -> obj.getBez().equals("C")).findFirst().get().getEinheitProTag() , 2));
                        dto.setInfo("user");
                        break;
                        
                    case "MNA":                      
                        dto.setY(Precision.round( dto.getAbs()*100 /  m.stream().filter( obj -> obj.getBez().equals("Natrium")).findFirst().get().getEinheitProTag() , 2));
                        dto.setInfo("user");
                        break;
                        
                    case "MCL":                      
                        dto.setY(Precision.round( dto.getAbs()*100 /  m.stream().filter( obj -> obj.getBez().equals("Chlorid")).findFirst().get().getEinheitProTag() , 2));
                        dto.setInfo("user");
                        break;
                        
                    case "MK":                      
                        dto.setY(Precision.round( dto.getAbs()*100 /  m.stream().filter( obj -> obj.getBez().equals("Kalium")).findFirst().get().getEinheitProTag() , 2));
                        dto.setInfo("user");
                        break;
                        
                    case "Calcium":                      
                        dto.setY(Precision.round( dto.getAbs()*100 /  m.stream().filter( obj -> obj.getBez().equals("Calcium")).findFirst().get().getEinheitProTag() , 2));
                        dto.setInfo("user");
                        break;
                        
                    case "MP":                      
                        dto.setY(Precision.round( dto.getAbs()*100 /  m.stream().filter( obj -> obj.getBez().equals("Phosphor")).findFirst().get().getEinheitProTag() , 2));
                        dto.setInfo("user");
                        break;
                        
                    case "MMG":                      
                        dto.setY(Precision.round( dto.getAbs()*100 /  m.stream().filter( obj -> obj.getBez().equals("Magnesium")).findFirst().get().getEinheitProTag() , 2));
                        dto.setInfo("user");
                        break;
                        
                    case "MFE":                      
                        dto.setY(Precision.round( (dto.getAbs()/1000)*100 /  s.stream().filter( obj -> obj.getBez().equals("Eisen")).findFirst().get().getEinheitProTag() , 2));
                        dto.setInfo("user");
                        break;
                        
                    case "MJ":                      
                        dto.setY(Precision.round( dto.getAbs()*100 /  s.stream().filter( obj -> obj.getBez().equals("Jod")).findFirst().get().getEinheitProTag() , 2));
                        dto.setInfo("user");
                        break;
                        
                    case "MF":                      
                        dto.setY(Precision.round( (dto.getAbs()/1000)*100 /  s.stream().filter( obj -> obj.getBez().equals("Flourid")).findFirst().get().getEinheitProTag() , 2));
                        dto.setInfo("user");
                        break;
                        
                    case "MZN":                      
                        dto.setY(Precision.round( (dto.getAbs()/1000)*100 /  s.stream().filter( obj -> obj.getBez().equals("Zink")).findFirst().get().getEinheitProTag() , 2));
                        dto.setInfo("user");
                        break;
                        
                    case "MCU":                      
                        dto.setY(Precision.round( (dto.getAbs()/1000)*100 /  s.stream().filter( obj -> obj.getBez().equals("Kupfer")).findFirst().get().getEinheitProTag() , 2));
                        dto.setInfo("user");
                        break;
                        
                    case "MMN":                      
                        dto.setY(Precision.round( (dto.getAbs()/1000)*100 /  s.stream().filter( obj -> obj.getBez().equals("Mangan")).findFirst().get().getEinheitProTag() , 2));
                        dto.setInfo("user");
                        break;
                        
                    default:
                        dto.setY(Precision.round(dto.getAbs(), 2));
                        
                    }
            res.add(dto);
            }
        }
    return res;                    
    }
    
}
