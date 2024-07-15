package de.ml.foodcare.dge;

/**
 *
 * @author mathi
 */
public class Spurenelement {
    
    private String bez;
    private int alterMin;
    private int alterMax;
    private double einheitProTag;
    private String einheit;
    private String geschlecht;
    private int phytatzufuhr;

    public Spurenelement() {
    }

    public Spurenelement(String bez, int alterMin, int alterMax, double einheitProTag, String einheit, String geschlecht, int phytatzufuhr) {
        this.bez = bez;
        this.alterMin = alterMin;
        this.alterMax = alterMax;
        this.einheitProTag = einheitProTag;
        this.einheit = einheit;
        this.geschlecht = geschlecht;
        this.phytatzufuhr = phytatzufuhr;
    }

    public int getPhytatzufuhr() {
        return phytatzufuhr;
    }

    public void setPhytatzufuhr(int phytatzufuhr) {
        this.phytatzufuhr = phytatzufuhr;
    }

    
    public String getBez() {
        return bez;
    }

    public void setBez(String bez) {
        this.bez = bez;
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

    public double getEinheitProTag() {
        return einheitProTag;
    }

    public void setEinheitProTag(double einheitProTag) {
        this.einheitProTag = einheitProTag;
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
        return "Spurenelement{" + "bez=" + bez + ", alterMin=" + alterMin + ", alterMax=" + alterMax + ", einheitProTag=" + einheitProTag + ", einheit=" + einheit + ", geschlecht=" + geschlecht + ", phytatzufuhr=" + phytatzufuhr + '}';
    }
      
}
