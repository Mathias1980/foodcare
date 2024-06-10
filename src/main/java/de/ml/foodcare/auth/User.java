package de.ml.foodcare.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.ml.foodcare.model.gericht.Gericht;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

/**
 *
 * @author mathi
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @NotNull(message = "Name cannot be null")
    @Size(min=3 , max=30)
    private String username;
    @Size(min=10)
    private String password;
    private boolean enabled;
    @Email(message = "Bitte geben Sie eine gültige E-Mail-Adresse ein.")
    private String email;
    @Min(value = 1, message = "Mindestalter ein Jahr.")
    @Max(value = 99, message = "Höchstalter 99 Jahre.")
    private int age;
    @Pattern(regexp = "^(m|w)$", message = "Geschlecht muss 'm' oder 'w' sein.")
    private String gender;
    @Range(min = 1, max = 2, message = "Der Wert mus zwischen eins und zwei sein.")
    private double pal;
    @Range(min = 50, max = 250, message = "Der Wert mus zwischen 50 cm und 250 cm sein.")
    private double height;
    @Range(min = 30, max = 250, message = "Der Wert mus zwischen 30 kg und 250 kg sein.")
    private double weight;
    @Range(min = -1, max = 1, message = "Der Wert muss -1, 0 oder 1 sein.")
    private int phytatzufuhr;
    private boolean pregnant;
    private boolean breastfeeding;
    
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Gericht> gerichte = new ArrayList<>();
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "user_roles",
               joinColumns = @JoinColumn(name = "user_id"),
               inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

}
