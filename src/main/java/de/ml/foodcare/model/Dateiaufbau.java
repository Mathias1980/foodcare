package de.ml.foodcare.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author mathi
 */
@Entity
@Table(name = "dateiaufbau")
public class Dateiaufbau {
    
    @Id
    private int feld;
    private String kurz;
    private String variable;
    private String art;
    private double laenge;
    private String dimension;
    private String zuordnung;

    public Dateiaufbau() {
    }

    public Dateiaufbau(int feld, String kurz, String variable, String art, double laenge, String dimension, String zuordnung) {
        this.feld = feld;
        this.kurz = kurz;
        this.variable = variable;
        this.art = art;
        this.laenge = laenge;
        this.dimension = dimension;
        this.zuordnung = zuordnung;
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

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    public double getLaenge() {
        return laenge;
    }

    public void setLaenge(double laenge) {
        this.laenge = laenge;
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

    @Override
    public String toString() {
        return "Dateiaufbau{" + "feld=" + feld + ", kurz=" + kurz + ", variable=" + variable + ", art=" + art + ", laenge=" + laenge + ", dimension=" + dimension + ", zuordnung=" + zuordnung + '}';
    }
    
    
    
}
