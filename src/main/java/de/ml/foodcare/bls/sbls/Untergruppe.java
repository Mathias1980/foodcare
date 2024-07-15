package de.ml.foodcare.bls.sbls;

/**
 *
 * @author mathi
 */
public class Untergruppe {
    
    private int id;
    private String hauptgruppe;
    private int untergruppe;
    private String text;
    private String text_E;
    
    private static int count;

    public Untergruppe() {
    }

    public Untergruppe(String hauptgruppe, int untergruppe, String text, String text_E) {
        this.id = ++count;
        this.hauptgruppe = hauptgruppe;
        this.untergruppe = untergruppe;
        this.text = text;
        this.text_E = text_E;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHauptgruppe() {
        return hauptgruppe;
    }

    public void setHauptgruppe(String hauptgruppe) {
        this.hauptgruppe = hauptgruppe;
    }

    public int getUntergruppe() {
        return untergruppe;
    }

    public void setUntergruppe(int untergruppe) {
        this.untergruppe = untergruppe;
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
        Untergruppe.count = count;
    }

    @Override
    public String toString() {
        return "Untergruppe{" + "id=" + id + ", hauptgruppe=" + hauptgruppe + ", untergruppe=" + untergruppe + ", text=" + text + ", text_E=" + text_E + '}';
    }
      
}
