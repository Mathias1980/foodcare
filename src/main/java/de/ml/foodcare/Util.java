package de.ml.foodcare;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.math3.util.Precision;

/**
 *
 * @author mathi
 */
public class Util {
    
    public static void rundeAttribute(Object objekt) {
        Field[] felder = objekt.getClass().getDeclaredFields();

        for (Field feld : felder) {
            if (feld.getType().equals(double.class)) {
                feld.setAccessible(true);
                try {
                    double wert = feld.getDouble(objekt);
                    double gerundeterWert = Precision.round(wert, 2);
                    feld.setDouble(objekt, gerundeterWert);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static Map<String, Object> generateDTO(Object... sources) throws IllegalAccessException {
        Map<String, Object> dto = new HashMap<>();
        
        for (Object source : sources) {
            Field[] fields = source.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);  // Mach das Feld zugänglich
                dto.put(field.getName(), field.get(source));  // Attributname und Wert in die Map einfügen
            }
        }       
        return dto;
    }
    
}
