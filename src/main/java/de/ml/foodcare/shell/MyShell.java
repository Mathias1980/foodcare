package de.ml.foodcare.shell;

import de.ml.foodcare.data.Import;
import de.ml.foodcare.bls.BLSRepository;
import de.ml.foodcare.bls.dateiaufbau.DateiaufbauRepository;
import de.ml.foodcare.bls.BLS;
import de.ml.foodcare.bls.dateiaufbau.Dateiaufbau;
import de.ml.foodcare.bls.sbls.Hauptgruppe;
import de.ml.foodcare.bls.sbls.SBLS_Service;
import de.ml.foodcare.bls.sbls.Untergruppe;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

/**
 *
 * @author mathi
 */
@ShellComponent
public class MyShell {
    
    private BLSRepository bls;
    private DateiaufbauRepository dateiaufbau;
    private Import readdata;
    private SBLS_Service sblsservice;
    
    public MyShell(BLSRepository bls, DateiaufbauRepository dateiaufbau, Import i, SBLS_Service sblsservice){
        this.bls = bls;
        this.dateiaufbau = dateiaufbau;
        this.readdata = readdata;
        this.sblsservice = sblsservice;
    }
    
    @ShellMethod("Exceltabelle BLS-Dateiaufbau importieren.")
    public List<Dateiaufbau> importDateiaufbau() throws IOException{
        List<Dateiaufbau> list = readdata.readExcelDateiaufbau();
        return dateiaufbau.saveAll(list);
    }
    
    @ShellMethod("Exceltabelle BLS-302 importieren.")
    public String importBls() throws IOException, IllegalAccessException, InvocationTargetException{
        List<BLS> list = readdata.readExcelBLS();
        bls.saveAll(list);
        return "BLS: " + list.size();
    }
    
    @ShellMethod("Hauptgruppen")
    public List<Hauptgruppe> hauptgruppen(){
        return sblsservice.getHauptgruppen();
    }
    
    @ShellMethod("Untergruppen")
    public List<Untergruppe> untergruppen(){
        return sblsservice.getUntergruppen();
    }
    
    @ShellMethod("Untergruppen nach Hauptgruppe")
    public List<Untergruppe> untergruppenHauptgruppe(String zeichen){
        return sblsservice.getUntergruppenByHauptgruppe(zeichen);
    }
    
//    @ShellMethod("BLS nach Untergruppe")
//    public List<BLS> blsUntergruppe(String untergruppe) {
//        return bls.findBySBLSStartingWith(untergruppe);
//    }
    
    @ShellMethod("BLS gruppiert nach Untergruppe")
    public List<BLS> findMaxValuesUG() {
        return bls.findMaxValuesUG();
    }
    
    @ShellMethod("BLS gruppiert nach Untergruppe")
    public List<BLS> findAvgValuesUG() {
        return bls.findAvgValuesUG();
    }
    
    @ShellMethod("BLS gruppiert nach Untergruppe")
    public List<BLS> findMaxValuesByUntergruppe(String untergruppe) {
        return bls.findMaxValuesByUntergruppe(untergruppe);
    }
    
    @ShellMethod("BLS gruppiert nach Untergruppe")
    public List<BLS> findAvgValuesByUntergruppe(String untergruppe) {
        return bls.findAvgValuesByUntergruppe(untergruppe);
    }
    
    @ShellMethod("Test")
    public String test() {
        List<String> liste = new ArrayList();
        
        Class<?> foodClass = BLS.class;
        Field[] fields = foodClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.getType() == double.class) {
                liste.add(field.getName());
            }
        }

        String select  = "SELECT substring(b.sbls, 1, 2) as sbls ";
        String gruppierung = liste.stream()
                .map(field -> "MAX(b." + field + ") as " + field)
                .collect(Collectors.joining(", "));
        String sql = select + ", " + gruppierung + " FROM Bls b GROUP BY substring(b.sbls, 1, 2)";
        return sql;
    }
  
}
 