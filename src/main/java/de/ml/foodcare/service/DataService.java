package de.ml.foodcare.service;

import de.ml.foodcare.auth.User;
import de.ml.foodcare.model.BLS;
import de.ml.foodcare.model.Dateiaufbau;
import de.ml.foodcare.model.dge.Ballaststoffe;
import de.ml.foodcare.model.dge.Energie;
import de.ml.foodcare.model.dge.FettEF;
import de.ml.foodcare.model.dge.Mengenelement;
import de.ml.foodcare.model.dge.Protein;
import de.ml.foodcare.model.dge.Spurenelement;
import de.ml.foodcare.model.dge.Vitamin;
import de.ml.foodcare.model.dge.Wasser;
import de.ml.foodcare.model.gericht.Gericht;
import de.ml.foodcare.model.gericht.IGericht;
import de.ml.foodcare.model.gericht.Zutat;
import jakarta.validation.Valid;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;

/**
 *
 * @author mathi
 */
@Service
public class DataService {    
    
    public Map<String, String> highchartsColumnColors(){
        
        Map<String, String> colors = new HashMap<>(); 
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
    
    public Map<String, Object> nsByBls(BLS b) throws IllegalArgumentException, IllegalAccessException{
        Map<String, Object> dto = new HashMap<>();
        Class<?> blsClass = BLS.class;
        Field[] fields = blsClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.getType() == double.class) {
                field.setAccessible(true); 
                dto.put(field.getName(), field.get(b)); 
            }
        }
        return dto;
    }
    
    public <T extends IGericht> List<Map<String, Object>> dto(T source, List<@Valid Dateiaufbau> dlist, Optional<BLS> avgG, Optional<BLS> avgHG, Optional<BLS> avgUG, Optional<Map<String, Object>> userDGE, Optional<User> user) throws IllegalArgumentException, IllegalAccessException{
              
        List<Map<String, Object>> liste = new ArrayList<>();
        Map<String, String> colors = highchartsColumnColors();
        
        Class<?> blsClass = BLS.class;
        Field[] fields = blsClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.getType() == double.class) {
                field.setAccessible(true);
                Optional<Dateiaufbau> d = dlist.stream().filter(obj -> obj.getKurz().equals(field.getName())).findFirst();
                if(d.isPresent()){
                    Map<String, Object> dto = new HashMap<>();
                    dto.put("feld", d.get().getFeld());
                    dto.put("kurz", d.get().getKurz());
                    dto.put("variable", d.get().getVariable());
                    dto.put("name", d.get().getVariable());
                    dto.put("art", d.get().getArt());
                    dto.put("laenge", d.get().getLaenge());
                    dto.put("dimension", d.get().getDimension());
                    dto.put("zuordnung", d.get().getZuordnung());
                    if(source instanceof BLS){
                        BLS b = (BLS) source;
                        dto.put("abs", Precision.round(field.getDouble(b), 2));
                    }else if(source instanceof Zutat){
                        Zutat z = (Zutat) source;
                        dto.put("abs", Precision.round(field.getDouble(z.getBls()) * z.getMenge() / 100, 2));
                        dto.put("dimension", d.get().getDimension().split("/")[0] + "/" + z.getMenge() );
                    }else if(source instanceof Gericht){
                        Gericht g = (Gericht) source;
                        double sum = 0.0, menge = 0.0;
                        for (int i = 0; i < g.getZutaten().size(); i++) {
                            sum += field.getDouble(g.getZutaten().get(i).getBls()) * g.getZutaten().get(i).getMenge() / 100;
                            menge += g.getZutaten().get(i).getMenge();
                        }
                        dto.put("abs", Precision.round(sum / menge * 100, 2));
                    }
                    if(avgG.isPresent()){
                        dto.put("avgG", Precision.round(field.getDouble(avgG.get()), 2));
                    }
                    if(avgHG.isPresent()){
                        dto.put("avgHG", Precision.round(field.getDouble(avgHG.get()), 2));
                    }
                    if(avgUG.isPresent()){
                        dto.put("avgUG", Precision.round(field.getDouble(avgUG.get()), 2));
                    }
                    if(userDGE.isPresent() && user.isPresent()){
                        dto.put("dge", Precision.round(dge(dto, user.get(), userDGE.get()), 2));
                    }
                    dto.put("color", colors.get(colors.keySet().stream()
                                        .filter(c -> d.get().getZuordnung().contains(c))
                                        .findFirst()
                                        .orElse("default")));
                    liste.add(dto);   
                }
            }
        }
        return liste;
    }
    
    public double dge(Map<String, Object> dto, User user, Map<String, Object> userDGE){
        Map<String, Double> res = new HashMap<>();
        
        Energie e = (Energie) userDGE.get("energie");
        Protein p = (Protein) userDGE.get("protein");
        FettEF f = (FettEF) userDGE.get("fett");
        Ballaststoffe b = (Ballaststoffe) userDGE.get("blst");
        Wasser w = (Wasser) userDGE.get("wasser");
        List<Vitamin> v = (List<Vitamin>) userDGE.get("vitamine");
        List<Mengenelement> m = (List<Mengenelement>) userDGE.get("mengene");
        List<Spurenelement> s = (List<Spurenelement>) userDGE.get("spur");
        
        switch((String) dto.get("kurz")){

              case "GCAL":      
                  return Precision.round( ((double) dto.get("abs") * 100) / e.getKcalProTag(), 2);

              case "ZW":                      
                  return Precision.round( (((double) dto.get("abs")/1000) * 100) / (w.getZufuhrMlProKgProTag()*user.getWeight()), 2);

              case "ZE":                      
                  return Precision.round( (((double) dto.get("abs")/1000) * 100) / (p.getgProKgGewichtProTag()*user.getWeight()), 2);

              case "ZF":                      
                  return Precision.round( (((double) dto.get("abs")*9/1000) * 100) / (f.getFettProzentEnergie()*(double) dto.get("abs")/100), 2);

              case "ZK":                      
                  return Precision.round((double) dto.get("abs")/1000, 2);

              case "ZB":                      
                  return Precision.round((double) dto.get("abs")/1000, 2);

              case "VA":                      
                  return Precision.round( (double) dto.get("abs")*100 /  v.stream().filter( obj -> obj.getBez().equals("Retinol")).findFirst().get().getEinheitProTag() , 2);

              case "VD":                      
                  return Precision.round( (double) dto.get("abs")*100 /  v.stream().filter( obj -> obj.getBez().equals("D")).findFirst().get().getEinheitProTag() , 2);

              case "VEAT":                      
                  return Precision.round( ((double) dto.get("abs")/1000)*100 /  v.stream().filter( obj -> obj.getBez().equals("Tocopherol")).findFirst().get().getEinheitProTag() , 2);

              case "VK":                      
                  return Precision.round( (double) dto.get("abs")*100 /  v.stream().filter( obj -> obj.getBez().equals("K")).findFirst().get().getEinheitProTag() , 2);

              case "VB1":                      
                  return Precision.round( ((double) dto.get("abs")/1000)*100 /  v.stream().filter( obj -> obj.getBez().equals("Thiamin")).findFirst().get().getEinheitProTag() , 2);

              case "VB2":                      
                  return Precision.round( ((double) dto.get("abs")/1000)*100 /  v.stream().filter( obj -> obj.getBez().equals("Riboflavin")).findFirst().get().getEinheitProTag() , 2);

              case "VB3":                      
                  return Precision.round( ((double) dto.get("abs")/1000)*100 /  v.stream().filter( obj -> obj.getBez().equals("Niacin")).findFirst().get().getEinheitProTag() , 2);

              case "VB6":                      
                  return Precision.round( ((double) dto.get("abs")/1000)*100 /  v.stream().filter( obj -> obj.getBez().equals("B6")).findFirst().get().getEinheitProTag() , 2);

              case "VB9G":                      
                  return Precision.round( (double) dto.get("abs")*100 /  v.stream().filter( obj -> obj.getBez().equals("Folat")).findFirst().get().getEinheitProTag() , 2);

              case "VB5":                      
                  return Precision.round( ((double) dto.get("abs")/1000)*100 /  v.stream().filter( obj -> obj.getBez().equals("Pantothen")).findFirst().get().getEinheitProTag() , 2);

              case "VB7":                      
                  return Precision.round( (double) dto.get("abs")*100 /  v.stream().filter( obj -> obj.getBez().equals("Biotin")).findFirst().get().getEinheitProTag() , 2);

              case "VB12":                      
                  return Precision.round( (double) dto.get("abs")*100 /  v.stream().filter( obj -> obj.getBez().equals("B12")).findFirst().get().getEinheitProTag() , 2);

              case "VC":                      
                  return Precision.round( ((double) dto.get("abs")/1000)*100 /  v.stream().filter( obj -> obj.getBez().equals("C")).findFirst().get().getEinheitProTag() , 2);

              case "MNA":                      
                  return Precision.round( (double) dto.get("abs")*100 /  m.stream().filter( obj -> obj.getBez().equals("Natrium")).findFirst().get().getEinheitProTag() , 2);

              case "MCL":                      
                  return Precision.round( (double) dto.get("abs")*100 /  m.stream().filter( obj -> obj.getBez().equals("Chlorid")).findFirst().get().getEinheitProTag() , 2);

              case "MK":                      
                  return Precision.round( (double) dto.get("abs")*100 /  m.stream().filter( obj -> obj.getBez().equals("Kalium")).findFirst().get().getEinheitProTag() , 2);

              case "Calcium":                      
                  return Precision.round( (double) dto.get("abs")*100 /  m.stream().filter( obj -> obj.getBez().equals("Calcium")).findFirst().get().getEinheitProTag() , 2);

              case "MP":                      
                  return Precision.round( (double) dto.get("abs")*100 /  m.stream().filter( obj -> obj.getBez().equals("Phosphor")).findFirst().get().getEinheitProTag() , 2);

              case "MMG":                      
                  return Precision.round( (double) dto.get("abs")*100 /  m.stream().filter( obj -> obj.getBez().equals("Magnesium")).findFirst().get().getEinheitProTag() , 2);

              case "MFE":                      
                  return Precision.round( ((double) dto.get("abs")/1000)*100 /  s.stream().filter( obj -> obj.getBez().equals("Eisen")).findFirst().get().getEinheitProTag() , 2);

              case "MJ":                      
                  return Precision.round( (double) dto.get("abs")*100 /  s.stream().filter( obj -> obj.getBez().equals("Jod")).findFirst().get().getEinheitProTag() , 2);

              case "MF":                      
                  return Precision.round( ((double) dto.get("abs")/1000)*100 /  s.stream().filter( obj -> obj.getBez().equals("Flourid")).findFirst().get().getEinheitProTag() , 2);

              case "MZN":                      
                  return Precision.round( ((double) dto.get("abs")/1000)*100 /  s.stream().filter( obj -> obj.getBez().equals("Zink")).findFirst().get().getEinheitProTag() , 2);

              case "MCU":                      
                  return Precision.round( ((double) dto.get("abs")/1000)*100 /  s.stream().filter( obj -> obj.getBez().equals("Kupfer")).findFirst().get().getEinheitProTag() , 2);

              case "MMN":                      
                  return Precision.round( ((double) dto.get("abs")/1000)*100 /  s.stream().filter( obj -> obj.getBez().equals("Mangan")).findFirst().get().getEinheitProTag() , 2);

              default:
                  return Precision.round((double) dto.get("abs"), 2);

        }                  
        
    }
    
}
