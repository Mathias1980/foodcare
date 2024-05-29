package de.ml.foodcare.model.gericht;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.List;

/**
 *
 * @author mathi
 */
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Hashtag {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    private String bez;
    
    @JsonIgnore 
    @ManyToMany(mappedBy = "hashtags", cascade = { CascadeType.MERGE })
    private List<Gericht> gerichte;

    public Hashtag() {
    }

    public Hashtag(String bez) {
        this.bez = bez;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBez() {
        return bez;
    }

    public void setBez(String bez) {
        this.bez = bez;
    }

    public List<Gericht> getGerichte() {
        return gerichte;
    }

    public void setGerichte(List<Gericht> gerichte) {
        this.gerichte = gerichte;
    }

    @Override
    public String toString() {
        return "Hashtag{" + "id=" + id + ", bez=" + bez + ", gerichte=" + gerichte + '}';
    }
   
}
