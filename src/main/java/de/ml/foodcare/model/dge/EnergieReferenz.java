package de.ml.foodcare.model.dge;

/**
 *
 * @author mathi
 */
public class EnergieReferenz {
    
    private int alterMin;
    private int alterMax;
    private double wert;
    private String einheit;
    private String geschlecht;

    public EnergieReferenz(int alterMin, int alterMax, double wert, String einheit, String geschlecht) {
        this.alterMin = alterMin;
        this.alterMax = alterMax;
        this.wert = wert;
        this.einheit = einheit;
        this.geschlecht = geschlecht;
    }

    public EnergieReferenz() {
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

    public double getWert() {
        return wert;
    }

    public void setWert(double wert) {
        this.wert = wert;
    }

    public String getEinheit() {
        return einheit;
    }

    public void setEinheit(String einheit) {
        this.einheit = einheit;
    }

    public String getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
    }

    @Override
    public String toString() {
        return "EnergieReferenz{" + "alterMin=" + alterMin + ", alterMax=" + alterMax + ", wert=" + wert + ", einheit=" + einheit + ", geschlecht=" + geschlecht + '}';
    }
   
}
