package de.ml.foodcare.model;

import de.ml.foodcare.model.gericht.Zutat;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mathi
 */
@Entity
@Table(name = "bls")
public class BLS  implements Serializable{
    
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
    
    @OneToMany(mappedBy = "bls")
    private List<Zutat> zutaten = new ArrayList<>();

    public BLS() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSBLS() {
        return SBLS;
    }

    public void setSBLS(String SBLS) {
        this.SBLS = SBLS;
    }

    public String getST() {
        return ST;
    }

    public void setST(String ST) {
        this.ST = ST;
    }

    public String getSTE() {
        return STE;
    }

    public void setSTE(String STE) {
        this.STE = STE;
    }

    public double getGCAL() {
        return GCAL;
    }

    public void setGCAL(double GCAL) {
        this.GCAL = GCAL;
    }

    public double getGJ() {
        return GJ;
    }

    public void setGJ(double GJ) {
        this.GJ = GJ;
    }

    public double getGCALZB() {
        return GCALZB;
    }

    public void setGCALZB(double GCALZB) {
        this.GCALZB = GCALZB;
    }

    public double getGJZB() {
        return GJZB;
    }

    public void setGJZB(double GJZB) {
        this.GJZB = GJZB;
    }

    public double getZW() {
        return ZW;
    }

    public void setZW(double ZW) {
        this.ZW = ZW;
    }

    public double getZE() {
        return ZE;
    }

    public void setZE(double ZE) {
        this.ZE = ZE;
    }

    public double getZF() {
        return ZF;
    }

    public void setZF(double ZF) {
        this.ZF = ZF;
    }

    public double getZK() {
        return ZK;
    }

    public void setZK(double ZK) {
        this.ZK = ZK;
    }

    public double getZB() {
        return ZB;
    }

    public void setZB(double ZB) {
        this.ZB = ZB;
    }

    public double getZM() {
        return ZM;
    }

    public void setZM(double ZM) {
        this.ZM = ZM;
    }

    public double getZO() {
        return ZO;
    }

    public void setZO(double ZO) {
        this.ZO = ZO;
    }

    public double getZA() {
        return ZA;
    }

    public void setZA(double ZA) {
        this.ZA = ZA;
    }

    public double getVA() {
        return VA;
    }

    public void setVA(double VA) {
        this.VA = VA;
    }

    public double getVAR() {
        return VAR;
    }

    public void setVAR(double VAR) {
        this.VAR = VAR;
    }

    public double getVAC() {
        return VAC;
    }

    public void setVAC(double VAC) {
        this.VAC = VAC;
    }

    public double getVD() {
        return VD;
    }

    public void setVD(double VD) {
        this.VD = VD;
    }

    public double getVE() {
        return VE;
    }

    public void setVE(double VE) {
        this.VE = VE;
    }

    public double getVEAT() {
        return VEAT;
    }

    public void setVEAT(double VEAT) {
        this.VEAT = VEAT;
    }

    public double getVK() {
        return VK;
    }

    public void setVK(double VK) {
        this.VK = VK;
    }

    public double getVB1() {
        return VB1;
    }

    public void setVB1(double VB1) {
        this.VB1 = VB1;
    }

    public double getVB2() {
        return VB2;
    }

    public void setVB2(double VB2) {
        this.VB2 = VB2;
    }

    public double getVB3() {
        return VB3;
    }

    public void setVB3(double VB3) {
        this.VB3 = VB3;
    }

    public double getVB3A() {
        return VB3A;
    }

    public void setVB3A(double VB3A) {
        this.VB3A = VB3A;
    }

    public double getVB5() {
        return VB5;
    }

    public void setVB5(double VB5) {
        this.VB5 = VB5;
    }

    public double getVB6() {
        return VB6;
    }

    public void setVB6(double VB6) {
        this.VB6 = VB6;
    }

    public double getVB7() {
        return VB7;
    }

    public void setVB7(double VB7) {
        this.VB7 = VB7;
    }

    public double getVB9G() {
        return VB9G;
    }

    public void setVB9G(double VB9G) {
        this.VB9G = VB9G;
    }

    public double getVB12() {
        return VB12;
    }

    public void setVB12(double VB12) {
        this.VB12 = VB12;
    }

    public double getVC() {
        return VC;
    }

    public void setVC(double VC) {
        this.VC = VC;
    }

    public double getMNA() {
        return MNA;
    }

    public void setMNA(double MNA) {
        this.MNA = MNA;
    }

