package de.ml.foodcare.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author mathi
 */
@Getter
@Setter
@ToString
public class ZutatDto {
    
    @NotNull
    @NotBlank
    @Size(min=7 , max=7, message = "ungültiger SBLS")
    private String sbls;
    
    @Positive
    private double menge;

    public ZutatDto() {
    }

    public ZutatDto(String sbls, double menge) {
        this.sbls = sbls;
        this.menge = menge;
    }
}
