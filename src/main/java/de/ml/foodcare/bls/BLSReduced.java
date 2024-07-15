package de.ml.foodcare.bls;

/**
 *
 * @author mathi
 */
public class BLSReduced {
    
    private int id;
    private String SBLS;
    private String ST;

    public BLSReduced(int id, String SBLS, String ST) {
        this.SBLS = SBLS;
        this.ST = ST;
        this.id = id;
    }

    public String getSBLS() {
        return SBLS;
    }

    public void setSBLS(String SBLS) {
        this.SBLS = SBLS;
    }

    public String getST() {
        return ST;
    }

    public void setST(String ST) {
        this.ST = ST;
    }
      
}
