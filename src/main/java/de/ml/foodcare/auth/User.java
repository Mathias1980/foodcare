package de.ml.foodcare.auth;

import de.ml.foodcare.model.gericht.Gericht;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.List;
import org.hibernate.validator.constraints.Range;

/**
 *
 * @author mathi
 */
@Entity
@Table(name = "users")
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
    private String role;
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
    private List<Gericht> gerichte;

    public User() {
    }

    public User(Long id, String username, String password, String role, boolean enabled, String email, int age, String gender, double pal, double height, double weight, int phytatzufuhr, boolean pregnant, boolean breastfeeding) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
        this.age = age;
        this.gender = gender;
        this.pal = pal;
        this.height = height;
        this.weight = weight;
        this.phytatzufuhr = phytatzufuhr;
        this.pregnant = pregnant;
        this.breastfeeding = breastfeeding;
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getPal() {
        return pal;
    }

    public void setPal(double pal) {
        this.pal = pal;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getPhytatzufuhr() {
        return phytatzufuhr;
    }

    public void setPhytatzufuhr(int phytatzufuhr) {
        this.phytatzufuhr = phytatzufuhr;
    }

    public boolean isPregnant() {
        return pregnant;
    }

    public void setPregnant(boolean pregnant) {
        this.pregnant = pregnant;
    }

    public boolean isBreastfeeding() {
        return breastfeeding;
    }

    public void setBreastfeeding(boolean breastfeeding) {
        this.breastfeeding = breastfeeding;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + ", enabled=" + enabled + ", email=" + email + ", age=" + age + ", gender=" + gender + ", pal=" + pal + ", height=" + height + ", weight=" + weight + ", phytatzufuhr=" + phytatzufuhr + ", pregnant=" + pregnant + ", breastfeeding=" + breastfeeding + '}';
    }
    
}
