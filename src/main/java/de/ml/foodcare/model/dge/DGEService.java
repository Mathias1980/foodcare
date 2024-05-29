package de.ml.foodcare.model.dge;

import de.ml.foodcare.auth.User;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author mathi
 */

@Service
public class DGEService {
    
    private final List<Energie> energie = new ArrayList<>();
    private final List<EnergieReferenz> eref = new ArrayList<>();
    private final List<Protein> proteine = new ArrayList<>();
    private final List<FettEF> fette = new ArrayList<>();
    private final List<Ballaststoffe> blst = new ArrayList<>();
    private final List<Mengenelement> mengene = new ArrayList<>();
    private final List<Spurenelement> spur = new ArrayList<>();
    private final List<Vitamin> vitamine = new ArrayList<>();
    private final List<Wasser> wasser = new ArrayList<>();
    
    // private static final Logger log = LoggerFactory.getLogger(DGEService.class);
    
    public DGEService() {      
        
        energie.add(new Energie(1, 4, 1.4, "m", 1200));
        energie.add(new Energie(4, 7, 1.4, "m", 1400));
        energie.add(new Energie(7, 10, 1.4, "m", 1700));
        energie.add(new Energie(10, 13, 1.4, "m", 1900));
        energie.add(new Energie(13, 15, 1.4, "m", 2300));
        energie.add(new Energie(15, 19, 1.4, "m", 2600));
        energie.add(new Energie(19, 25, 1.4, "m", 2400));
        energie.add(new Energie(25, 51, 1.4, "m", 2300));
        energie.add(new Energie(51, 65, 1.4, "m", 2200));
        energie.add(new Energie(65, 99, 1.4, "m", 2100));
        energie.add(new Energie(200, 200, 1.4, "m", 1200));
        energie.add(new Energie(300, 300, 1.4, "m", 1200));
        
        energie.add(new Energie(1, 4, 1.4, "w", 1100));
        energie.add(new Energie(4, 7, 1.4, "w", 1300));
        energie.add(new Energie(7, 10, 1.4, "w", 1500));
        energie.add(new Energie(10, 13, 1.4, "w", 1700));
        energie.add(new Energie(13, 15, 1.4, "w", 1900));
        energie.add(new Energie(15, 19, 1.4, "w", 2000));
        energie.add(new Energie(19, 25, 1.4, "w", 1900));
        energie.add(new Energie(25, 51, 1.4, "w", 1800));
        energie.add(new Energie(51, 65, 1.4, "w", 1700));
        energie.add(new Energie(65, 99, 1.4, "w", 1700));
        energie.add(new Energie(200, 200, 1.4, "w", 2200));
        energie.add(new Energie(300, 300, 1.4, "w", 2200));
        
        energie.add(new Energie(1, 4, 1.6, "m", 1300));
        energie.add(new Energie(4, 7, 1.6, "m", 1600));
        energie.add(new Energie(7, 10, 1.6, "m", 1900));
        energie.add(new Energie(10, 13, 1.6, "m", 2200));
        energie.add(new Energie(13, 15, 1.6, "m", 2600));
        energie.add(new Energie(15, 19, 1.6, "m", 3000));
        energie.add(new Energie(19, 25, 1.6, "m", 2800));
        energie.add(new Energie(25, 51, 1.6, "m", 2700));
        energie.add(new Energie(51, 65, 1.6, "m", 2500));
        energie.add(new Energie(65, 99, 1.6, "m", 2500));
        energie.add(new Energie(200, 200, 1.6, "m", 0));
        energie.add(new Energie(300, 300, 1.6, "m", 0));
        
        energie.add(new Energie(1, 4, 1.6, "w", 1200));
        energie.add(new Energie(4, 7, 1.6, "w", 1500));
        energie.add(new Energie(7, 10, 1.6, "w", 1800));
        energie.add(new Energie(10, 13, 1.6, "w", 2000));
        energie.add(new Energie(13, 15, 1.6, "w", 2200));
        energie.add(new Energie(15, 19, 1.6, "w", 2300));
        energie.add(new Energie(19, 25, 1.6, "w", 2200));
        energie.add(new Energie(25, 51, 1.6, "w", 2100));
        energie.add(new Energie(51, 65, 1.6, "w", 2000));
        energie.add(new Energie(65, 99, 1.6, "w", 1900));
        energie.add(new Energie(200, 200, 1.6, "w", 2300));
        energie.add(new Energie(300, 300, 1.6, "w", 2300));
        
        energie.add(new Energie(1, 4, 1.8, "m", 0));
        energie.add(new Energie(4, 7, 1.8, "m", 1800));
        energie.add(new Energie(7, 10, 1.8, "m", 2100));
        energie.add(new Energie(10, 13, 1.8, "m", 2400));
        energie.add(new Energie(13, 15, 1.8, "m", 2900));
        energie.add(new Energie(15, 19, 1.8, "m", 3400));
        energie.add(new Energie(19, 25, 1.8, "m", 3100));
        energie.add(new Energie(25, 51, 1.8, "m", 3000));
        energie.add(new Energie(51, 65, 1.8, "m", 2800));
        energie.add(new Energie(65, 99, 1.8, "m", 2800));
        energie.add(new Energie(200, 200, 1.8, "m", 0));
        energie.add(new Energie(300, 300, 1.8, "m", 0));
        
        energie.add(new Energie(1, 4, 1.8, "w", 0));
        energie.add(new Energie(4, 7, 1.8, "w", 1700));
        energie.add(new Energie(7, 10, 1.8, "w", 2000));
        energie.add(new Energie(10, 13, 1.8, "w", 2200));
        energie.add(new Energie(13, 15, 1.8, "w", 2500));
        energie.add(new Energie(15, 19, 1.8, "w", 2600));
        energie.add(new Energie(19, 25, 1.8, "w", 2500));
        energie.add(new Energie(25, 51, 1.8, "w", 2400));
        energie.add(new Energie(51, 65, 1.8, "w", 2200));
        energie.add(new Energie(65, 99, 1.8, "w", 2100));
        energie.add(new Energie(200, 200, 1.8, "w", 2400));
        energie.add(new Energie(300, 300, 1.8, "w", 2400));
        
        eref.add(new EnergieReferenz(1, 4, 92.9, "cm", "m"));
        eref.add(new EnergieReferenz(4, 7, 114.5, "cm", "m"));
        eref.add(new EnergieReferenz(7, 10, 133.6, "cm", "m"));
        eref.add(new EnergieReferenz(10, 13, 149.4, "cm", "m"));
        eref.add(new EnergieReferenz(13, 15, 166.9, "cm", "m"));
        eref.add(new EnergieReferenz(15, 19, 178.2, "cm", "m"));
        eref.add(new EnergieReferenz(19, 25, 179.4, "cm", "m"));
        eref.add(new EnergieReferenz(25, 51, 179.2, "cm", "m"));
        eref.add(new EnergieReferenz(51, 65, 176.7, "cm", "m"));
        eref.add(new EnergieReferenz(65, 99, 174.2, "cm", "m"));
        
        eref.add(new EnergieReferenz(1, 4, 91.3, "cm", "w"));
        eref.add(new EnergieReferenz(4, 7, 114.3, "cm", "w"));
        eref.add(new EnergieReferenz(7, 10, 132.4, "cm", "w"));
        eref.add(new EnergieReferenz(10, 13, 151.0, "cm", "w"));
        eref.add(new EnergieReferenz(13, 15, 162.7, "cm", "w"));
        eref.add(new EnergieReferenz(15, 19, 165.5, "cm", "w"));
        eref.add(new EnergieReferenz(19, 25, 165.8, "cm", "w"));
        eref.add(new EnergieReferenz(25, 51, 165.1, "cm", "w"));
        eref.add(new EnergieReferenz(51, 65, 162.6, "cm", "w"));
        eref.add(new EnergieReferenz(65, 99, 161.1, "cm", "w"));
        
        eref.add(new EnergieReferenz(1, 4, 13.9, "kg", "m"));
        eref.add(new EnergieReferenz(4, 7, 20.2, "kg", "m"));
        eref.add(new EnergieReferenz(7, 10, 29.3, "kg", "m"));
        eref.add(new EnergieReferenz(10, 13, 41.0, "kg", "m"));
        eref.add(new EnergieReferenz(13, 15, 55.5, "kg", "m"));
        eref.add(new EnergieReferenz(15, 19, 69.2, "kg", "m"));
        eref.add(new EnergieReferenz(19, 25, 70.8, "kg", "m"));
        eref.add(new EnergieReferenz(25, 51, 70.7, "kg", "m"));
        eref.add(new EnergieReferenz(51, 65, 68.7, "kg", "m"));
        eref.add(new EnergieReferenz(65, 99, 66.8, "kg", "m"));
        
        eref.add(new EnergieReferenz(1, 4, 13.2, "kg", "w"));
        eref.add(new EnergieReferenz(4, 7, 20.1, "kg", "w"));
        eref.add(new EnergieReferenz(7, 10, 28.7, "kg", "w"));
        eref.add(new EnergieReferenz(10, 13, 42.1, "kg", "w"));
        eref.add(new EnergieReferenz(13, 15, 54, "kg", "w"));
        eref.add(new EnergieReferenz(15, 19, 59.5, "kg", "w"));
        eref.add(new EnergieReferenz(19, 25, 60.5, "kg", "w"));
        eref.add(new EnergieReferenz(25, 51, 60, "kg", "w"));
        eref.add(new EnergieReferenz(51, 65, 58.2, "kg", "w"));
        eref.add(new EnergieReferenz(65, 99, 57.1, "kg", "w"));
        
        proteine.add(new Protein(1, 4, "m", 1));
        proteine.add(new Protein(4, 7, "m", 0.9));
        proteine.add(new Protein(7, 10, "m", 0.9));
        proteine.add(new Protein(10, 13, "m", 0.9));
        proteine.add(new Protein(13, 15, "m", 0.9));
        proteine.add(new Protein(15, 19, "m", 0.9));
        proteine.add(new Protein(19, 25, "m", 0.8));
        proteine.add(new Protein(25, 51, "m", 0.8));
        proteine.add(new Protein(51, 65, "m", 0.8));
        proteine.add(new Protein(65, 99, "m", 1));
        
        proteine.add(new Protein(1, 4, "w", 1));
        proteine.add(new Protein(4, 7, "w", 0.9));
        proteine.add(new Protein(7, 10, "w", 0.9));
        proteine.add(new Protein(10, 13, "w", 0.9));
        proteine.add(new Protein(13, 15, "w", 0.9));
        proteine.add(new Protein(15, 19, "w", 0.8));
        proteine.add(new Protein(19, 25, "w", 0.8));
        proteine.add(new Protein(25, 51, "w", 0.8));
        proteine.add(new Protein(51, 65, "w", 0.8));
        proteine.add(new Protein(65, 99, "w", 1));
        
        fette.add(new FettEF(1, 4, 35, 3, 0.5));
        fette.add(new FettEF(4, 7, 33, 2.5, 0.5));
        fette.add(new FettEF(7, 10, 33, 2.5, 0.5));
        fette.add(new FettEF(10, 13, 33, 2.5, 0.5));
        fette.add(new FettEF(13, 15, 33, 2.5, 0.5));
        fette.add(new FettEF(15, 19, 30, 2.5, 0.5));
        fette.add(new FettEF(19, 25, 30, 2.5, 0.5));
        fette.add(new FettEF(25, 51, 30, 2.5, 0.5));
        fette.add(new FettEF(51, 65, 30, 2.5, 0.5));
        fette.add(new FettEF(65, 99, 30, 2.5, 0.5));
        fette.add(new FettEF(200, 200, 33, 2.5, 0.5));
        fette.add(new FettEF(300, 300, 33, 2.5, 0.5));
        
        blst.add(new Ballaststoffe(1, 300, 14.6));
        
        mengene.add(new Mengenelement("Natrium", 1, 4, 400, "mg", "d"));
        mengene.add(new Mengenelement("Natrium", 4, 7, 500, "mg", "d"));
        mengene.add(new Mengenelement("Natrium", 7, 10, 750, "mg", "d"));
        mengene.add(new Mengenelement("Natrium", 10, 13, 1100, "mg", "d"));
        mengene.add(new Mengenelement("Natrium", 13, 15, 1400, "mg", "d"));
        mengene.add(new Mengenelement("Natrium", 15, 19, 1500, "mg", "d"));
        mengene.add(new Mengenelement("Natrium", 19, 25, 1500, "mg", "d"));
        mengene.add(new Mengenelement("Natrium", 25, 51, 1500, "mg", "d"));
        mengene.add(new Mengenelement("Natrium", 51, 65, 1500, "mg", "d"));
        mengene.add(new Mengenelement("Natrium", 65, 99, 1500, "mg", "d"));
        mengene.add(new Mengenelement("Natrium", 200, 200, 1500, "mg", "d"));
        mengene.add(new Mengenelement("Natrium", 300, 300, 1500, "mg", "d"));
        
        mengene.add(new Mengenelement("Chlorid", 1, 4, 600, "mg", "d"));
        mengene.add(new Mengenelement("Chlorid", 4, 7, 650, "mg", "d"));
        mengene.add(new Mengenelement("Chlorid", 7, 10, 750, "mg", "d"));
        mengene.add(new Mengenelement("Chlorid", 10, 13, 1150, "mg", "d"));
        mengene.add(new Mengenelement("Chlorid", 13, 15, 1700, "mg", "d"));
        mengene.add(new Mengenelement("Chlorid", 15, 19, 2150, "mg", "d"));
        mengene.add(new Mengenelement("Chlorid", 19, 25, 2300, "mg", "d"));
        mengene.add(new Mengenelement("Chlorid", 25, 51, 2300, "mg", "d"));
        mengene.add(new Mengenelement("Chlorid", 51, 65, 2300, "mg", "d"));
        mengene.add(new Mengenelement("Chlorid", 65, 99, 2300, "mg", "d"));
        mengene.add(new Mengenelement("Chlorid", 200, 200, 2300, "mg", "d"));
        mengene.add(new Mengenelement("Chlorid", 300, 300, 2300, "mg", "d"));
        
        mengene.add(new Mengenelement("Kalium", 1, 4, 1100, "mg", "d"));
        mengene.add(new Mengenelement("Kalium", 4, 7, 1300, "mg", "d"));
        mengene.add(new Mengenelement("Kalium", 7, 10, 2000, "mg", "d"));
        mengene.add(new Mengenelement("Kalium", 10, 13, 2900, "mg", "d"));
        mengene.add(new Mengenelement("Kalium", 13, 15, 3600, "mg", "d"));
        mengene.add(new Mengenelement("Kalium", 15, 19, 4000, "mg", "d"));
        mengene.add(new Mengenelement("Kalium", 19, 25, 4000, "mg", "d"));
        mengene.add(new Mengenelement("Kalium", 25, 51, 4000, "mg", "d"));
        mengene.add(new Mengenelement("Kalium", 51, 65, 4000, "mg", "d"));
        mengene.add(new Mengenelement("Kalium", 65, 99, 4000, "mg", "d"));
        mengene.add(new Mengenelement("Kalium", 200, 200, 4000, "mg", "d"));
        mengene.add(new Mengenelement("Kalium", 300, 300, 4000, "mg", "d"));
        
        mengene.add(new Mengenelement("Calcium", 1, 4, 600, "mg", "d"));
        mengene.add(new Mengenelement("Calcium", 4, 7, 750, "mg", "d"));
        mengene.add(new Mengenelement("Calcium", 7, 10, 900, "mg", "d"));
        mengene.add(new Mengenelement("Calcium", 10, 13, 1100, "mg", "d"));
        mengene.add(new Mengenelement("Calcium", 13, 15, 1200, "mg", "d"));
        mengene.add(new Mengenelement("Calcium", 15, 19, 1200, "mg", "d"));
        mengene.add(new Mengenelement("Calcium", 19, 25, 1000, "mg", "d"));
        mengene.add(new Mengenelement("Calcium", 25, 51, 1000, "mg", "d"));
        mengene.add(new Mengenelement("Calcium", 51, 65, 1000, "mg", "d"));
        mengene.add(new Mengenelement("Calcium", 65, 99, 1000, "mg", "d"));
        mengene.add(new Mengenelement("Calcium", 200, 200, 1000, "mg", "d"));
        mengene.add(new Mengenelement("Calcium", 300, 300, 1000, "mg", "d"));
        
        mengene.add(new Mengenelement("Phosphor", 1, 4, 330, "mg", "d"));
        mengene.add(new Mengenelement("Phosphor", 4, 7, 410, "mg", "d"));
        mengene.add(new Mengenelement("Phosphor", 7, 10, 500, "mg", "d"));
        mengene.add(new Mengenelement("Phosphor", 10, 13, 610, "mg", "d"));
        mengene.add(new Mengenelement("Phosphor", 13, 15, 660, "mg", "d"));
        mengene.add(new Mengenelement("Phosphor", 15, 19, 660, "mg", "d"));
        mengene.add(new Mengenelement("Phosphor", 19, 25, 550, "mg", "d"));
        mengene.add(new Mengenelement("Phosphor", 25, 51, 550, "mg", "d"));
        mengene.add(new Mengenelement("Phosphor", 51, 65, 550, "mg", "d"));
        mengene.add(new Mengenelement("Phosphor", 65, 99, 550, "mg", "d"));
        mengene.add(new Mengenelement("Phosphor", 200, 200, 550, "mg", "d"));
        mengene.add(new Mengenelement("Phosphor", 300, 300, 550, "mg", "d"));
        
        mengene.add(new Mengenelement("Magnesium", 1, 4, 170, "mg", "m"));
        mengene.add(new Mengenelement("Magnesium", 4, 7, 190, "mg", "m"));
        mengene.add(new Mengenelement("Magnesium", 7, 10, 240, "mg", "m"));
        mengene.add(new Mengenelement("Magnesium", 10, 13, 260, "mg", "m"));
        mengene.add(new Mengenelement("Magnesium", 13, 15, 280, "mg", "m"));
        mengene.add(new Mengenelement("Magnesium", 15, 19, 330, "mg", "m"));
        mengene.add(new Mengenelement("Magnesium", 19, 25, 350, "mg", "m"));
        mengene.add(new Mengenelement("Magnesium", 25, 51, 350, "mg", "m"));
        mengene.add(new Mengenelement("Magnesium", 51, 65, 350, "mg", "m"));
        mengene.add(new Mengenelement("Magnesium", 65, 99, 350, "mg", "m"));
        mengene.add(new Mengenelement("Magnesium", 200, 200, 0, "mg", "m"));
        mengene.add(new Mengenelement("Magnesium", 300, 300, 0, "mg", "m"));
        
        mengene.add(new Mengenelement("Magnesium", 1, 4, 170, "mg", "w"));
        mengene.add(new Mengenelement("Magnesium", 4, 7, 190, "mg", "w"));
        mengene.add(new Mengenelement("Magnesium", 7, 10, 240, "mg", "w"));
        mengene.add(new Mengenelement("Magnesium", 10, 13, 230, "mg", "w"));
        mengene.add(new Mengenelement("Magnesium", 13, 15, 240, "mg", "w"));
        mengene.add(new Mengenelement("Magnesium", 15, 19, 260, "mg", "w"));
        mengene.add(new Mengenelement("Magnesium", 19, 25, 300, "mg", "w"));
        mengene.add(new Mengenelement("Magnesium", 25, 51, 300, "mg", "w"));
        mengene.add(new Mengenelement("Magnesium", 51, 65, 300, "mg", "w"));
        mengene.add(new Mengenelement("Magnesium", 65, 99, 300, "mg", "w"));
        mengene.add(new Mengenelement("Magnesium", 200, 200, 300, "mg", "w"));
        mengene.add(new Mengenelement("Magnesium", 300, 300, 300, "mg", "w"));
                
        spur.add(new Spurenelement("Eisen", 1, 4, 7, "mg", "m", 2));
        spur.add(new Spurenelement("Eisen", 4, 7, 7, "mg", "m", 2));
        spur.add(new Spurenelement("Eisen", 7, 10, 10, "mg", "m", 2));
        spur.add(new Spurenelement("Eisen", 10, 13, 14, "mg", "m", 2));
        spur.add(new Spurenelement("Eisen", 13, 15, 11, "mg", "m", 2));
        spur.add(new Spurenelement("Eisen", 15, 19, 11, "mg", "m", 2));
        spur.add(new Spurenelement("Eisen", 19, 25, 11, "mg", "m", 2));
        spur.add(new Spurenelement("Eisen", 25, 51, 11, "mg", "m", 2));
        spur.add(new Spurenelement("Eisen", 51, 65, 11, "mg", "m", 2));
        spur.add(new Spurenelement("Eisen", 65, 99, 11, "mg", "m", 2));
        spur.add(new Spurenelement("Eisen", 200, 200, 0, "mg", "m", 2));
        spur.add(new Spurenelement("Eisen", 300, 300, 0, "mg", "m", 2));
        
        spur.add(new Spurenelement("Eisen", 1, 4, 7, "mg", "w", 2));
        spur.add(new Spurenelement("Eisen", 4, 7, 7, "mg", "w", 2));
        spur.add(new Spurenelement("Eisen", 7, 10, 10, "mg", "w", 2));
        spur.add(new Spurenelement("Eisen", 10, 13, 14, "mg", "w", 2));
        spur.add(new Spurenelement("Eisen", 13, 15, 16, "mg", "w", 2));
        spur.add(new Spurenelement("Eisen", 15, 19, 16, "mg", "w", 2));
        spur.add(new Spurenelement("Eisen", 19, 25, 16, "mg", "w", 2));
        spur.add(new Spurenelement("Eisen", 25, 51, 16, "mg", "w", 2));
        spur.add(new Spurenelement("Eisen", 51, 65, 16, "mg", "w", 2));
        spur.add(new Spurenelement("Eisen", 65, 99, 14, "mg", "w", 2));
        spur.add(new Spurenelement("Eisen", 200, 200, 27, "mg", "w", 2));
        spur.add(new Spurenelement("Eisen", 300, 300, 16, "mg", "w", 2));
        
        spur.add(new Spurenelement("Jod", 1, 4, 100, "ug", "d", 2));
        spur.add(new Spurenelement("Jod", 4, 7, 120, "ug", "d", 2));
        spur.add(new Spurenelement("Jod", 7, 10, 140, "ug", "d", 2));
        spur.add(new Spurenelement("Jod", 10, 13, 180, "ug", "d", 2));
        spur.add(new Spurenelement("Jod", 13, 15, 200, "ug", "d", 2));
        spur.add(new Spurenelement("Jod", 15, 19, 200, "ug", "d", 2));
        spur.add(new Spurenelement("Jod", 19, 25, 200, "ug", "d", 2));
        spur.add(new Spurenelement("Jod", 25, 51, 200, "ug", "d", 2));
        spur.add(new Spurenelement("Jod", 51, 65, 180, "ug", "d", 2));
        spur.add(new Spurenelement("Jod", 65, 99, 180, "ug", "d", 2));
        spur.add(new Spurenelement("Jod", 200, 200, 230, "ug", "d", 2));
        spur.add(new Spurenelement("Jod", 300, 300, 260, "ug", "d", 2));
        
        spur.add(new Spurenelement("Flourid", 1, 4, 0.7, "mg", "m", 2));
        spur.add(new Spurenelement("Flourid", 4, 7, 1, "mg", "m", 2));
        spur.add(new Spurenelement("Flourid", 7, 10, 1.5, "mg", "m", 2));
        spur.add(new Spurenelement("Flourid", 10, 13, 2.1, "mg", "m", 2));
        spur.add(new Spurenelement("Flourid", 13, 15, 2.8, "mg", "m", 2));
        spur.add(new Spurenelement("Flourid", 15, 19, 3.5, "mg", "m", 2));
        spur.add(new Spurenelement("Flourid", 19, 25, 3.5, "mg", "m", 2));
        spur.add(new Spurenelement("Flourid", 25, 51, 3.5, "mg", "m", 2));
        spur.add(new Spurenelement("Flourid", 51, 65, 3.5, "mg", "m", 2));
        spur.add(new Spurenelement("Flourid", 65, 99, 3.5, "mg", "m", 2));
        spur.add(new Spurenelement("Flourid", 200, 200, 0, "mg", "m", 2));
        spur.add(new Spurenelement("Flourid", 300, 300, 0, "mg", "m", 2));
        
        spur.add(new Spurenelement("Flourid", 1, 4, 0.7, "mg", "w", 2));
        spur.add(new Spurenelement("Flourid", 4, 7, 1, "mg", "w", 2));
        spur.add(new Spurenelement("Flourid", 7, 10, 1.5, "mg", "w", 2));
        spur.add(new Spurenelement("Flourid", 10, 13, 2.1, "mg", "w", 2));
        spur.add(new Spurenelement("Flourid", 13, 15, 2.7, "mg", "w", 2));
        spur.add(new Spurenelement("Flourid", 15, 19, 3, "mg", "w", 2));
        spur.add(new Spurenelement("Flourid", 19, 25, 3, "mg", "w", 2));
        spur.add(new Spurenelement("Flourid", 25, 51, 3, "mg", "w", 2));
        spur.add(new Spurenelement("Flourid", 51, 65, 3, "mg", "w", 2));
        spur.add(new Spurenelement("Flourid", 65, 99, 3, "mg", "w", 2));
        spur.add(new Spurenelement("Flourid", 200, 200, 3, "mg", "w", 2));
        spur.add(new Spurenelement("Flourid", 300, 300, 3, "mg", "w", 2));
        
        spur.add(new Spurenelement("Zink", 1, 4, 3, "mg", "m", -1));
        spur.add(new Spurenelement("Zink", 4, 7, 4, "mg", "m", -1));
        spur.add(new Spurenelement("Zink", 7, 10, 6, "mg", "m", -1));
        spur.add(new Spurenelement("Zink", 10, 13, 9, "mg", "m", -1));
        spur.add(new Spurenelement("Zink", 13, 15, 12, "mg", "m", -1));
        spur.add(new Spurenelement("Zink", 15, 19, 14, "mg", "m", -1));
        spur.add(new Spurenelement("Zink", 19, 25, 11, "mg", "m", -1));
        spur.add(new Spurenelement("Zink", 25, 51, 11, "mg", "m", -1));
        spur.add(new Spurenelement("Zink", 51, 65, 11, "mg", "m", -1));
        spur.add(new Spurenelement("Zink", 65, 99, 11, "mg", "m", -1));
        spur.add(new Spurenelement("Zink", 200, 200, 0, "mg", "m", -1));
        spur.add(new Spurenelement("Zink", 300, 300, 0, "mg", "m", -1));
        
        spur.add(new Spurenelement("Zink", 1, 4, 3, "mg", "w", -1));
        spur.add(new Spurenelement("Zink", 4, 7, 4, "mg", "w", -1));
        spur.add(new Spurenelement("Zink", 7, 10, 6, "mg", "w", -1));
        spur.add(new Spurenelement("Zink", 10, 13, 8, "mg", "w", -1));
        spur.add(new Spurenelement("Zink", 13, 15, 10, "mg", "w", -1));
        spur.add(new Spurenelement("Zink", 15, 19, 11, "mg", "w", -1));
        spur.add(new Spurenelement("Zink", 19, 25, 7, "mg", "w", -1));
        spur.add(new Spurenelement("Zink", 25, 51, 7, "mg", "w", -1));
        spur.add(new Spurenelement("Zink", 51, 65, 7, "mg", "w", -1));
        spur.add(new Spurenelement("Zink", 65, 99, 7, "mg", "w", -1));
        spur.add(new Spurenelement("Zink", 200, 200, 8, "mg", "w", -1));
        spur.add(new Spurenelement("Zink", 300, 300, 11, "mg", "w", -1));
        
        spur.add(new Spurenelement("Zink", 1, 4, 3, "mg", "m", 0));
        spur.add(new Spurenelement("Zink", 4, 7, 4, "mg", "m", 0));
        spur.add(new Spurenelement("Zink", 7, 10, 6, "mg", "m", 0));
        spur.add(new Spurenelement("Zink", 10, 13, 9, "mg", "m", 0));
        spur.add(new Spurenelement("Zink", 13, 15, 12, "mg", "m", 0));
        spur.add(new Spurenelement("Zink", 15, 19, 14, "mg", "m", 0));
        spur.add(new Spurenelement("Zink", 19, 25, 14, "mg", "m", 0));
        spur.add(new Spurenelement("Zink", 25, 51, 14, "mg", "m", 0));
        spur.add(new Spurenelement("Zink", 51, 65, 14, "mg", "m", 0));
        spur.add(new Spurenelement("Zink", 65, 99, 14, "mg", "m", 0));
        spur.add(new Spurenelement("Zink", 200, 200, 0, "mg", "m", 0));
        spur.add(new Spurenelement("Zink", 300, 300, 0, "mg", "m", 0));
        
        spur.add(new Spurenelement("Zink", 1, 4, 3, "mg", "w", 0));
        spur.add(new Spurenelement("Zink", 4, 7, 4, "mg", "w", 0));
        spur.add(new Spurenelement("Zink", 7, 10, 6, "mg", "w", 0));
        spur.add(new Spurenelement("Zink", 10, 13, 8, "mg", "w", 0));
        spur.add(new Spurenelement("Zink", 13, 15, 10, "mg", "w", 0));
        spur.add(new Spurenelement("Zink", 15, 19, 11, "mg", "w", 0));
        spur.add(new Spurenelement("Zink", 19, 25, 8, "mg", "w", 0));
        spur.add(new Spurenelement("Zink", 25, 51, 8, "mg", "w", 0));
        spur.add(new Spurenelement("Zink", 51, 65, 8, "mg", "w", 0));
        spur.add(new Spurenelement("Zink", 65, 99, 8, "mg", "w", 0));
        spur.add(new Spurenelement("Zink", 200, 200, 10, "mg", "w", 0));
        spur.add(new Spurenelement("Zink", 300, 300, 13, "mg", "w", 0));
        
        spur.add(new Spurenelement("Zink", 1, 4, 3, "mg", "m", 1));
        spur.add(new Spurenelement("Zink", 4, 7, 4, "mg", "m", 1));
        spur.add(new Spurenelement("Zink", 7, 10, 6, "mg", "m", 1));
        spur.add(new Spurenelement("Zink", 10, 13, 9, "mg", "m", 1));
        spur.add(new Spurenelement("Zink", 13, 15, 12, "mg", "m", 1));
        spur.add(new Spurenelement("Zink", 15, 19, 14, "mg", "m", 1));
        spur.add(new Spurenelement("Zink", 19, 25, 16, "mg", "m", 1));
        spur.add(new Spurenelement("Zink", 25, 51, 16, "mg", "m", 1));
        spur.add(new Spurenelement("Zink", 51, 65, 16, "mg", "m", 1));
        spur.add(new Spurenelement("Zink", 65, 99, 16, "mg", "m", 1));
        spur.add(new Spurenelement("Zink", 200, 200, 0, "mg", "m", 1));
        spur.add(new Spurenelement("Zink", 300, 300, 0, "mg", "m", 1));
        
        spur.add(new Spurenelement("Zink", 1, 4, 3, "mg", "w", 1));
        spur.add(new Spurenelement("Zink", 4, 7, 4, "mg", "w", 1));
        spur.add(new Spurenelement("Zink", 7, 10, 6, "mg", "w", 1));
        spur.add(new Spurenelement("Zink", 10, 13, 8, "mg", "w", 1));
        spur.add(new Spurenelement("Zink", 13, 15, 10, "mg", "w", 1));
        spur.add(new Spurenelement("Zink", 15, 19, 11, "mg", "w", 1));
        spur.add(new Spurenelement("Zink", 19, 25, 10, "mg", "w", 1));
        spur.add(new Spurenelement("Zink", 25, 51, 10, "mg", "w", 1));
        spur.add(new Spurenelement("Zink", 51, 65, 10, "mg", "w", 1));
        spur.add(new Spurenelement("Zink", 65, 99, 10, "mg", "w", 1));
        spur.add(new Spurenelement("Zink", 200, 200, 12, "mg", "w", 1));
        spur.add(new Spurenelement("Zink", 300, 300, 14, "mg", "w", 1));
        
        spur.add(new Spurenelement("Selen", 1, 4, 15, "ug", "m", 2));
        spur.add(new Spurenelement("Selen", 4, 7, 20, "ug", "m", 2));
        spur.add(new Spurenelement("Selen", 7, 10, 30, "ug", "m", 2));
        spur.add(new Spurenelement("Selen", 10, 13, 45, "ug", "m", 2));
        spur.add(new Spurenelement("Selen", 13, 15, 60, "ug", "m", 2));
        spur.add(new Spurenelement("Selen", 15, 19, 70, "ug", "m", 2));
        spur.add(new Spurenelement("Selen", 19, 25, 70, "ug", "m", 2));
        spur.add(new Spurenelement("Selen", 25, 51, 70, "ug", "m", 2));
        spur.add(new Spurenelement("Selen", 51, 65, 70, "ug", "m", 2));
        spur.add(new Spurenelement("Selen", 65, 99, 70, "ug", "m", 2));
        spur.add(new Spurenelement("Selen", 200, 200, 0, "ug", "m", 2));
        spur.add(new Spurenelement("Selen", 300, 300, 0, "ug", "m", 2));
        
        spur.add(new Spurenelement("Selen", 1, 4, 15, "ug", "w", 2));
        spur.add(new Spurenelement("Selen", 4, 7, 20, "ug", "w", 2));
        spur.add(new Spurenelement("Selen", 7, 10, 30, "ug", "w", 2));
        spur.add(new Spurenelement("Selen", 10, 13, 45, "ug", "w", 2));
        spur.add(new Spurenelement("Selen", 13, 15, 60, "ug", "w", 2));
        spur.add(new Spurenelement("Selen", 15, 19, 60, "ug", "w", 2));
        spur.add(new Spurenelement("Selen", 19, 25, 60, "ug", "w", 2));
        spur.add(new Spurenelement("Selen", 25, 51, 60, "ug", "w", 2));
        spur.add(new Spurenelement("Selen", 51, 65, 60, "ug", "w", 2));
        spur.add(new Spurenelement("Selen", 65, 99, 60, "ug", "w", 2));
        spur.add(new Spurenelement("Selen", 200, 200, 60, "ug", "w", 2));
        spur.add(new Spurenelement("Selen", 300, 300, 75, "ug", "w", 2));
        
        spur.add(new Spurenelement("Kupfer", 1, 4, 0.75, "mg", "d", 2));
        spur.add(new Spurenelement("Kupfer", 4, 7, 0.75, "mg", "d", 2));
        spur.add(new Spurenelement("Kupfer", 7, 10, 1.25, "mg", "d", 2));
        spur.add(new Spurenelement("Kupfer", 10, 15, 1.25, "mg", "d", 2));
        spur.add(new Spurenelement("Kupfer", 15, 99, 1.25, "mg", "d", 2));
        
        spur.add(new Spurenelement("Mangan", 1, 4, 1.25, "mg", "d", 2));
        spur.add(new Spurenelement("Mangan", 4, 7, 1.75, "mg", "d", 2));
        spur.add(new Spurenelement("Mangan", 7, 10, 2.5, "mg", "d", 2));
        spur.add(new Spurenelement("Mangan", 10, 15, 3.5, "mg", "d", 2));
        spur.add(new Spurenelement("Mangan", 15, 99, 3.5, "mg", "d", 2));
        
        spur.add(new Spurenelement("Chrom", 1, 4, 40, "ug", "d", 2));
        spur.add(new Spurenelement("Chrom", 4, 7, 50, "ug", "d", 2));
        spur.add(new Spurenelement("Chrom", 7, 10, 60, "ug", "d", 2));
        spur.add(new Spurenelement("Chrom", 10, 15, 60, "ug", "d", 2));
        spur.add(new Spurenelement("Chrom", 15, 99, 65, "ug", "d", 2));
        
        spur.add(new Spurenelement("Molybdän", 1, 4, 37.5, "ug", "d", 2));
        spur.add(new Spurenelement("Molybdän", 4, 7, 50.25, "ug", "d", 2));
        spur.add(new Spurenelement("Molybdän", 7, 10, 60, "ug", "d", 2));
        spur.add(new Spurenelement("Molybdän", 10, 15, 75, "ug", "d", 2));
        spur.add(new Spurenelement("Molybdän", 15, 99, 75, "ug", "d", 2));     
        
        vitamine.add(new Vitamin("Retinol",1, 4, 300, "ug", "m"));
        vitamine.add(new Vitamin("Retinol",4, 7, 350, "ug", "m"));
        vitamine.add(new Vitamin("Retinol",7, 10, 450, "ug", "m"));
        vitamine.add(new Vitamin("Retinol",10, 13, 600, "ug", "m"));
        vitamine.add(new Vitamin("Retinol",13, 15, 800, "ug", "m"));
        vitamine.add(new Vitamin("Retinol",15, 19, 950, "ug", "m"));
        vitamine.add(new Vitamin("Retinol",19, 25, 850, "ug", "m"));
        vitamine.add(new Vitamin("Retinol",25, 51, 850, "ug", "m"));
        vitamine.add(new Vitamin("Retinol",51, 65, 850, "ug", "m"));
        vitamine.add(new Vitamin("Retinol",65, 99, 800, "ug", "m"));
        vitamine.add(new Vitamin("Retinol",200, 200, 0, "ug", "m"));
        vitamine.add(new Vitamin("Retinol",300, 300, 0, "ug", "m"));
        
        vitamine.add(new Vitamin("Retinol",1, 4, 300, "ug", "w"));
        vitamine.add(new Vitamin("Retinol",4, 7, 350, "ug", "w"));
        vitamine.add(new Vitamin("Retinol",7, 10, 450, "ug", "w"));
        vitamine.add(new Vitamin("Retinol",10, 13, 600, "ug", "w"));
        vitamine.add(new Vitamin("Retinol",13, 15, 700, "ug", "w"));
        vitamine.add(new Vitamin("Retinol",15, 19, 800, "ug", "w"));
        vitamine.add(new Vitamin("Retinol",19, 25, 700, "ug", "w"));
        vitamine.add(new Vitamin("Retinol",25, 51, 700, "ug", "w"));
        vitamine.add(new Vitamin("Retinol",51, 65, 700, "ug", "w"));
        vitamine.add(new Vitamin("Retinol",65, 99, 700, "ug", "w"));
        vitamine.add(new Vitamin("Retinol",200, 200, 800, "ug", "w"));
        vitamine.add(new Vitamin("Retinol",300, 300, 1300, "ug", "w"));
        
        vitamine.add(new Vitamin("D",1, 15, 20, "ug", "d"));
        vitamine.add(new Vitamin("D",15, 65, 20, "ug", "d"));
        vitamine.add(new Vitamin("D",65, 99, 20, "ug", "d"));
        vitamine.add(new Vitamin("D",200, 200, 20, "ug", "d"));
        vitamine.add(new Vitamin("D",300, 300, 20, "ug", "d"));
        
        vitamine.add(new Vitamin("Tocopherol", 1, 4, 6, "mg", "m"));
        vitamine.add(new Vitamin("Tocopherol", 4, 7, 8, "mg", "m"));
        vitamine.add(new Vitamin("Tocopherol", 7, 10, 10, "mg", "m"));
        vitamine.add(new Vitamin("Tocopherol", 10, 13, 13, "mg", "m"));
        vitamine.add(new Vitamin("Tocopherol", 13, 15, 14, "mg", "m"));
        vitamine.add(new Vitamin("Tocopherol", 15, 19, 15, "mg", "m"));
        vitamine.add(new Vitamin("Tocopherol", 19, 25, 15, "mg", "m"));
        vitamine.add(new Vitamin("Tocopherol", 25, 51, 14, "mg", "m"));
        vitamine.add(new Vitamin("Tocopherol", 51, 65, 13, "mg", "m"));
        vitamine.add(new Vitamin("Tocopherol", 65, 99, 12, "mg", "m"));
        vitamine.add(new Vitamin("Tocopherol", 200, 200, 0, "mg", "m"));
        vitamine.add(new Vitamin("Tocopherol", 300, 300, 0, "mg", "m"));
        
        vitamine.add(new Vitamin("Tocopherol", 1, 4, 5, "mg", "w"));
        vitamine.add(new Vitamin("Tocopherol", 4, 7, 8, "mg", "w"));
        vitamine.add(new Vitamin("Tocopherol", 7, 10, 9, "mg", "w"));
        vitamine.add(new Vitamin("Tocopherol", 10, 13, 11, "mg", "w"));
        vitamine.add(new Vitamin("Tocopherol", 13, 15, 12, "mg", "w"));
        vitamine.add(new Vitamin("Tocopherol", 15, 19, 12, "mg", "w"));
        vitamine.add(new Vitamin("Tocopherol", 19, 25, 12, "mg", "w"));
        vitamine.add(new Vitamin("Tocopherol", 25, 51, 12, "mg", "w"));
        vitamine.add(new Vitamin("Tocopherol", 51, 65, 12, "mg", "w"));
        vitamine.add(new Vitamin("Tocopherol", 65, 99, 11, "mg", "w"));
        vitamine.add(new Vitamin("Tocopherol", 200, 200, 13, "mg", "w"));
        vitamine.add(new Vitamin("Tocopherol", 300, 300, 17, "mg", "w"));
        
        vitamine.add(new Vitamin("K", 1, 4, 15, "ug", "m"));
        vitamine.add(new Vitamin("K", 4, 7, 20, "ug", "m"));
        vitamine.add(new Vitamin("K", 7, 10, 30, "ug", "m"));
        vitamine.add(new Vitamin("K", 10, 13, 40, "ug", "m"));
        vitamine.add(new Vitamin("K", 13, 15, 50, "ug", "m"));
        vitamine.add(new Vitamin("K", 15, 19, 70, "ug", "m"));
        vitamine.add(new Vitamin("K", 19, 25, 70, "ug", "m"));
        vitamine.add(new Vitamin("K", 25, 51, 70, "ug", "m"));
        vitamine.add(new Vitamin("K", 51, 65, 80, "ug", "m"));
        vitamine.add(new Vitamin("K", 65, 99, 80, "ug", "m"));
        vitamine.add(new Vitamin("K", 200, 200, 0, "ug", "m"));
        vitamine.add(new Vitamin("K", 300, 300, 0, "ug", "m"));
        
        vitamine.add(new Vitamin("K", 1, 4, 15, "ug", "w"));
        vitamine.add(new Vitamin("K", 4, 7, 20, "ug", "w"));
        vitamine.add(new Vitamin("K", 7, 10, 30, "ug", "w"));
        vitamine.add(new Vitamin("K", 10, 13, 40, "ug", "w"));
        vitamine.add(new Vitamin("K", 13, 15, 50, "ug", "w"));
        vitamine.add(new Vitamin("K", 15, 19, 60, "ug", "w"));
        vitamine.add(new Vitamin("K", 19, 25, 60, "ug", "w"));
        vitamine.add(new Vitamin("K", 25, 51, 60, "ug", "w"));
        vitamine.add(new Vitamin("K", 51, 65, 65, "ug", "w"));
        vitamine.add(new Vitamin("K", 65, 99, 65, "ug", "w"));
        vitamine.add(new Vitamin("K", 200, 200, 60, "ug", "w"));
        vitamine.add(new Vitamin("K", 300, 300, 60, "ug", "w"));
        
        vitamine.add(new Vitamin("Thiamin", 1, 4, 0.6, "mg", "m"));
        vitamine.add(new Vitamin("Thiamin", 4, 7, 0.7, "mg", "m"));
        vitamine.add(new Vitamin("Thiamin", 7, 10, 0.9, "mg", "m"));
        vitamine.add(new Vitamin("Thiamin", 10, 13, 1.0, "mg", "m"));
        vitamine.add(new Vitamin("Thiamin", 13, 15, 1.2, "mg", "m"));
        vitamine.add(new Vitamin("Thiamin", 15, 19, 1.4, "mg", "m"));
        vitamine.add(new Vitamin("Thiamin", 19, 25, 1.3, "mg", "m"));
        vitamine.add(new Vitamin("Thiamin", 25, 51, 1.2, "mg", "m"));
        vitamine.add(new Vitamin("Thiamin", 51, 65, 1.2, "mg", "m"));
        vitamine.add(new Vitamin("Thiamin", 65, 99, 1.1, "mg", "m"));
        vitamine.add(new Vitamin("Thiamin", 200, 200, 0, "mg", "m"));
        vitamine.add(new Vitamin("Thiamin", 300, 300, 0, "mg", "m"));
        
        vitamine.add(new Vitamin("Thiamin", 1, 4, 0.6, "mg", "w"));
        vitamine.add(new Vitamin("Thiamin", 4, 7, 0.7, "mg", "w"));
        vitamine.add(new Vitamin("Thiamin", 7, 10, 0.8, "mg", "w"));
        vitamine.add(new Vitamin("Thiamin", 10, 13, 0.9, "mg", "w"));
        vitamine.add(new Vitamin("Thiamin", 13, 15, 1.0, "mg", "w"));
        vitamine.add(new Vitamin("Thiamin", 15, 19, 1.1, "mg", "w"));
        vitamine.add(new Vitamin("Thiamin", 19, 25, 1, "mg", "w"));
        vitamine.add(new Vitamin("Thiamin", 25, 51, 1, "mg", "w"));
        vitamine.add(new Vitamin("Thiamin", 51, 65, 1, "mg", "w"));
        vitamine.add(new Vitamin("Thiamin", 65, 99, 1, "mg", "w"));
        vitamine.add(new Vitamin("Thiamin", 200, 200, 1.3, "mg", "w"));
        vitamine.add(new Vitamin("Thiamin", 300, 300, 1.3, "mg", "w"));
        
        vitamine.add(new Vitamin("Riboflavin", 1, 4, 0.7, "mg", "m"));
        vitamine.add(new Vitamin("Riboflavin", 4, 7, 0.8, "mg", "m"));
        vitamine.add(new Vitamin("Riboflavin", 7, 10, 1, "mg", "m"));
        vitamine.add(new Vitamin("Riboflavin", 10, 13, 1.1, "mg", "m"));
        vitamine.add(new Vitamin("Riboflavin", 13, 15, 1.4, "mg", "m"));
        vitamine.add(new Vitamin("Riboflavin", 15, 19, 1.6, "mg", "m"));
        vitamine.add(new Vitamin("Riboflavin", 19, 25, 1.4, "mg", "m"));
        vitamine.add(new Vitamin("Riboflavin", 25, 51, 1.4, "mg", "m"));
        vitamine.add(new Vitamin("Riboflavin", 51, 65, 1.3, "mg", "m"));
        vitamine.add(new Vitamin("Riboflavin", 65, 99, 1.3, "mg", "m"));
        vitamine.add(new Vitamin("Riboflavin", 200, 200, 0, "mg", "m"));
        vitamine.add(new Vitamin("Riboflavin", 300, 300, 0, "mg", "m"));
        
        vitamine.add(new Vitamin("Riboflavin", 1, 4, 0.7, "mg", "w"));
        vitamine.add(new Vitamin("Riboflavin", 4, 7, 0.8, "mg", "w"));
        vitamine.add(new Vitamin("Riboflavin", 7, 10, 0.9, "mg", "w"));
        vitamine.add(new Vitamin("Riboflavin", 10, 13, 1, "mg", "w"));
        vitamine.add(new Vitamin("Riboflavin", 13, 15, 1.1, "mg", "w"));
        vitamine.add(new Vitamin("Riboflavin", 15, 19, 1.2, "mg", "w"));
        vitamine.add(new Vitamin("Riboflavin", 19, 25, 1.1, "mg", "w"));
        vitamine.add(new Vitamin("Riboflavin", 25, 51, 1.1, "mg", "w"));
        vitamine.add(new Vitamin("Riboflavin", 51, 65, 1, "mg", "w"));
        vitamine.add(new Vitamin("Riboflavin", 65, 99, 1, "mg", "w"));
        vitamine.add(new Vitamin("Riboflavin", 200, 200, 1.3, "mg", "w"));
        vitamine.add(new Vitamin("Riboflavin", 300, 300, 1.4, "mg", "w"));
        
        vitamine.add(new Vitamin("Niacin", 1, 4, 8, "mg", "m"));
        vitamine.add(new Vitamin("Niacin", 4, 7, 9, "mg", "m"));
        vitamine.add(new Vitamin("Niacin", 7, 10, 11, "mg", "m"));
        vitamine.add(new Vitamin("Niacin", 10, 13, 13, "mg", "m"));
        vitamine.add(new Vitamin("Niacin", 13, 15, 15, "mg", "m"));
        vitamine.add(new Vitamin("Niacin", 15, 19, 17, "mg", "m"));
        vitamine.add(new Vitamin("Niacin", 19, 25, 16, "mg", "m"));
        vitamine.add(new Vitamin("Niacin", 25, 51, 15, "mg", "m"));
        vitamine.add(new Vitamin("Niacin", 51, 65, 15, "mg", "m"));
        vitamine.add(new Vitamin("Niacin", 65, 99, 14, "mg", "m"));
        vitamine.add(new Vitamin("Niacin", 200, 200, 0, "mg", "m"));
        vitamine.add(new Vitamin("Niacin", 300, 300, 0, "mg", "m"));
        
        vitamine.add(new Vitamin("Niacin", 1, 4, 8, "mg", "w"));
        vitamine.add(new Vitamin("Niacin", 4, 7, 9, "mg", "w"));
        vitamine.add(new Vitamin("Niacin", 7, 10, 10, "mg", "w"));
        vitamine.add(new Vitamin("Niacin", 10, 13, 11, "mg", "w"));
        vitamine.add(new Vitamin("Niacin", 13, 15, 13, "mg", "w"));
        vitamine.add(new Vitamin("Niacin", 15, 19, 13, "mg", "w"));
        vitamine.add(new Vitamin("Niacin", 19, 25, 13, "mg", "w"));
        vitamine.add(new Vitamin("Niacin", 25, 51, 12, "mg", "w"));
        vitamine.add(new Vitamin("Niacin", 51, 65, 11, "mg", "w"));
        vitamine.add(new Vitamin("Niacin", 65, 99, 11, "mg", "w"));
        vitamine.add(new Vitamin("Niacin", 200, 200, 15, "mg", "w"));
        vitamine.add(new Vitamin("Niacin", 300, 300, 16, "mg", "w"));
        
        vitamine.add(new Vitamin("B6", 1, 4, 0.6, "mg", "m"));
        vitamine.add(new Vitamin("B6", 4, 7, 0.7, "mg", "m"));
        vitamine.add(new Vitamin("B6", 7, 10, 1.0, "mg", "m"));
        vitamine.add(new Vitamin("B6", 10, 13, 1.2, "mg", "m"));
        vitamine.add(new Vitamin("B6", 13, 15, 1.5, "mg", "m"));
        vitamine.add(new Vitamin("B6", 15, 19, 1.6, "mg", "m"));
        vitamine.add(new Vitamin("B6", 19, 25, 1.6, "mg", "m"));
        vitamine.add(new Vitamin("B6", 25, 51, 1.6, "mg", "m"));
        vitamine.add(new Vitamin("B6", 51, 65, 1.6, "mg", "m"));
        vitamine.add(new Vitamin("B6", 65, 99, 1.6, "mg", "m"));
        vitamine.add(new Vitamin("B6", 200, 200, 0, "mg", "m"));
        vitamine.add(new Vitamin("B6", 300, 300, 0, "mg", "m"));
        
        vitamine.add(new Vitamin("B6", 1, 4, 0.6, "mg", "w"));
        vitamine.add(new Vitamin("B6", 4, 7, 0.7, "mg", "w"));
        vitamine.add(new Vitamin("B6", 7, 10, 1.0, "mg", "w"));
        vitamine.add(new Vitamin("B6", 10, 13, 1.2, "mg", "w"));
        vitamine.add(new Vitamin("B6", 13, 15, 1.4, "mg", "w"));
        vitamine.add(new Vitamin("B6", 15, 19, 1.4, "mg", "w"));
        vitamine.add(new Vitamin("B6", 19, 25, 1.4, "mg", "w"));
        vitamine.add(new Vitamin("B6", 25, 51, 1.4, "mg", "w"));
        vitamine.add(new Vitamin("B6", 51, 65, 1.4, "mg", "w"));
        vitamine.add(new Vitamin("B6", 65, 99, 1.4, "mg", "w"));
        vitamine.add(new Vitamin("B6", 200, 200, 1.8, "mg", "w"));
        vitamine.add(new Vitamin("B6", 300, 300, 1.6, "mg", "w"));
        
        vitamine.add(new Vitamin("Folat", 1, 4, 120, "ug", "m"));
        vitamine.add(new Vitamin("Folat", 4, 7, 140, "ug", "m"));
        vitamine.add(new Vitamin("Folat", 7, 10, 180, "ug", "m"));
        vitamine.add(new Vitamin("Folat", 10, 13, 240, "ug", "m"));
        vitamine.add(new Vitamin("Folat", 13, 15, 300, "ug", "m"));
        vitamine.add(new Vitamin("Folat", 15, 19, 300, "ug", "m"));
        vitamine.add(new Vitamin("Folat", 19, 25, 300, "ug", "m"));
        vitamine.add(new Vitamin("Folat", 25, 51, 300, "ug", "m"));
        vitamine.add(new Vitamin("Folat", 51, 65, 300, "ug", "m"));
        vitamine.add(new Vitamin("Folat", 65, 99, 300, "ug", "m"));
        vitamine.add(new Vitamin("Folat", 200, 200, 0, "ug", "m"));
        vitamine.add(new Vitamin("Folat", 300, 300, 0, "ug", "m"));
        
        vitamine.add(new Vitamin("Folat", 1, 4, 120, "ug", "w"));
        vitamine.add(new Vitamin("Folat", 4, 7, 140, "ug", "w"));
        vitamine.add(new Vitamin("Folat", 7, 10, 180, "ug", "w"));
        vitamine.add(new Vitamin("Folat", 10, 13, 240, "ug", "w"));
        vitamine.add(new Vitamin("Folat", 13, 15, 300, "ug", "w"));
        vitamine.add(new Vitamin("Folat", 15, 19, 300, "ug", "w"));
        vitamine.add(new Vitamin("Folat", 19, 25, 300, "ug", "w"));
        vitamine.add(new Vitamin("Folat", 25, 51, 300, "ug", "w"));
        vitamine.add(new Vitamin("Folat", 51, 65, 300, "ug", "w"));
        vitamine.add(new Vitamin("Folat", 65, 99, 300, "ug", "w"));
        vitamine.add(new Vitamin("Folat", 200, 200, 550, "ug", "w"));
        vitamine.add(new Vitamin("Folat", 300, 300, 450, "ug", "w"));
        
        vitamine.add(new Vitamin("Pantothen", 1, 4, 4, "mg", "m"));
        vitamine.add(new Vitamin("Pantothen", 4, 7, 4, "mg", "m"));
        vitamine.add(new Vitamin("Pantothen", 7, 10, 4, "mg", "m"));
        vitamine.add(new Vitamin("Pantothen", 10, 13, 5, "mg", "m"));
        vitamine.add(new Vitamin("Pantothen", 13, 15, 5, "mg", "m"));
        vitamine.add(new Vitamin("Pantothen", 15, 19, 5, "mg", "m"));
        vitamine.add(new Vitamin("Pantothen", 19, 25, 5, "mg", "m"));
        vitamine.add(new Vitamin("Pantothen", 25, 51, 5, "mg", "m"));
        vitamine.add(new Vitamin("Pantothen", 51, 65, 5, "mg", "m"));
        vitamine.add(new Vitamin("Pantothen", 65, 99, 5, "mg", "m"));
        vitamine.add(new Vitamin("Pantothen", 200, 200, 0, "mg", "m"));
        vitamine.add(new Vitamin("Pantothen", 300, 300, 0, "mg", "m"));
        
        vitamine.add(new Vitamin("Pantothen", 1, 4, 4, "mg", "w"));
        vitamine.add(new Vitamin("Pantothen", 4, 7, 4, "mg", "w"));
        vitamine.add(new Vitamin("Pantothen", 7, 10, 4, "mg", "w"));
        vitamine.add(new Vitamin("Pantothen", 10, 13, 5, "mg", "w"));
        vitamine.add(new Vitamin("Pantothen", 13, 15, 5, "mg", "w"));
        vitamine.add(new Vitamin("Pantothen", 15, 19, 5, "mg", "w"));
        vitamine.add(new Vitamin("Pantothen", 19, 25, 5, "mg", "w"));
        vitamine.add(new Vitamin("Pantothen", 25, 51, 5, "mg", "w"));
        vitamine.add(new Vitamin("Pantothen", 51, 65, 5, "mg", "w"));
        vitamine.add(new Vitamin("Pantothen", 65, 99, 5, "mg", "w"));
        vitamine.add(new Vitamin("Pantothen", 200, 200, 5, "mg", "w"));
        vitamine.add(new Vitamin("Pantothen", 300, 300, 7, "mg", "w"));
        
        vitamine.add(new Vitamin("Biotin", 1, 4, 20, "ug", "d"));
        vitamine.add(new Vitamin("Biotin", 4, 7, 25, "ug", "d"));
        vitamine.add(new Vitamin("Biotin", 7, 10, 25, "ug", "d"));
        vitamine.add(new Vitamin("Biotin", 10, 13, 35, "ug", "d"));
        vitamine.add(new Vitamin("Biotin", 13, 15, 35, "ug", "d"));
        vitamine.add(new Vitamin("Biotin", 15, 19, 40, "ug", "d"));
        vitamine.add(new Vitamin("Biotin", 19, 25, 40, "ug", "d"));
        vitamine.add(new Vitamin("Biotin", 25, 51, 40, "ug", "d"));
        vitamine.add(new Vitamin("Biotin", 51, 65, 40, "ug", "d"));
        vitamine.add(new Vitamin("Biotin", 65, 99, 40, "ug", "d"));
        vitamine.add(new Vitamin("Biotin", 200, 200, 40, "ug", "d"));
        vitamine.add(new Vitamin("Biotin", 300, 300, 45, "ug", "d"));
        
        vitamine.add(new Vitamin("B12", 1, 4, 1.5, "ug", "d"));
        vitamine.add(new Vitamin("B12", 4, 7, 2, "ug", "d"));
        vitamine.add(new Vitamin("B12", 7, 10, 2.5, "ug", "d"));
        vitamine.add(new Vitamin("B12", 10, 13, 3.5, "ug", "d"));
        vitamine.add(new Vitamin("B12", 13, 15, 4, "ug", "d"));
        vitamine.add(new Vitamin("B12", 15, 19, 4, "ug", "d"));
        vitamine.add(new Vitamin("B12", 19, 25, 4, "ug", "d"));
        vitamine.add(new Vitamin("B12", 25, 51, 4, "ug", "d"));
        vitamine.add(new Vitamin("B12", 51, 65, 4, "ug", "d"));
        vitamine.add(new Vitamin("B12", 65, 99, 4, "ug", "d"));
        vitamine.add(new Vitamin("B12", 200, 200, 4.5, "ug", "d"));
        vitamine.add(new Vitamin("B12", 300, 300, 5.5, "ug", "d"));
        
        vitamine.add(new Vitamin("C", 1, 4, 20, "mg", "m"));
        vitamine.add(new Vitamin("C", 4, 7, 30, "mg", "m"));
        vitamine.add(new Vitamin("C", 7, 10, 45, "mg", "m"));
        vitamine.add(new Vitamin("C", 10, 13, 65, "mg", "m"));
        vitamine.add(new Vitamin("C", 13, 15, 85, "mg", "m"));
        vitamine.add(new Vitamin("C", 15, 19, 105, "mg", "m"));
        vitamine.add(new Vitamin("C", 19, 25, 110, "mg", "m"));
        vitamine.add(new Vitamin("C", 25, 51, 110, "mg", "m"));
        vitamine.add(new Vitamin("C", 51, 65, 110, "mg", "m"));
        vitamine.add(new Vitamin("C", 65, 99, 110, "mg", "m"));
        vitamine.add(new Vitamin("C", 200, 200, 0, "mg", "m"));
        vitamine.add(new Vitamin("C", 300, 300, 0, "mg", "m"));
        
        vitamine.add(new Vitamin("C", 1, 4, 20, "mg", "w"));
        vitamine.add(new Vitamin("C", 4, 7, 30, "mg", "w"));
        vitamine.add(new Vitamin("C", 7, 10, 45, "mg", "w"));
        vitamine.add(new Vitamin("C", 10, 13, 65, "mg", "w"));
        vitamine.add(new Vitamin("C", 13, 15, 85, "mg", "w"));
        vitamine.add(new Vitamin("C", 15, 19, 90, "mg", "w"));
        vitamine.add(new Vitamin("C", 19, 25, 95, "mg", "w"));
        vitamine.add(new Vitamin("C", 25, 51, 95, "mg", "w"));
        vitamine.add(new Vitamin("C", 51, 65, 95, "mg", "w"));
        vitamine.add(new Vitamin("C", 65, 99, 95, "mg", "w"));
        vitamine.add(new Vitamin("C", 200, 200, 105, "mg", "w"));
        vitamine.add(new Vitamin("C", 300, 300, 125, "mg", "w")); 
        
        wasser.add(new Wasser(1, 4, 95));
        wasser.add(new Wasser(4, 7, 75));
        wasser.add(new Wasser(7, 10, 60));
        wasser.add(new Wasser(10, 13, 50));
        wasser.add(new Wasser(13, 15, 40));
        wasser.add(new Wasser(15, 19, 40));
        wasser.add(new Wasser(19, 25, 35));
        wasser.add(new Wasser(25, 51, 35));
        wasser.add(new Wasser(51, 65, 30));
        wasser.add(new Wasser(65, 99, 30));
        wasser.add(new Wasser(200, 200, 35));
        wasser.add(new Wasser(300, 300, 45)); 
    }
    
