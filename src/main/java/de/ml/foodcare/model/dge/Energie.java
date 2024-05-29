package de.ml.foodcare.model.dge;

/**
 *
 * @author mathi
 */
public class Energie {
    
    private int alterMin;
    private int alterMax;
    private double pal;
    private String geschlecht;
    private double kcalProTag;

    public Energie() {
    }

    public Energie(int alterMin, int alterMax, double pal, String geschlecht, double kcalProTag) {
        this.alterMin = alterMin;
        this.alterMax = alterMax;
        this.pal = pal;
        this.geschlecht = geschlecht;
        this.kcalProTag = kcalProTag;
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

    public double getPal() {
        return pal;
    }

    public void setPal(double pal) {
        this.pal = pal;
    }

    public String getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
    }

    public double getKcalProTag() {
        return kcalProTag;
    }

    public void setKcalProTag(double kcalProTag) {
        this.kcalProTag = kcalProTag;
    }

    @Override
    public String toString() {
        return "Energie{" + "alterMin=" + alterMin + ", alterMax=" + alterMax + ", pal=" + pal + ", geschlecht=" + geschlecht + '}';
    }
    
}
