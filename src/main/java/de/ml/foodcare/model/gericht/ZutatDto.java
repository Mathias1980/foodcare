package de.ml.foodcare.model.gericht;

/**
 *
 * @author mathi
 */
public class ZutatDto {
    
    private String sbls;
    private double menge;

    public ZutatDto() {
    }

    public ZutatDto(String sbls, double menge) {
        this.sbls = sbls;
        this.menge = menge;
    }

    public String getSbls() {
        return sbls;
    }

    public void setSbls(String sbls) {
        this.sbls = sbls;
    }

    public double getMenge() {
        return menge;
    }

    public void setMenge(double menge) {
        this.menge = menge;
    }

    @Override
    public String toString() {
        return "ZutatDto{" + "sbls=" + sbls + ", menge=" + menge + '}';
    }
    
}
