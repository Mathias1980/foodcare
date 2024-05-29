package de.ml.foodcare.model;

/**
 *
 * @author mathi
 */
public class DateiaufbauZuordnung {
    
    private String zuordnung;
    private long count;

    public DateiaufbauZuordnung() {
    }

    public DateiaufbauZuordnung(String zuordnung, long count) {
        this.zuordnung = zuordnung;
        this.count = count;
    }

    public String getZuordnung() {
        return zuordnung;
    }

    public void setZuordnung(String zuordnung) {
        this.zuordnung = zuordnung;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "DateiaufbauCount{" + "zuordnung=" + zuordnung + ", count=" + count + '}';
    }
    
}
