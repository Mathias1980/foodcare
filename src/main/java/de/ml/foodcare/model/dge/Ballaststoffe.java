package de.ml.foodcare.model.dge;

/**
 *
 * @author mathi
 */
public class Ballaststoffe {
    
    private int alterMin;
    private int alterMax;
    private double gProTausendKcal;

    public Ballaststoffe() {
    }

    public Ballaststoffe(int alterMin, int alterMax, double gProTausendKcal) {
        this.alterMin = alterMin;
        this.alterMax = alterMax;
        this.gProTausendKcal = gProTausendKcal;
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

    public double getgProTausendKcal() {
        return gProTausendKcal;
    }

    public void setgProTausendKcal(double gProTausendKcal) {
        this.gProTausendKcal = gProTausendKcal;
    }

    @Override
    public String toString() {
        return "Ballaststoffe{" + "alterMin=" + alterMin + ", alterMax=" + alterMax + ", gProTausendKcal=" + gProTausendKcal + '}';
    }
     
}
