package de.ml.foodcare.model.dge;

/**
 *
 * @author mathi
 */
public class Wasser {
    
    private int alterMin;
    private int alterMax;
    private int zufuhrMlProKgProTag;

    public Wasser() {
    }

    public Wasser(int alterMin, int alterMax, int zufuhrMlProKgProTag) {
        this.alterMin = alterMin;
        this.alterMax = alterMax;
        this.zufuhrMlProKgProTag = zufuhrMlProKgProTag;
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

    public int getZufuhrMlProKgProTag() {
        return zufuhrMlProKgProTag;
    }

    public void setZufuhrMlProKgProTag(int zufuhrMlProKgProTag) {
        this.zufuhrMlProKgProTag = zufuhrMlProKgProTag;
    }

    @Override
    public String toString() {
        return "Wasser{" + "alterMin=" + alterMin + ", alterMax=" + alterMax + ", zufuhrMlProKgProTag=" + zufuhrMlProKgProTag + '}';
    }
    
}
