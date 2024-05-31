package de.ml.foodcare.model.dto;

/**
 *
 * @author mathi
 */
public class BLS_Dto {
    
    private String sbls;
    private int feld;
    private String kurz;
    private String name;
    private String art;
    private String dimension;
    private String zuordnung;
    private double y;
    private double abs;
    private String info;

    public BLS_Dto() {
    }
    
    public BLS_Dto(String kurz, double abs) {
        this.kurz = kurz;
        this.abs = abs;
    }

    public BLS_Dto(String sbls, int feld, String kurz, String name, String art, String dimension, String zuordnung, double y, double abs, String info) {
        this.sbls = sbls;
        this.feld = feld;
        this.kurz = kurz;
        this.name = name;
        this.art = art;
        this.dimension = dimension;
        this.zuordnung = zuordnung;
        this.y = y;
        this.abs = abs;
        this.info = info;
    }

    public String getSbls() {
        return sbls;
    }

    public void setSbls(String sbls) {
        this.sbls = sbls;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getFeld() {
        return feld;
    }

    public void setFeld(int feld) {
        this.feld = feld;
    }

    public String getKurz() {
        return kurz;
    }

    public void setKurz(String kurz) {
        this.kurz = kurz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getZuordnung() {
        return zuordnung;
    }

    public void setZuordnung(String zuordnung) {
        this.zuordnung = zuordnung;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getAbs() {
        return abs;
    }

    public void setAbs(double abs) {
        this.abs = abs;
    }

    @Override
    public String toString() {
        return "BLS_Dto{" + "sbls=" + sbls + ", feld=" + feld + ", kurz=" + kurz + ", name=" + name + ", art=" + art + ", dimension=" + dimension + ", zuordnung=" + zuordnung + ", y=" + y + ", abs=" + abs + ", info=" + info + '}';
    }

}