    public double getMK() {
        return MK;
    }

    public void setMK(double MK) {
        this.MK = MK;
    }

    public double getMCA() {
        return MCA;
    }

    public void setMCA(double MCA) {
        this.MCA = MCA;
    }

    public double getMMG() {
        return MMG;
    }

    public void setMMG(double MMG) {
        this.MMG = MMG;
    }

    public double getMP() {
        return MP;
    }

    public void setMP(double MP) {
        this.MP = MP;
    }

    public double getMS() {
        return MS;
    }

    public void setMS(double MS) {
        this.MS = MS;
    }

    public double getMCL() {
        return MCL;
    }

    public void setMCL(double MCL) {
        this.MCL = MCL;
    }

    public double getMFE() {
        return MFE;
    }

    public void setMFE(double MFE) {
        this.MFE = MFE;
    }

    public double getMZN() {
        return MZN;
    }

    public void setMZN(double MZN) {
        this.MZN = MZN;
    }

    public double getMCU() {
        return MCU;
    }

    public void setMCU(double MCU) {
        this.MCU = MCU;
    }

    public double getMMN() {
        return MMN;
    }

    public void setMMN(double MMN) {
        this.MMN = MMN;
    }

    public double getMF() {
        return MF;
    }

    public void setMF(double MF) {
        this.MF = MF;
    }

    public double getMJ() {
        return MJ;
    }

    public void setMJ(double MJ) {
        this.MJ = MJ;
    }

    public double getKAM() {
        return KAM;
    }

    public void setKAM(double KAM) {
        this.KAM = KAM;
    }

    public double getKAS() {
        return KAS;
    }

    public void setKAS(double KAS) {
        this.KAS = KAS;
    }

    public double getKAX() {
        return KAX;
    }

    public void setKAX(double KAX) {
        this.KAX = KAX;
    }

    public double getKA() {
        return KA;
    }

    public void setKA(double KA) {
        this.KA = KA;
    }

    public double getKMT() {
        return KMT;
    }

    public void setKMT(double KMT) {
        this.KMT = KMT;
    }

    public double getKMF() {
        return KMF;
    }

    public void setKMF(double KMF) {
        this.KMF = KMF;
    }

    public double getKMG() {
        return KMG;
    }

    public void setKMG(double KMG) {
        this.KMG = KMG;
    }

    public double getKM() {
        return KM;
    }

    public void setKM(double KM) {
        this.KM = KM;
    }

    public double getKDS() {
        return KDS;
    }

    public void setKDS(double KDS) {
        this.KDS = KDS;
    }

    public double getKDM() {
        return KDM;
    }

    public void setKDM(double KDM) {
        this.KDM = KDM;
    }

    public double getKDL() {
        return KDL;
    }

    public void setKDL(double KDL) {
        this.KDL = KDL;
    }

    public double getKD() {
        return KD;
    }

    public void setKD(double KD) {
        this.KD = KD;
    }

    public double getKMD() {
        return KMD;
    }

    public void setKMD(double KMD) {
        this.KMD = KMD;
    }

    public double getKPOR() {
        return KPOR;
    }

    public void setKPOR(double KPOR) {
        this.KPOR = KPOR;
    }

    public double getKPON() {
        return KPON;
    }

    public void setKPON(double KPON) {
        this.KPON = KPON;
    }

    public double getKPG() {
        return KPG;
    }

    public void setKPG(double KPG) {
        this.KPG = KPG;
    }

    public double getKPS() {
        return KPS;
    }

    public void setKPS(double KPS) {
        this.KPS = KPS;
    }

    public double getKP() {
        return KP;
    }

    public void setKP(double KP) {
        this.KP = KP;
    }

    public double getKBP() {
        return KBP;
    }

    public void setKBP(double KBP) {
        this.KBP = KBP;
    }

    public double getKBH() {
        return KBH;
    }

    public void setKBH(double KBH) {
        this.KBH = KBH;
    }

    public double getKBU() {
        return KBU;
    }

    public void setKBU(double KBU) {
        this.KBU = KBU;
    }

    public double getKBC() {
        return KBC;
    }

    public void setKBC(double KBC) {
        this.KBC = KBC;
    }

    public double getKBL() {
        return KBL;
    }

    public void setKBL(double KBL) {
        this.KBL = KBL;
    }

    public double getKBW() {
        return KBW;
    }

    public void setKBW(double KBW) {
        this.KBW = KBW;
    }

