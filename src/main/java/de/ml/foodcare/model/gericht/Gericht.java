package de.ml.foodcare.model.gericht;

import de.ml.foodcare.auth.User;
import de.ml.foodcare.model.dto.GerichtDto;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.UniqueElements;
 
/**
 *
 * @author mathi
 */
@Entity
@Getter
@Setter
@ToString
public class Gericht {
    
    @Id
    @Column(name = "gericht_id")
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PositiveOrZero
    private long id;
    
    @NotNull(message = "Titel darf nicht null sein.")
    @NotBlank(message = "Titel darf nicht leer sein")
    @Size(min=3 , max=60, message = "Titel muss zwischen 3 und 60 Zeichen lang sein.")
    private String titel;
    
    @NotNull(message = "Kategorie darf nicht null sein.")
    @NotBlank(message = "Kategorie darf nicht leer sein")
    @Size(min=3 , max=60, message = "Kategorie muss zwischen 3 und 60 Zeichen lang sein.")
    private String kategorie;
    
    @NotNull(message = "Kategorie darf nicht null sein.")
    @NotBlank(message = "Kategorie darf nicht leer sein")
    private String anleitung;
    
    @NotEmpty(message = "Gericht muss Zutaten haben.")
    @UniqueElements
    @OneToMany(mappedBy = "gericht", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<@Valid Zutat> zutaten;
    
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "gericht_hashtags", joinColumns = @JoinColumn(name = "gericht_id"), inverseJoinColumns = @JoinColumn(name = "hashtag_id"))
    @NotNull(message = "Hashtags darf nicht null sein.")
    @UniqueElements
    private List<@Valid Hashtag> hashtags;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @NotNull(message = "User darf nicht null sein.")
    @Valid
    private User user;
    
    @PastOrPresent(message = "created darf nicht in der Zukunft liegen")
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime created;
    
    @PastOrPresent(message = "modified darf nicht in der Zukunft liegen")
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime modified;

    public Gericht() {
        this.zutaten = new ArrayList<>();
        this.hashtags = new ArrayList<>();
    }

    public Gericht(String titel, String kategorie, String anleitung, User user) {
        this.zutaten = new ArrayList<>();
        this.hashtags = new ArrayList<>();
        this.titel = titel;
        this.kategorie = kategorie;
        this.anleitung = anleitung;
        this.user = user;
        this.created = LocalDateTime.now();
        this.modified = LocalDateTime.now();
    }
    
    public GerichtDto toDto(){
        return new GerichtDto(id, titel, kategorie, anleitung, user.getUsername());
    }
}
