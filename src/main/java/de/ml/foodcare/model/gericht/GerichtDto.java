package de.ml.foodcare.model.gericht;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mathi
 */
@JsonInclude(Include.NON_NULL)
public class GerichtDto {
    
    private long id;
    private String titel;
    private String kategorie;
    private String anleitung;
    private List<ZutatDto> zutaten;
    private String username;
    private String suche;
    private String message;
    private List<Hashtag> hashtags;

    public GerichtDto() {
        this.zutaten = new ArrayList<>();
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

    public GerichtDto(String titel, String kategorie, String anleitung, List<ZutatDto> zutaten, String username) {
        this.titel = titel;
        this.kategorie = kategorie;
        this.anleitung = anleitung;
        this.zutaten = zutaten;
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getKategorie() {
        return kategorie;
    }

    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }

    public String getAnleitung() {
        return anleitung;
    }

    public void setAnleitung(String anleitung) {
        this.anleitung = anleitung;
    }

    public List<ZutatDto> getZutaten() {
        return zutaten;
    }

    public void setZutaten(List<ZutatDto> zutaten) {
        this.zutaten = zutaten;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSuche() {
        return suche;
    }

    public void setSuche(String suche) {
        this.suche = suche;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }

    @Override
    public String toString() {
        return "GerichtDto{" + "id=" + id + ", titel=" + titel + ", kategorie=" + kategorie + ", anleitung=" + anleitung + ", zutaten=" + zutaten + ", username=" + username + ", suche=" + suche + ", message=" + message + ", hashtags=" + hashtags + '}';
    }
       
}
