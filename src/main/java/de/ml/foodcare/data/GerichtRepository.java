package de.ml.foodcare.data;

import de.ml.foodcare.auth.User;
import de.ml.foodcare.model.gericht.Gericht;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;

/**
 *
 * @author mathi
 */
public interface GerichtRepository extends ListCrudRepository<Gericht, Long>{
    
    @Query("select case when count(g)> 0 then true else false end from Gericht g where g.titel = :titel and g.kategorie = :kategorie")
    boolean existsGerichtByTitelKategorie(String titel, String kategorie);
    
    boolean existsGerichtByTitelAndKategorie(String titel, String kategorie);
    
    @Query("SELECT DISTINCT g.kategorie FROM Gericht as g")
    List<String> findDistinctKategorie();
    
    @Query("SELECT DISTINCT g.kategorie FROM Gericht as g WHERE g.user.username = :username")
    List<String> findDistinctKategorieByUsername(String username);
    
    List<Gericht> findByUser(User user);
    
//    @Query(value = "SELECT new de.ml.foodcare.model.Naehrstoffe( SUM(b.GCAL * z.menge / 100) as GCAL, SUM(b.GJ * z.menge / 100) as GJ, SUM(b.GCALZB * z.menge / 100) as GCALZB, SUM(b.GJZB * z.menge / 100) as GJZB, SUM(b.ZW * z.menge / 100) as ZW, SUM(b.ZE * z.menge / 100) as ZE, SUM(b.ZF * z.menge / 100) as ZF, SUM(b.ZK * z.menge / 100) as ZK, SUM(b.ZB * z.menge / 100) as ZB, SUM(b.ZM * z.menge / 100) as ZM, SUM(b.ZO * z.menge / 100) as ZO, SUM(b.ZA * z.menge / 100) as ZA, SUM(b.VA * z.menge / 100) as VA, SUM(b.VAR * z.menge / 100) as VAR, SUM(b.VAC * z.menge / 100) as VAC, SUM(b.VD * z.menge / 100) as VD, SUM(b.VE * z.menge / 100) as VE, SUM(b.VEAT * z.menge / 100) as VEAT, SUM(b.VK * z.menge / 100) as VK, SUM(b.VB1 * z.menge / 100) as VB1, SUM(b.VB2 * z.menge / 100) as VB2, SUM(b.VB3 * z.menge / 100) as VB3, SUM(b.VB3A * z.menge / 100) as VB3A, SUM(b.VB5 * z.menge / 100) as VB5, SUM(b.VB6 * z.menge / 100) as VB6, SUM(b.VB7 * z.menge / 100) as VB7, SUM(b.VB9G * z.menge / 100) as VB9G, SUM(b.VB12 * z.menge / 100) as VB12, SUM(b.VC * z.menge / 100) as VC, SUM(b.MNA * z.menge / 100) as MNA, SUM(b.MK * z.menge / 100) as MK, SUM(b.MCA * z.menge / 100) as MCA, SUM(b.MMG * z.menge / 100) as MMG, SUM(b.MP * z.menge / 100) as MP, SUM(b.MS * z.menge / 100) as MS, SUM(b.MCL * z.menge / 100) as MCL, SUM(b.MFE * z.menge / 100) as MFE, SUM(b.MZN * z.menge / 100) as MZN, SUM(b.MCU * z.menge / 100) as MCU, SUM(b.MMN * z.menge / 100) as MMN, SUM(b.MF * z.menge / 100) as MF, SUM(b.MJ * z.menge / 100) as MJ, SUM(b.KAM * z.menge / 100) as KAM, SUM(b.KAS * z.menge / 100) as KAS, SUM(b.KAX * z.menge / 100) as KAX, SUM(b.KA * z.menge / 100) as KA, SUM(b.KMT * z.menge / 100) as KMT, SUM(b.KMF * z.menge / 100) as KMF, SUM(b.KMG * z.menge / 100) as KMG, SUM(b.KM * z.menge / 100) as KM, SUM(b.KDS * z.menge / 100) as KDS, SUM(b.KDM * z.menge / 100) as KDM, SUM(b.KDL * z.menge / 100) as KDL, SUM(b.KD * z.menge / 100) as KD, SUM(b.KMD * z.menge / 100) as KMD, SUM(b.KPOR * z.menge / 100) as KPOR, SUM(b.KPON * z.menge / 100) as KPON, SUM(b.KPG * z.menge / 100) as KPG, SUM(b.KPS * z.menge / 100) as KPS, SUM(b.KP * z.menge / 100) as KP, SUM(b.KBP * z.menge / 100) as KBP, SUM(b.KBH * z.menge / 100) as KBH, SUM(b.KBU * z.menge / 100) as KBU, SUM(b.KBC * z.menge / 100) as KBC, SUM(b.KBL * z.menge / 100) as KBL, SUM(b.KBW * z.menge / 100) as KBW, SUM(b.KBN * z.menge / 100) as KBN ) FROM Zutat z JOIN z.bls b WHERE z.gericht.id = :gerichtId ")
//    Optional<Naehrstoffe> findSumNaehrstoffeByGerichtId(@Param("gerichtId") Long gerichtId);
//    
//    @Query(value = "SELECT new de.ml.foodcare.model.Naehrstoffe2( SUM(b.EILE * z.menge / 100) as EILE, SUM(b.ELEU * z.menge / 100) as ELEU, SUM(b.ELYS * z.menge / 100) as ELYS, SUM(b.EMET * z.menge / 100) as EMET, SUM(b.ECYS * z.menge / 100) as ECYS, SUM(b.EPHE * z.menge / 100) as EPHE, SUM(b.ETYR * z.menge / 100) as ETYR, SUM(b.ETHR * z.menge / 100) as ETHR, SUM(b.ETRP * z.menge / 100) as ETRP, SUM(b.EVAL * z.menge / 100) as EVAL, SUM(b.EARG * z.menge / 100) as EARG, SUM(b.EHIS * z.menge / 100) as EHIS, SUM(b.EEA * z.menge / 100) as EEA, SUM(b.EALA * z.menge / 100) as EALA, SUM(b.EASP * z.menge / 100) as EASP, SUM(b.EGLU * z.menge / 100) as EGLU, SUM(b.EGLY * z.menge / 100) as EGLY, SUM(b.EPRO * z.menge / 100) as EPRO, SUM(b.ESER * z.menge / 100) as ESER, SUM(b.ENA * z.menge / 100) as ENA, SUM(b.EH * z.menge / 100) as EH, SUM(b.EP * z.menge / 100) as EP, SUM(b.F40 * z.menge / 100) as F40, SUM(b.F60 * z.menge / 100) as F60, SUM(b.F80 * z.menge / 100) as F80, SUM(b.F100 * z.menge / 100) as F100, SUM(b.F120 * z.menge / 100) as F120, SUM(b.F140 * z.menge / 100) as F140, SUM(b.F150 * z.menge / 100) as F150, SUM(b.F160 * z.menge / 100) as F160, SUM(b.F170 * z.menge / 100) as F170, SUM(b.F180 * z.menge / 100) as F180, SUM(b.F200 * z.menge / 100) as F200, SUM(b.F220 * z.menge / 100) as F220, SUM(b.F240 * z.menge / 100) as F240, SUM(b.FS * z.menge / 100) as FS, SUM(b.F141 * z.menge / 100) as F141, SUM(b.F151 * z.menge / 100) as F151, SUM(b.F161 * z.menge / 100) as F161, SUM(b.F171 * z.menge / 100) as F171, SUM(b.F181 * z.menge / 100) as F181, SUM(b.F201 * z.menge / 100) as F201, SUM(b.F221 * z.menge / 100) as F221, SUM(b.F241 * z.menge / 100) as F241, SUM(b.FU * z.menge / 100) as FU, SUM(b.F162 * z.menge / 100) as F162, SUM(b.F164 * z.menge / 100) as F164, SUM(b.F182 * z.menge / 100) as F182, SUM(b.F183 * z.menge / 100) as F183, SUM(b.F184 * z.menge / 100) as F184, SUM(b.F193 * z.menge / 100) as F193, SUM(b.F202 * z.menge / 100) as F202, SUM(b.F203 * z.menge / 100) as F203, SUM(b.F204 * z.menge / 100) as F204, SUM(b.F205 * z.menge / 100) as F205, SUM(b.F222 * z.menge / 100) as F222, SUM(b.F223 * z.menge / 100) as F223, SUM(b.F224 * z.menge / 100) as F224, SUM(b.F225 * z.menge / 100) as F225, SUM(b.F226 * z.menge / 100) as F226, SUM(b.FP * z.menge / 100) as FP, SUM(b.FM * z.menge / 100) as FM, SUM(b.FL * z.menge / 100) as FL, SUM(b.FO3 * z.menge / 100) as FO3, SUM(b.FO6 * z.menge / 100) as FO6, SUM(b.FG * z.menge / 100) as FG, SUM(b.FC * z.menge / 100) as FC, SUM(b.GFPS * z.menge / 100) as GFPS, SUM(b.GKB * z.menge / 100) as GKB, SUM(b.GMKO * z.menge / 100) as GMKO, SUM(b.GP * z.menge / 100) as GP ) FROM Zutat z JOIN z.bls b WHERE z.gericht.id = :gerichtId ")
//    Optional<Naehrstoffe2> findSumNaehrstoffe2ByGerichtId(@Param("gerichtId") Long gerichtId);
}
