package de.ml.foodcare.gericht.hashtag;

import de.ml.foodcare.gericht.hashtag.Hashtag;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author mathi
 */
@Data
@Builder
@AllArgsConstructor
public class HashtagDto {

    @Positive
    private Long id;
    @NotBlank
    private String bez;

    public Hashtag toHashtag() {
        return new Hashtag(id, bez);
   }
   
}