    public double getKBN() {
        return KBN;
    }

    public void setKBN(double KBN) {
        this.KBN = KBN;
    }

    public double getEILE() {
        return EILE;
    }

    public void setEILE(double EILE) {
        this.EILE = EILE;
    }

    public double getELEU() {
        return ELEU;
    }

    public void setELEU(double ELEU) {
        this.ELEU = ELEU;
    }

    public double getELYS() {
        return ELYS;
    }

    public void setELYS(double ELYS) {
        this.ELYS = ELYS;
    }

    public double getEMET() {
        return EMET;
    }

    public void setEMET(double EMET) {
        this.EMET = EMET;
    }

    public double getECYS() {
        return ECYS;
    }

    public void setECYS(double ECYS) {
        this.ECYS = ECYS;
    }

    public double getEPHE() {
        return EPHE;
    }

    public void setEPHE(double EPHE) {
        this.EPHE = EPHE;
    }

    public double getETYR() {
        return ETYR;
    }

    public void setETYR(double ETYR) {
        this.ETYR = ETYR;
    }

    public double getETHR() {
        return ETHR;
    }

    public void setETHR(double ETHR) {
        this.ETHR = ETHR;
    }

    public double getETRP() {
        return ETRP;
    }

    public void setETRP(double ETRP) {
        this.ETRP = ETRP;
    }

    public double getEVAL() {
        return EVAL;
    }

    public void setEVAL(double EVAL) {
        this.EVAL = EVAL;
    }

    public double getEARG() {
        return EARG;
    }

    public void setEARG(double EARG) {
        this.EARG = EARG;
    }

    public double getEHIS() {
        return EHIS;
    }

    public void setEHIS(double EHIS) {
        this.EHIS = EHIS;
    }

    public double getEEA() {
        return EEA;
    }

    public void setEEA(double EEA) {
        this.EEA = EEA;
    }

    public double getEALA() {
        return EALA;
    }

    public void setEALA(double EALA) {
        this.EALA = EALA;
    }

    public double getEASP() {
        return EASP;
    }

    public void setEASP(double EASP) {
        this.EASP = EASP;
    }

    public double getEGLU() {
        return EGLU;
    }

    public void setEGLU(double EGLU) {
        this.EGLU = EGLU;
    }

    public double getEGLY() {
        return EGLY;
    }

    public void setEGLY(double EGLY) {
        this.EGLY = EGLY;
    }

    public double getEPRO() {
        return EPRO;
    }

    public void setEPRO(double EPRO) {
        this.EPRO = EPRO;
    }

    public double getESER() {
        return ESER;
    }

    public void setESER(double ESER) {
        this.ESER = ESER;
    }

    public double getENA() {
        return ENA;
    }

    public void setENA(double ENA) {
        this.ENA = ENA;
    }

    public double getEH() {
        return EH;
    }

    public void setEH(double EH) {
        this.EH = EH;
    }

    public double getEP() {
        return EP;
    }

    public void setEP(double EP) {
        this.EP = EP;
    }

    public double getF40() {
        return F40;
    }

    public void setF40(double F40) {
        this.F40 = F40;
    }

    public double getF60() {
        return F60;
    }

    public void setF60(double F60) {
        this.F60 = F60;
    }

    public double getF80() {
        return F80;
    }

    public void setF80(double F80) {
        this.F80 = F80;
    }

    public double getF100() {
        return F100;
    }

    public void setF100(double F100) {
        this.F100 = F100;
    }

    public double getF120() {
        return F120;
    }

    public void setF120(double F120) {
        this.F120 = F120;
    }

    public double getF140() {
        return F140;
    }

    public void setF140(double F140) {
        this.F140 = F140;
    }

    public double getF150() {
        return F150;
    }

    public void setF150(double F150) {
        this.F150 = F150;
    }

    public double getF160() {
        return F160;
    }

    public void setF160(double F160) {
        this.F160 = F160;
    }

    public double getF170() {
        return F170;
    }

    public void setF170(double F170) {
        this.F170 = F170;
    }

    public double getF180() {
        return F180;
    }

    public void setF180(double F180) {
        this.F180 = F180;
    }

    public double getF200() {
        return F200;
    }

    public void setF200(double F200) {
        this.F200 = F200;
    }

    public double getF220() {
        return F220;
    }

    public void setF220(double F220) {
        this.F220 = F220;
    }

    public double getF240() {
        return F240;
    }

