package de.ml.foodcare.bls;

import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author mathi
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BLSDto {
    
    private String sbls;
    private String title;
    private List<Map<String, Object>> ns;
    
}
