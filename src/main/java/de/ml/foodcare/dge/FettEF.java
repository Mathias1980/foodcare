package de.ml.foodcare.dge;

/**
 *
 * @author mathi
 */
public class FettEF {
    
    private int alterMin;
    private int alterMax;
    private int fettProzentEnergie;
    private double fettLinolProzentEnergie;
    private double fettAlphalinolProzentEnergie;

    public FettEF() {
    }

    public FettEF(int alterMin, int alterMax, int fettProzentEnergie, double fettLinolProzentEnergie, double fettAlphalinolProzentEnergie) {
        this.alterMin = alterMin;
        this.alterMax = alterMax;
        this.fettProzentEnergie = fettProzentEnergie;
        this.fettLinolProzentEnergie = fettLinolProzentEnergie;
        this.fettAlphalinolProzentEnergie = fettAlphalinolProzentEnergie;
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

    public int getFettProzentEnergie() {
        return fettProzentEnergie;
    }

    public void setFettProzentEnergie(int fettProzentEnergie) {
        this.fettProzentEnergie = fettProzentEnergie;
    }

    public double getFettLinolProzentEnergie() {
        return fettLinolProzentEnergie;
    }

    public void setFettLinolProzentEnergie(double fettLinolProzentEnergie) {
        this.fettLinolProzentEnergie = fettLinolProzentEnergie;
    }

    public double getFettAlphalinolProzentEnergie() {
        return fettAlphalinolProzentEnergie;
    }

    public void setFettAlphalinolProzentEnergie(double fettAlphalinolProzentEnergie) {
        this.fettAlphalinolProzentEnergie = fettAlphalinolProzentEnergie;
    }

    @Override
    public String toString() {
        return "FettEF{" + "alterMin=" + alterMin + ", alterMax=" + alterMax + ", fettProzentEnergie=" + fettProzentEnergie + ", fettLinolProzentEnergie=" + fettLinolProzentEnergie + ", fettAlphalinolProzentEnergie=" + fettAlphalinolProzentEnergie + '}';
    }
    
}
