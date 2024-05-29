package de.ml.foodcare.model.SBLS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 *
 * @author mathi
 */

@Service
public class SBLS_Service {
    
    private List<Hauptgruppe> sbls1;
    private List<Untergruppe> sbls2;

    public SBLS_Service() {
        sbls1 = new ArrayList<>();
        sbls1.add(new Hauptgruppe("B", "Brot und Kleingebäck", "Bread and small bakery products"));
        sbls1.add(new Hauptgruppe("C", "Cerealien, Getreide und Getreideprodukte, Reis ", "Cereals, grain and cereal products, rice"));
        sbls1.add(new Hauptgruppe("D", "Dauerbackwaren, Kuchen, Feinbackwaren", "Ready-made bakery products, cakes, pastries"));
        sbls1.add(new Hauptgruppe("E", "Eier und Eierprodukte, Teigwaren", "Eggs and egg products, pasta"));
        sbls1.add(new Hauptgruppe("F", "Früchte, Obst und Obsterzeugnisse (Fruchtsäfte, Konfitüren, Marmeladen)", "Fruit and fruit products (juices, jams, marmalades)"));
        sbls1.add(new Hauptgruppe("G", "Gemüse und Gemüseerzeugnisse", "Vegetables and vegetable products"));
        sbls1.add(new Hauptgruppe("H", "Hülsenfrüchte (reif), Schalenobst, Öl- und andere Samen", "Legumes (mature), nuts, oil- and other seeds"));
        sbls1.add(new Hauptgruppe("K", "Kartoffeln und Kartoffelerzeugnisse, stärkereiche Pflanzenteile, Pilze ", "Potatoes and potato products, starchy roots and tubers, mushrooms "));
        sbls1.add(new Hauptgruppe("M", "Milch, Milcherzeugnisse, Käse", "Milk, dairy products, cheese"));
        sbls1.add(new Hauptgruppe("N", "Nichtalkoholische Getränke (Kaffee, Tee, Erfrischungsgetränke)", "Non-alcoholic beverages (coffee, tea, soft drinks)"));
        sbls1.add(new Hauptgruppe("P", "Alkoholische Getränke (Bier, Wein, Spirituosen)", "Alcoholic beverages (beer, wine, spirits)"));
        sbls1.add(new Hauptgruppe("Q", "Öle, Fette, Butter, Schmalz, Talg", "Oils, fats, butter, lard, tallow"));
        sbls1.add(new Hauptgruppe("R", "Gewürze, Würzmittel, Hilfsstoffe", "Spices, condiments, food additives "));
        sbls1.add(new Hauptgruppe("S", "Süßwaren, Zucker, Bonbons, Schokolade, Brotaufstrich süß, Eis", "Sweets, sugar, candy, chocolate, spread (sweet), ice cream"));
        sbls1.add(new Hauptgruppe("T", "Tiefsee- und Süßwasserfische, Krusten-, Schalen-, Weichtiere", "Deep-sea and fresh-water fishes, shellfish (crustaceans and mollusks)"));
        sbls1.add(new Hauptgruppe("U", "Rind-, Kalb-, Schweine-, Hammel- und Lammfleisch", "Meat (excluding variety meats): Beef, veal, pork, mutton, lamb"));
        sbls1.add(new Hauptgruppe("V", "Wild, Geflügel, Federwild, Innereien", "Game, poultry, game birds, variety meats/giblets"));
        sbls1.add(new Hauptgruppe("W", "Wurst, Fleischwaren", "Sausages and other meat products"));       
        sbls1.add(new Hauptgruppe("X", "Menükomponenten überwiegend pflanzlich", "Composite dishes mainly containing vegetable products"));
        sbls1.add(new Hauptgruppe("Y", "Menükomponenten überwiegend tierisch", "Composite dishes mainly containing animal products"));
        
        sbls2 = new ArrayList<>();
        sbls2.add(new Untergruppe("B", 0, "Nicht belegt", ""));
        sbls2.add(new Untergruppe("B", 1, "Vollkornbrot", ""));
        sbls2.add(new Untergruppe("B", 2, "Graubrot", ""));
        sbls2.add(new Untergruppe("B", 3, "Weißbrot", ""));
        sbls2.add(new Untergruppe("B", 4, "Vollkornbrötchen (Kleingebäck)", ""));
        sbls2.add(new Untergruppe("B", 5, "Brötchen (Kleingebäck)", ""));
        sbls2.add(new Untergruppe("B", 6, "Knäckebrot", ""));
        sbls2.add(new Untergruppe("B", 7, "Spezialbrote und Spezialbrötchen", ""));
        sbls2.add(new Untergruppe("B", 8, "Broterzeugnisse", ""));
        sbls2.add(new Untergruppe("B", 9, "Nicht belegt", ""));
        
        sbls2.add(new Untergruppe("C", 0, "Nicht belegt", ""));
        sbls2.add(new Untergruppe("C", 1, "Getreide", ""));
        sbls2.add(new Untergruppe("C", 2, "Mehl", ""));
        sbls2.add(new Untergruppe("C", 3, "Spezielle Getreide", ""));
        sbls2.add(new Untergruppe("C", 4, "Spezielle Getreidemehle", ""));
        sbls2.add(new Untergruppe("C", 5, "Getreideerzeugnisse", ""));
        sbls2.add(new Untergruppe("C", 6, "Fertiggerichte auf Getreide- oder Mehlbasis", ""));
        sbls2.add(new Untergruppe("C", 7, "Nicht belegt", ""));
        sbls2.add(new Untergruppe("C", 8, "Nicht belegt", ""));
        sbls2.add(new Untergruppe("C", 9, "Fertiggerichte auf Reisbasis", ""));
        
        sbls2.add(new Untergruppe("D", 0, "Andere und ohne Angaben", ""));
        sbls2.add(new Untergruppe("D", 1, "Obstkuchen", ""));
        sbls2.add(new Untergruppe("D", 2, "Obsttorten", ""));
        sbls2.add(new Untergruppe("D", 3, "Torten", ""));
        sbls2.add(new Untergruppe("D", 4, "Kuchen", ""));
        sbls2.add(new Untergruppe("D", 5, "Kuchen und Torten aus besonderen Teigen", ""));
        sbls2.add(new Untergruppe("D", 6, "Gebäck aus besonderen Teigen", ""));
        sbls2.add(new Untergruppe("D", 7, "Gebäck, Plätzchen", ""));
        sbls2.add(new Untergruppe("D", 8, "Backwarenerzeugnisse", ""));
        sbls2.add(new Untergruppe("D", 9, "Nicht belegt", ""));
        
        sbls2.add(new Untergruppe("E", 0, "Nicht belegt", ""));
        sbls2.add(new Untergruppe("E", 1, "Eier", ""));
        sbls2.add(new Untergruppe("E", 2, "Nicht belegt", ""));
        sbls2.add(new Untergruppe("E", 3, "Fertiggerichte auf Eibasis", ""));
        sbls2.add(new Untergruppe("E", 4, "Teigwaren", ""));
        sbls2.add(new Untergruppe("E", 5, "Vollkornteigwaren", ""));
        sbls2.add(new Untergruppe("E", 6, "Teigwaren besonderer Art", ""));
        sbls2.add(new Untergruppe("E", 7, "Vollkornteigwaren besonderer Art", ""));
        sbls2.add(new Untergruppe("E", 8, "Teigwarenerzeugnisse", ""));
        sbls2.add(new Untergruppe("E", 9, "Fertiggerichte auf Teigwarenbasis", ""));
        
        sbls2.add(new Untergruppe("F", 0, "Andere und ohne Angaben", ""));
        sbls2.add(new Untergruppe("F", 1, "Kernobst", ""));
        sbls2.add(new Untergruppe("F", 2, "Steinobst", ""));
        sbls2.add(new Untergruppe("F", 3, "Beerenobst", ""));
        sbls2.add(new Untergruppe("F", 4, "Wildfrüchte", ""));
        sbls2.add(new Untergruppe("F", 5, "Südfrüchte", ""));
        sbls2.add(new Untergruppe("F", 6, "Zitrusfrüchte", ""));
        sbls2.add(new Untergruppe("F", 7, "Nicht belegt", ""));
        sbls2.add(new Untergruppe("F", 8, "Obsterzeugnisse", ""));
        sbls2.add(new Untergruppe("F", 9, "Fertiggerichte auf Obstbasis", ""));
        
        sbls2.add(new Untergruppe("G", 0, "Andere und ohne Angaben", ""));
        sbls2.add(new Untergruppe("G", 1, "Salatgemüse", ""));
        sbls2.add(new Untergruppe("G", 2, "Blattgemüse", ""));
        sbls2.add(new Untergruppe("G", 3, "Kohlgemüse", ""));
        sbls2.add(new Untergruppe("G", 4, "Sprossen- und Lauchgemüse", ""));
        sbls2.add(new Untergruppe("G", 5, "Fruchtgemüse", ""));
        sbls2.add(new Untergruppe("G", 6, "Wurzel- und Knollengemüse (außer Kartoffeln)", ""));
        sbls2.add(new Untergruppe("G", 7, "Hülsenfruchtgemüse unreif", ""));
        sbls2.add(new Untergruppe("G", 8, "Gemüseerzeugnisse", ""));
        sbls2.add(new Untergruppe("G", 9, "Fertiggerichte auf Gemüsebasis", ""));
        
        sbls2.add(new Untergruppe("H", 0, "Andere und ohne Angaben", ""));
        sbls2.add(new Untergruppe("H", 1, "Nüsse", ""));
        sbls2.add(new Untergruppe("H", 2, "Anderes Schalenobst", ""));
        sbls2.add(new Untergruppe("H", 3, "Kerne", ""));
        sbls2.add(new Untergruppe("H", 4, "Ölsamen", ""));
        sbls2.add(new Untergruppe("H", 5, "Ölfrüchte", ""));
        sbls2.add(new Untergruppe("H", 6, "Sprossen, Keime", ""));
        sbls2.add(new Untergruppe("H", 7, "Hülsenfrüchte (reif)", ""));
        sbls2.add(new Untergruppe("H", 8, "Nuss- und Ölsamenerzeugnisse", ""));
        sbls2.add(new Untergruppe("H", 9, "Hülsenfruchtger ichte", ""));
        
        sbls2.add(new Untergruppe("K", 0, "Nicht belegt", ""));
        sbls2.add(new Untergruppe("K", 1, "Kartoffeln", ""));
        sbls2.add(new Untergruppe("K", 2, "Kartoffelerzeugnisse", ""));
        sbls2.add(new Untergruppe("K", 3, "Fertiggerichte auf Kartoffelbasis", ""));
        sbls2.add(new Untergruppe("K", 4, "Stärkereiche Pflanzenteile", ""));
        sbls2.add(new Untergruppe("K", 5, "Erzeugnisse stärkereicher Pflanzenteile", ""));
        sbls2.add(new Untergruppe("K", 6, "Nicht belegt", ""));
        sbls2.add(new Untergruppe("K", 7, "Zuchtpilze, Wildpilze", ""));
        sbls2.add(new Untergruppe("K", 8, "Pilzerzeugnisse", ""));
        sbls2.add(new Untergruppe("K", 9, "Fertiggerichte auf Pilzbasis", ""));
        
        sbls2.add(new Untergruppe("M", 0, "Andere und ohne Angaben", ""));
        sbls2.add(new Untergruppe("M", 1, "Milch und Sauermilch", ""));
        sbls2.add(new Untergruppe("M", 2, "Milchmischerzeugnisse", ""));
        sbls2.add(new Untergruppe("M", 3, "Hartkäse", ""));
        sbls2.add(new Untergruppe("M", 4, "Schnittkäse", ""));
        sbls2.add(new Untergruppe("M", 5, "Schnittkäse halbfest", ""));
        sbls2.add(new Untergruppe("M", 6, "Weichkäse", ""));
        sbls2.add(new Untergruppe("M", 7, "Frischkäse, Sauermilchkäse, Kochkäse, Schmelzkäse", ""));
        sbls2.add(new Untergruppe("M", 8, "Milch- und Käseerzeugnisse", ""));
        sbls2.add(new Untergruppe("M", 9, "Nicht belegt", ""));
              
        sbls2.add(new Untergruppe("N", 0, "Andere und ohne Angaben", ""));
        sbls2.add(new Untergruppe("N", 1, "Mineralwasser, Trinkwasser", ""));
        sbls2.add(new Untergruppe("N", 2, "Fruchtsaftgetränke", ""));
        sbls2.add(new Untergruppe("N", 3, "Brausen, Limonaden", ""));
        sbls2.add(new Untergruppe("N", 4, "Kaffee", ""));
        sbls2.add(new Untergruppe("N", 5, "Kaffee-Ersatz", ""));
        sbls2.add(new Untergruppe("N", 6, "Tee", ""));
        sbls2.add(new Untergruppe("N", 7, "Früchtetee, Kräutertee", ""));
        sbls2.add(new Untergruppe("N", 8, "Nicht belegt", ""));
        sbls2.add(new Untergruppe("N", 9, "Nicht belegt", ""));
        
        sbls2.add(new Untergruppe("P", 0, "Andere und ohne Angaben", ""));
        sbls2.add(new Untergruppe("P", 1, "Bier (durchschnittlich 3,5 Vol%)", ""));
        sbls2.add(new Untergruppe("P", 2, "Weißwein, Rotwein, Roséwein (durchschnittlich 10 Vol%)", ""));
        sbls2.add(new Untergruppe("P", 3, "Weinähnliche Getränke, Schaumwein (bis 18 Vol%)", ""));
        sbls2.add(new Untergruppe("P", 4, "Likörwein (süß oder trocken) (15 - 22 Vol%)", ""));
        sbls2.add(new Untergruppe("P", 5, "Likör (durchschnittlich 32 Vol%)", ""));
        sbls2.add(new Untergruppe("P", 6, "Branntwein aus Wein", ""));
        sbls2.add(new Untergruppe("P", 7, "Spirituosen (mindestens 32 - 40 Vol%)", ""));
        sbls2.add(new Untergruppe("P", 8, "Alkoholische Erzeugnisse", ""));
        sbls2.add(new Untergruppe("P", 9, "Cocktails", ""));
        
        sbls2.add(new Untergruppe("Q", 0, "Andere und ohne Angaben", ""));
        sbls2.add(new Untergruppe("Q", 1, "Pflanzliche Öle, < 30 % Linol säuregehalt", ""));
        sbls2.add(new Untergruppe("Q", 2, "Pflanzliche Öle, 30 - 60 % Linol säuregehalt", ""));
        sbls2.add(new Untergruppe("Q", 3, "Pflanzliche Öle, > 60 % Linol säuregehalt", ""));
        sbls2.add(new Untergruppe("Q", 4, "Margarine", ""));
        sbls2.add(new Untergruppe("Q", 5, "Pflanzliche Fette", ""));
        sbls2.add(new Untergruppe("Q", 6, "Butter", ""));
        sbls2.add(new Untergruppe("Q", 7, "Tierische Öle", ""));
        sbls2.add(new Untergruppe("Q", 8, "Tierische Fette", ""));
        sbls2.add(new Untergruppe("Q", 9, "Ölsoßen, Mayonnaisen, Fettzubereitungen", ""));
        
        sbls2.add(new Untergruppe("R", 0, "Andere und ohne Angaben", ""));
        sbls2.add(new Untergruppe("R", 1, "Würzmittel", ""));
        sbls2.add(new Untergruppe("R", 2, "Gewürze", ""));
        sbls2.add(new Untergruppe("R", 3, "Essenzen, Aromastoffe", ""));
        sbls2.add(new Untergruppe("R", 4, "Hilfsmittel, Backtrieb-, Gelier- und Dickungsmittel", ""));
        sbls2.add(new Untergruppe("R", 5, "Organische Säuren", ""));
        sbls2.add(new Untergruppe("R", 6, "Konservierungsstoffe", ""));
        sbls2.add(new Untergruppe("R", 7, "Vitaminpräparate, Mineralstoffpräparate", ""));
        sbls2.add(new Untergruppe("R", 8, "Brühwürfel, Fleischextrakt", ""));
        sbls2.add(new Untergruppe("R", 9, "Rezeptzutaten, Fertigerzeugnisse", ""));
        
        sbls2.add(new Untergruppe("S", 0, "Andere und ohne Angaben", ""));
        sbls2.add(new Untergruppe("S", 1, "Zucker, Honig, Brotaufstrich süß", ""));
        sbls2.add(new Untergruppe("S", 2, "Speiseeis", ""));
        sbls2.add(new Untergruppe("S", 3, "Zuckerwaren, Bonbons", ""));
        sbls2.add(new Untergruppe("S", 4, "Marzipan, Lakritze, Krokant, Nougat", ""));
        sbls2.add(new Untergruppe("S", 5, "Schokolade", ""));
        sbls2.add(new Untergruppe("S", 6, "Schokoladenwaren, Pralinen", ""));
        sbls2.add(new Untergruppe("S", 7, "Kakao, Kakaogetränk", ""));
        sbls2.add(new Untergruppe("S", 8, "Süßwarenerzeugnisse", ""));
        sbls2.add(new Untergruppe("S", 9, "Fertiggerichte auf Süßwarenbasis", ""));
        
        sbls2.add(new Untergruppe("T", 0, "Andere und ohne Angaben", ""));
        sbls2.add(new Untergruppe("T", 1, "Heringsfische, Makrelen, Thunfische", ""));
        sbls2.add(new Untergruppe("T", 2, "Dorschartige Fische, Kabeljau, Schellfisch, Seelachs", ""));
        sbls2.add(new Untergruppe("T", 3, "Plattfische", ""));
        sbls2.add(new Untergruppe("T", 4, "Lachsfische", ""));
        sbls2.add(new Untergruppe("T", 5, "Karpfenfische", ""));
        sbls2.add(new Untergruppe("T", 6, "Barschartige Fische", ""));
        sbls2.add(new Untergruppe("T", 7, "Krebstiere, Muscheltiere", ""));
        sbls2.add(new Untergruppe("T", 8, "Fischerzeugnisse", ""));
        sbls2.add(new Untergruppe("T", 9, "Fertiggerichte auf Fischbasis", ""));
        
        sbls2.add(new Untergruppe("U", 0, "Andere und ohne Angaben", ""));
        sbls2.add(new Untergruppe("U", 1, "Rindfleischstücke", ""));
        sbls2.add(new Untergruppe("U", 2, "Rindfleischschnitte", ""));
        sbls2.add(new Untergruppe("U", 3, "Kalbfleischstücke", ""));
        sbls2.add(new Untergruppe("U", 4, "Kalbfleischschnitte", ""));
        sbls2.add(new Untergruppe("U", 5, "Schweinefleischstücke", ""));
        sbls2.add(new Untergruppe("U", 6, "Schweinefleischschnitte", ""));
        sbls2.add(new Untergruppe("U", 7, "Hammel-/Lammfleischstücke", ""));
        sbls2.add(new Untergruppe("U", 8, "Hammel-/Lammfleischschnitte", ""));
        sbls2.add(new Untergruppe("U", 9, "Fertiggerichte auf Fleischbasis", ""));
        
        sbls2.add(new Untergruppe("V", 0, "Andere und ohne Angaben", ""));
        sbls2.add(new Untergruppe("V", 1, "Pferd, Ziege, Kaninchen", ""));
        sbls2.add(new Untergruppe("V", 2, "Haarnutzwild", ""));
        sbls2.add(new Untergruppe("V", 3, "Federwild", ""));
        sbls2.add(new Untergruppe("V", 4, "Geflügel", ""));
        sbls2.add(new Untergruppe("V", 5, "Innereien von Nutztieren", ""));
        sbls2.add(new Untergruppe("V", 6, "Innereien von Wild und Geflügel", ""));
        sbls2.add(new Untergruppe("V", 7, "Nicht belegt", ""));
        sbls2.add(new Untergruppe("V", 8, "Fleischerzeugnisse", ""));
        sbls2.add(new Untergruppe("V", 9, "Fertiggerichte auf Wild- und Geflügelbasis", ""));
        
        sbls2.add(new Untergruppe("W", 0, "Andere und ohne Angaben", ""));
        sbls2.add(new Untergruppe("W", 1, "Rohwurst", ""));
        sbls2.add(new Untergruppe("W", 2, "Brühwurst", ""));
        sbls2.add(new Untergruppe("W", 3, "Kochwurst", ""));
        sbls2.add(new Untergruppe("W", 4, "Speck, Schinken", ""));
        sbls2.add(new Untergruppe("W", 5, "Fleischwaren", ""));
        sbls2.add(new Untergruppe("W", 6, "Pökelwaren", ""));
        sbls2.add(new Untergruppe("W", 7, "Nicht belegt", ""));
        sbls2.add(new Untergruppe("W", 8, "Fleischwarenerzeugnisse", ""));
        sbls2.add(new Untergruppe("W", 9, "Fertiggerichte auf Fleischwarenbasis", ""));
        
        sbls2.add(new Untergruppe("X", 0, "Belegte Brote, Toasts, Frühstückscerealien", ""));
        sbls2.add(new Untergruppe("X", 1, "Salate, gegart", ""));
        sbls2.add(new Untergruppe("X", 2, "Salate, roh", ""));
        sbls2.add(new Untergruppe("X", 3, "Soßen", ""));
        sbls2.add(new Untergruppe("X", 4, "Suppen", ""));
        sbls2.add(new Untergruppe("X", 5, "Gemüsebeilagen", ""));
        sbls2.add(new Untergruppe("X", 6, "Kartoffelgerichte", ""));
        sbls2.add(new Untergruppe("X", 7, "Nudel-/Teigwarengerichte", ""));
        sbls2.add(new Untergruppe("X", 8, "Reisgerichte", ""));
        sbls2.add(new Untergruppe("X", 9, "Getreide-, Mehl- und Milchspeisen", ""));
        
        sbls2.add(new Untergruppe("Y", 0, "Würstchen, Hackfleischgerichte", ""));
        sbls2.add(new Untergruppe("Y", 1, "Fleischgerichte vom Rind", ""));
        sbls2.add(new Untergruppe("Y", 2, "Fleischgerichte vom Kalb", ""));
        sbls2.add(new Untergruppe("Y", 3, "Fleischgerichte vom Schwein", ""));
        sbls2.add(new Untergruppe("Y", 4, "Fleischgerichte von Hammel/Lamm", ""));
        sbls2.add(new Untergruppe("Y", 5, "Fleischgerichte von Wild und Geflügel", ""));
        sbls2.add(new Untergruppe("Y", 6, "Fischgerichte", "")); 
        sbls2.add(new Untergruppe("Y", 7, "Eier-, Quark- und Käsegerichte", ""));
        sbls2.add(new Untergruppe("Y", 8, "Süßspeisen, Desserts", ""));
        sbls2.add(new Untergruppe("Y", 9, "Schnellgerichte, Eis", ""));
        
        
    }
    
    public List<Hauptgruppe> getHauptgruppen(){
        return Collections.unmodifiableList(sbls1);
    }
    
    public List<Untergruppe> getUntergruppen(){
        return Collections.unmodifiableList(sbls2);
    }
    
    public List<Untergruppe> getUntergruppenByHauptgruppe(String zeichen) {
        return sbls2
            .stream()
            .filter( u -> u.getHauptgruppe().equals(zeichen))
            .collect(Collectors.toList());
    }
    
    
}
