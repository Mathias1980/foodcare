package de.ml.foodcare.dge;

/**
 *
 * @author mathi
 */
public class Protein {
    
    private int alterMin;
    private int alterMax;
    private String geschlecht;
    private double gProKgGewichtProTag;

    public Protein() {
    }

    public Protein(int alterMin, int alterMax, String geschlecht, double gProKgGewichtProTag) {
        this.alterMin = alterMin;
        this.alterMax = alterMax;
        this.geschlecht = geschlecht;
        this.gProKgGewichtProTag = gProKgGewichtProTag;
    }

    public int getAlterMin() {
        return alterMin;
    }

    public void setAlterMin(int alterMin) {
        this.alterMin = alterMin;
    }

    public int getAlterMax() {
        return alterMax;
    }

    public void setAlterMax(int alterMax) {
        this.alterMax = alterMax;
    }

    public String getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
    }

    public double getgProKgGewichtProTag() {
        return gProKgGewichtProTag;
    }

    public void setgProKgGewichtProTag(double gProKgGewichtProTag) {
        this.gProKgGewichtProTag = gProKgGewichtProTag;
    }
    
    
    
}
