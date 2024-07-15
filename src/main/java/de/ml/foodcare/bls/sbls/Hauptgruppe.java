package de.ml.foodcare.bls.sbls;

/**
 *
 * @author mathi
 */
public class Hauptgruppe {
    
    private int id;
    private String zeichen;
    private String text;
    private String text_E;
    
    private static int count;

    public Hauptgruppe() {
    }

    public Hauptgruppe(String zeichen, String text, String text_E) {
        this.id = ++count;
        this.zeichen = zeichen;
        this.text = text;
        this.text_E = text_E;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZeichen() {
        return zeichen;
    }

    public void setZeichen(String zeichen) {
        this.zeichen = zeichen;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText_E() {
        return text_E;
    }

    public void setText_E(String text_E) {
        this.text_E = text_E;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Hauptgruppe.count = count;
    }

    @Override
    public String toString() {
        return "Hauptgruppe{" + "id=" + id + ", zeichen=" + zeichen + ", text=" + text + ", text_E=" + text_E + '}';
    }
    
}