    public void setF240(double F240) {
        this.F240 = F240;
    }

    public double getFS() {
        return FS;
    }

    public void setFS(double FS) {
        this.FS = FS;
    }

    public double getF141() {
        return F141;
    }

    public void setF141(double F141) {
        this.F141 = F141;
    }

    public double getF151() {
        return F151;
    }

    public void setF151(double F151) {
        this.F151 = F151;
    }

    public double getF161() {
        return F161;
    }

    public void setF161(double F161) {
        this.F161 = F161;
    }

    public double getF171() {
        return F171;
    }

    public void setF171(double F171) {
        this.F171 = F171;
    }

    public double getF181() {
        return F181;
    }

    public void setF181(double F181) {
        this.F181 = F181;
    }

    public double getF201() {
        return F201;
    }

    public void setF201(double F201) {
        this.F201 = F201;
    }

    public double getF221() {
        return F221;
    }

    public void setF221(double F221) {
        this.F221 = F221;
    }

    public double getF241() {
        return F241;
    }

    public void setF241(double F241) {
        this.F241 = F241;
    }

    public double getFU() {
        return FU;
    }

    public void setFU(double FU) {
        this.FU = FU;
    }

    public double getF162() {
        return F162;
    }

    public void setF162(double F162) {
        this.F162 = F162;
    }

    public double getF164() {
        return F164;
    }

    public void setF164(double F164) {
        this.F164 = F164;
    }

    public double getF182() {
        return F182;
    }

    public void setF182(double F182) {
        this.F182 = F182;
    }

    public double getF183() {
        return F183;
    }

    public void setF183(double F183) {
        this.F183 = F183;
    }

    public double getF184() {
        return F184;
    }

    public void setF184(double F184) {
        this.F184 = F184;
    }

    public double getF193() {
        return F193;
    }

    public void setF193(double F193) {
        this.F193 = F193;
    }

    public double getF202() {
        return F202;
    }

    public void setF202(double F202) {
        this.F202 = F202;
    }

    public double getF203() {
        return F203;
    }

    public void setF203(double F203) {
        this.F203 = F203;
    }

    public double getF204() {
        return F204;
    }

    public void setF204(double F204) {
        this.F204 = F204;
    }

    public double getF205() {
        return F205;
    }

    public void setF205(double F205) {
        this.F205 = F205;
    }

    public double getF222() {
        return F222;
    }

    public void setF222(double F222) {
        this.F222 = F222;
    }

    public double getF223() {
        return F223;
    }

    public void setF223(double F223) {
        this.F223 = F223;
    }

    public double getF224() {
        return F224;
    }

    public void setF224(double F224) {
        this.F224 = F224;
    }

    public double getF225() {
        return F225;
    }

    public void setF225(double F225) {
        this.F225 = F225;
    }

    public double getF226() {
        return F226;
    }

    public void setF226(double F226) {
        this.F226 = F226;
    }

    public double getFP() {
        return FP;
    }

    public void setFP(double FP) {
        this.FP = FP;
    }

    public double getFK() {
        return FK;
    }

    public void setFK(double FK) {
        this.FK = FK;
    }

    public double getFM() {
        return FM;
    }

    public void setFM(double FM) {
        this.FM = FM;
    }

    public double getFL() {
        return FL;
    }

    public void setFL(double FL) {
        this.FL = FL;
    }

    public double getFO3() {
        return FO3;
    }

    public void setFO3(double FO3) {
        this.FO3 = FO3;
    }

    public double getFO6() {
        return FO6;
    }

    public void setFO6(double FO6) {
        this.FO6 = FO6;
    }

    public double getFG() {
        return FG;
    }

    public void setFG(double FG) {
        this.FG = FG;
    }

    public double getFC() {
        return FC;
    }

    public void setFC(double FC) {
        this.FC = FC;
    }

    public double getGFPS() {
        return GFPS;
    }

    public void setGFPS(double GFPS) {
        this.GFPS = GFPS;
    }

    public double getGKB() {
        return GKB;
    }

    public void setGKB(double GKB) {
        this.GKB = GKB;
    }

    public double getGMKO() {
        return GMKO;
    }

    public void setGMKO(double GMKO) {
        this.GMKO = GMKO;
    }

    public double getGP() {
        return GP;
    }

    public void setGP(double GP) {
        this.GP = GP;
    }

    public List<Zutat> getZutaten() {
        return zutaten;
    }

