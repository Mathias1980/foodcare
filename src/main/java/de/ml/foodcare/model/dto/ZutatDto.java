package de.ml.foodcare.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author mathi
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ZutatDto {
    
    private long gerichtId;
    
    @NotNull
    @NotBlank
    @Size(min=7 , max=7, message = "ungültiger SBLS")
    private String sbls;

    @NotNull
    @NotBlank
    private String bez;
    
    @Positive
    private double menge;
    
    private List<Map<String, Object>> ns;
}
