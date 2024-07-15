package de.ml.foodcare.bls;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.ml.foodcare.gericht.IGericht;
import de.ml.foodcare.gericht.zutat.Zutat;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author mathi
 */

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "bls")
public class BLS implements Serializable, IGericht{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Basic(optional = false)
    @Column(name = "bls_id", nullable = false)
    private int id;
    private String SBLS;
    private String ST;
    private String STE;
    private double GCAL;
    private double GJ;
    private double GCALZB;
    private double GJZB;
    private double ZW;
    private double ZE;
    private double ZF;
    private double ZK;
    private double ZB;
    private double ZM;
    private double ZO;
    private double ZA;
    private double VA;
    private double VAR;
    private double VAC;
    private double VD;
    private double VE;
    private double VEAT;
    private double VK;
    private double VB1;
    private double VB2;
    private double VB3;
    private double VB3A;
    private double VB5;
    private double VB6;
    private double VB7;
    private double VB9G;
    private double VB12;
    private double VC;
    private double MNA;
    private double MK;
    private double MCA;
    private double MMG;
    private double MP;
    private double MS;
    private double MCL;
    private double MFE;
    private double MZN;
    private double MCU;
    private double MMN;
    private double MF;
    private double MJ;
    private double KAM;
    private double KAS;
    private double KAX;
    private double KA;
    private double KMT;
    private double KMF;
    private double KMG;
    private double KM;
    private double KDS;
    private double KDM;
    private double KDL;
    private double KD;
    private double KMD;
    private double KPOR;
    private double KPON;
    private double KPG;
    private double KPS;
    private double KP;
    private double KBP;
    private double KBH;
    private double KBU;
    private double KBC;
    private double KBL;
    private double KBW;
    private double KBN;
    private double EILE;
    private double ELEU;
    private double ELYS;
    private double EMET;
    private double ECYS;
    private double EPHE;
    private double ETYR;
    private double ETHR;
    private double ETRP;
    private double EVAL;
    private double EARG;
    private double EHIS;
    private double EEA;
    private double EALA;
    private double EASP;
    private double EGLU;
    private double EGLY;
    private double EPRO;
    private double ESER;
    private double ENA;
    private double EH;
    private double EP;
    private double F40;
    private double F60;
    private double F80;
    private double F100;
    private double F120;
    private double F140;
    private double F150;
    private double F160;
    private double F170;
    private double F180;
    private double F200;
    private double F220;
    private double F240;
    private double FS;
    private double F141;
    private double F151;
    private double F161;
    private double F171;
    private double F181;
    private double F201;
    private double F221;
    private double F241;
    private double FU;
    private double F162;
    private double F164;
    private double F182;
    private double F183;
    private double F184;
    private double F193;
    private double F202;
    private double F203;
    private double F204;
    private double F205;
    private double F222;
    private double F223;
    private double F224;
    private double F225;
    private double F226;
    private double FP;
    private double FK;
    private double FM;
    private double FL;
    private double FO3;
    private double FO6;
    private double FG;
    private double FC;
    private double GFPS;
    private double GKB;
    private double GMKO;
    private double GP;
    
    @OneToMany(mappedBy = "bls", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Zutat> zutaten = new ArrayList<>();

  
    
    
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    

    

    
}
