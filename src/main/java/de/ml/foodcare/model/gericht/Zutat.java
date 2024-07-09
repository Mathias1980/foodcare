package de.ml.foodcare.model.gericht;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.ml.foodcare.model.BLS;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author mathi
 */
@Entity
@Getter
@Setter
public class Zutat implements IGericht{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Positive
    private Long id;   
    
    @ManyToOne
    @JoinColumn(name = "bls_id")
    @NotNull
    private BLS bls; 
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gericht_id")
    @JsonIgnore
    @NotNull
    @Valid
    private Gericht gericht; 
        
    @Positive
    private double menge;
    
    @Column(columnDefinition = "TIMESTAMP")
    @PastOrPresent(message = "modified darf nicht in der Zukunft liegen")
    private LocalDateTime modified;

    public Zutat() {
        this.modified = LocalDateTime.now();
    }

    public Zutat(Gericht gericht, BLS bls, double menge) {
        this.gericht = gericht;
        this.bls = bls;
        this.menge = menge;
        this.modified = LocalDateTime.now();
    }
}
