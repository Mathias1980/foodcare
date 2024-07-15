package de.ml.foodcare.gericht;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import de.ml.foodcare.gericht.hashtag.HashtagDto;
import de.ml.foodcare.gericht.zutat.ZutatDto;
import de.ml.foodcare.gericht.hashtag.Hashtag;
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
import java.util.Map;
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
@JsonInclude(Include.NON_NULL)
public class GerichtDto {
    
    @PositiveOrZero
    private long id;
    
    @NotNull(message = "Titel darf nicht null sein.")
    @NotBlank(message = "Titel darf nicht leer sein.")
    @Size(min=3 , max=60, message = "Titel muss zwischen 3 und 60 Zeichen lang sein.")
    private String titel;
    
    @NotNull(message = "Kategorie darf nicht null sein.")
    @NotBlank(message = "Kategorie darf nicht leer sein.")
    @Size(min=3 , max=60, message = "Kategorie muss zwischen 3 und 60 Zeichen lang sein.")
    private String kategorie;
    
    @NotNull(message = "Anleitung darf nicht null sein.")
    @NotBlank(message = "Anleitung darf nicht leer sein")
    private String anleitung;
    
    @NotEmpty(message = "Gericht muss Zutaten haben.")
    private List<@Valid ZutatDto> zutaten;
    
    @NotBlank(message = "Username fehlt.")
    private String username;
    private String suche;
    private String message;
    
    @NotNull(message = "Hashtags darf nicht null sein.")
    private List<@Valid HashtagDto> hashtags;
    
    private List<Map<String, Object>> ns;
    
    private double gewicht;
    
    @PastOrPresent(message = "created darf nicht in der Zukunft liegen")
    private LocalDateTime created;
    @PastOrPresent(message = "modified darf nicht in der Zukunft liegen")
    private LocalDateTime modified;

    public GerichtDto() {
        this.zutaten = new ArrayList<>();
        this.hashtags = new ArrayList<>();
    }
    
    public GerichtDto(long id, String titel, String kategorie, String anleitung, String username) {
        this.zutaten = new ArrayList<>();
        this.hashtags = new ArrayList<>();
        this.titel = titel;
        this.kategorie = kategorie;
        this.anleitung = anleitung;
        this.username = username;
        this.id = id;
        this.suche = titel + " : " + kategorie;
        this.message = " ";
    }
}
