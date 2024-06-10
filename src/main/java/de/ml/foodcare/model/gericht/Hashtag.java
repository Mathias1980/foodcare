package de.ml.foodcare.model.gericht;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import de.ml.foodcare.model.dto.HashtagDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author mathi
 */

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@Getter
@Setter
public class Hashtag {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Positive
    private Long id;
    @NotBlank
    private String bez;
    
    @JsonIgnore 
    @ManyToMany(mappedBy = "hashtags", cascade = { CascadeType.MERGE })
    private List<@Valid Gericht> gerichte;
    
    public Hashtag(long id, String bez){
        this.id = id;
        this.bez = bez;
    }
    
    public HashtagDto toDto(){
        return new HashtagDto(id, bez);
    }
 

   
}
