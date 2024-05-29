package de.ml.foodcare.model.gericht;

import de.ml.foodcare.auth.User;
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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
 
/**
 *
 * @author mathi
 */
@Entity
public class Gericht {
    
    @Id
    @Column(name = "gericht_id")
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull(message = "Name cannot be null")
    @Size(min=3 , max=30)
    private String titel;
    private String kategorie;
    private String anleitung;
    
    @OneToMany(mappedBy = "gericht", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Zutat> zutaten;
    
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "gericht_hashtags", joinColumns = @JoinColumn(name = "gericht_id"), inverseJoinColumns = @JoinColumn(name = "hashtag_id"))
    private List<Hashtag> hashtags;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime created;
    
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime modified;

    public Gericht() {
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

    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }

    public String getAnleitung() {
        return anleitung;
    }

    public void setAnleitung(String anleitung) {
        this.anleitung = anleitung;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public long getId() {
        return id;
    }

    public void setId(int id) {
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

    public List<Zutat> getZutaten() {
        return zutaten;
    }

    public void setZutaten(List<Zutat> zutaten) {
        this.zutaten = zutaten;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    @Override
    public String toString() {
        return "Gericht{" + "id=" + id + ", titel=" + titel + ", kategorie=" + kategorie + ", anleitung=" + anleitung + ", zutaten=" + zutaten + ", hashtags=" + hashtags + ", user=" + user + ", created=" + created + ", modified=" + modified + '}';
    }
    
}
