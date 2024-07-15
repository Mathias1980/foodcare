package de.ml.foodcare.data;

import de.ml.foodcare.bls.BLS;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.jpa.repository.QueryRewriter;
import org.springframework.stereotype.Component;

/**
 *
 * @author mathi
 */
@Component
public abstract class SBLS_Gruppierung implements QueryRewriter {
    
    public String rewrite(String query, Sort sort) {
        
        List<String> liste = new ArrayList();
        
        Class<?> foodClass = BLS.class;
        Field[] fields = foodClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.getType() == double.class) {
                liste.add(field.getName());
            }
        }

        String select  = "SELECT substring(b.sbls, 1, 2) as sbls ";
        String gruppierung = liste.stream()
                .map(field -> "MAX(b." + field + ") as " + field)
                .collect(Collectors.joining(", "));
        return select + ", " + gruppierung + " FROM Bls b GROUP BY substring(b.sbls, 1, 2)";
    }
}
