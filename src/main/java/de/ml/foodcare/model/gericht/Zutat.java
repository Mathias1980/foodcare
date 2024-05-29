package de.ml.foodcare.model.gericht;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.ml.foodcare.model.BLS;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

/**
 *
 * @author mathi
 */
@Entity
public class Zutat {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   
    
    @ManyToOne
    @JoinColumn(name = "bls_id")
    private BLS bls; 
    
    @ManyToOne
    @JoinColumn(name = "gericht_id")
    @JsonIgnore
    private Gericht gericht; 
        
    private double menge;
    @Column(columnDefinition = "TIMESTAMP")
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

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BLS getBls() {
        return bls;
    }

    public void setBls(BLS bls) {
        this.bls = bls;
    }

    public double getMenge() {
        return menge;
    }

    public void setMenge(double menge) {
        this.menge = menge;
    }

    public Gericht getGericht() {
        return gericht;
    }

    public void setGericht(Gericht gericht) {
        this.gericht = gericht;
    }
    
}
