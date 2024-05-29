package de.ml.foodcare;

import java.lang.reflect.Field;
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
    
}