    public Map<String, Object> findDGEByUser(User user){
        Map<String, Object> filteredDGE = new HashMap<>();     
       
        filteredDGE.put("energie", this.energie.stream().filter(obj -> obj.getAlterMin() <= user.getAge() 
                                                               && obj.getAlterMax() > user.getAge() 
                                                               && (obj.getGeschlecht().equals(user.getGender()) || obj.getGeschlecht().equals("d") ))
                                                        .min(Comparator.comparingDouble(obj -> Math.abs(obj.getPal() - user.getPal()))).get());
        
        filteredDGE.put("erefCM", this.eref.stream().filter(obj -> obj.getAlterMin() <= user.getAge() 
                                                       && obj.getAlterMax() > user.getAge() 
                                                       && (obj.getGeschlecht().equals(user.getGender()) || obj.getGeschlecht().equals("d"))
                                                       && obj.getEinheit().equals("cm")).findFirst().get());
        
        filteredDGE.put("erefKG", this.eref.stream().filter(obj -> obj.getAlterMin() <= user.getAge() 
                                                       && obj.getAlterMax() > user.getAge() 
                                                       && (obj.getGeschlecht().equals(user.getGender()) || obj.getGeschlecht().equals("d"))
                                                       && obj.getEinheit().equals("kg")).findFirst().get());
        
        filteredDGE.put("protein", this.proteine.stream().filter(obj -> obj.getAlterMin() <= user.getAge() 
                                                       && obj.getAlterMax() > user.getAge() 
                                                       && (obj.getGeschlecht().equals(user.getGender()) || obj.getGeschlecht().equals("d"))).findFirst().get());
        
        filteredDGE.put("fett", this.fette.stream().filter(obj -> obj.getAlterMin() <= user.getAge() 
                                                       && obj.getAlterMax() > user.getAge()).findFirst().get());
        
        filteredDGE.put("blst", this.blst.stream().filter(obj -> obj.getAlterMin() <= user.getAge() 
                                                       && obj.getAlterMax() > user.getAge()).findFirst().get());
        
        filteredDGE.put("mengene", this.mengene.stream().filter(obj -> obj.getAlterMin() <= user.getAge() 
                                                       && obj.getAlterMax() > user.getAge() 
                                                       && (obj.getGeschlecht().equals(user.getGender()) || obj.getGeschlecht().equals("d"))).toList());
        
        filteredDGE.put("vitamine", this.vitamine.stream().filter(obj -> obj.getAlterMin() <= user.getAge() 
                                                       && obj.getAlterMax() > user.getAge() 
                                                       && (obj.getGeschlecht().equals(user.getGender()) || obj.getGeschlecht().equals("d"))).toList());
        
        filteredDGE.put("spur", this.spur.stream().filter(obj -> obj.getAlterMin() <= user.getAge() 
                                                       && obj.getAlterMax() > user.getAge() 
                                                       && (obj.getGeschlecht().equals(user.getGender()) || obj.getGeschlecht().equals("d"))
                                                       && (obj.getPhytatzufuhr() == user.getPhytatzufuhr() || obj.getPhytatzufuhr() == 2)).toList());
        
        filteredDGE.put("wasser", this.wasser.stream().filter(obj -> obj.getAlterMin() <= user.getAge() 
                                                       && obj.getAlterMax() > user.getAge()).findFirst().get());
        
        //log.warn("filteredDGE " + filteredDGE.toString());
        return filteredDGE;
    }
     
//    public List<Hauptgruppe> getHauptgruppen(){
//        return Collections.unmodifiableList(sbls1);
//    }
//    
//    public List<Untergruppe> getUntergruppen(){
//        return Collections.unmodifiableList(sbls2);
//    }
//    
//    public List<Untergruppe> getUntergruppenByHauptgruppe(String zeichen) {
//        return sbls2
//            .stream()
//            .filter( u -> u.getHauptgruppe().equals(zeichen))
//            .collect(Collectors.toList());
//    }
//    
//    
}