    public void setZutaten(List<Zutat> zutaten) {
        this.zutaten = zutaten;
    }

    @Override
    public String toString() {
        return "BLS{" + "id=" + id + ", SBLS=" + SBLS + ", ST=" + ST + ", STE=" + STE + ", GCAL=" + GCAL + ", GJ=" + GJ + ", GCALZB=" + GCALZB + ", GJZB=" + GJZB + ", ZW=" + ZW + ", ZE=" + ZE + ", ZF=" + ZF + ", ZK=" + ZK + ", ZB=" + ZB + ", ZM=" + ZM + ", ZO=" + ZO + ", ZA=" + ZA + ", VA=" + VA + ", VAR=" + VAR + ", VAC=" + VAC + ", VD=" + VD + ", VE=" + VE + ", VEAT=" + VEAT + ", VK=" + VK + ", VB1=" + VB1 + ", VB2=" + VB2 + ", VB3=" + VB3 + ", VB3A=" + VB3A + ", VB5=" + VB5 + ", VB6=" + VB6 + ", VB7=" + VB7 + ", VB9G=" + VB9G + ", VB12=" + VB12 + ", VC=" + VC + ", MNA=" + MNA + ", MK=" + MK + ", MCA=" + MCA + ", MMG=" + MMG + ", MP=" + MP + ", MS=" + MS + ", MCL=" + MCL + ", MFE=" + MFE + ", MZN=" + MZN + ", MCU=" + MCU + ", MMN=" + MMN + ", MF=" + MF + ", MJ=" + MJ + ", KAM=" + KAM + ", KAS=" + KAS + ", KAX=" + KAX + ", KA=" + KA + ", KMT=" + KMT + ", KMF=" + KMF + ", KMG=" + KMG + ", KM=" + KM + ", KDS=" + KDS + ", KDM=" + KDM + ", KDL=" + KDL + ", KD=" + KD + ", KMD=" + KMD + ", KPOR=" + KPOR + ", KPON=" + KPON + ", KPG=" + KPG + ", KPS=" + KPS + ", KP=" + KP + ", KBP=" + KBP + ", KBH=" + KBH + ", KBU=" + KBU + ", KBC=" + KBC + ", KBL=" + KBL + ", KBW=" + KBW + ", KBN=" + KBN + ", EILE=" + EILE + ", ELEU=" + ELEU + ", ELYS=" + ELYS + ", EMET=" + EMET + ", ECYS=" + ECYS + ", EPHE=" + EPHE + ", ETYR=" + ETYR + ", ETHR=" + ETHR + ", ETRP=" + ETRP + ", EVAL=" + EVAL + ", EARG=" + EARG + ", EHIS=" + EHIS + ", EEA=" + EEA + ", EALA=" + EALA + ", EASP=" + EASP + ", EGLU=" + EGLU + ", EGLY=" + EGLY + ", EPRO=" + EPRO + ", ESER=" + ESER + ", ENA=" + ENA + ", EH=" + EH + ", EP=" + EP + ", F40=" + F40 + ", F60=" + F60 + ", F80=" + F80 + ", F100=" + F100 + ", F120=" + F120 + ", F140=" + F140 + ", F150=" + F150 + ", F160=" + F160 + ", F170=" + F170 + ", F180=" + F180 + ", F200=" + F200 + ", F220=" + F220 + ", F240=" + F240 + ", FS=" + FS + ", F141=" + F141 + ", F151=" + F151 + ", F161=" + F161 + ", F171=" + F171 + ", F181=" + F181 + ", F201=" + F201 + ", F221=" + F221 + ", F241=" + F241 + ", FU=" + FU + ", F162=" + F162 + ", F164=" + F164 + ", F182=" + F182 + ", F183=" + F183 + ", F184=" + F184 + ", F193=" + F193 + ", F202=" + F202 + ", F203=" + F203 + ", F204=" + F204 + ", F205=" + F205 + ", F222=" + F222 + ", F223=" + F223 + ", F224=" + F224 + ", F225=" + F225 + ", F226=" + F226 + ", FP=" + FP + ", FK=" + FK + ", FM=" + FM + ", FL=" + FL + ", FO3=" + FO3 + ", FO6=" + FO6 + ", FG=" + FG + ", FC=" + FC + ", GFPS=" + GFPS + ", GKB=" + GKB + ", GMKO=" + GMKO + ", GP=" + GP + '}';
    }
    
    
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    

    

    
}
