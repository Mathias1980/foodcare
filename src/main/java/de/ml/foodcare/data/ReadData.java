package de.ml.foodcare.data;

import de.ml.foodcare.data.BLSRepository;
import de.ml.foodcare.data.DateiaufbauRepository;
import de.ml.foodcare.model.BLS;
import de.ml.foodcare.model.Dateiaufbau;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author mathi
 */
@Service
public class ReadData {
    
    private static final String FILE_PATH_Dateiaufbau = "src/main/resources/BLS-Dateiaufbau.xlsx";
    private static final String FILE_PATH_BLS = "src/main/resources/BLS_302.xlsx";
    private static final Logger log = LoggerFactory.getLogger(ReadData.class);
    
    private DateiaufbauRepository dateiaufbau;
    
    public ReadData(DateiaufbauRepository dateiaufbau){
        this.dateiaufbau = dateiaufbau;
    }
    
    public List<Dateiaufbau> readExcelDateiaufbau() throws IOException {
        List<Dateiaufbau> dataObjects = new ArrayList<>();
        FileInputStream excelFile = new FileInputStream(new File(FILE_PATH_Dateiaufbau));
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet sheet = workbook.getSheetAt(0);
        
        for (int rowNum = 14; rowNum <= 155; rowNum++) {
            Row row = sheet.getRow(rowNum);
            if (row != null) {
                Dateiaufbau dataObject = new Dateiaufbau();   
                Cell cell = row.getCell(0);
                dataObject.setFeld((int) row.getCell(0).getNumericCellValue());
                cell = row.getCell(1);
                dataObject.setKurz((cell != null) ? cell.getStringCellValue() : "");
                cell = row.getCell(2);
                dataObject.setVariable((cell != null) ? cell.getStringCellValue() : "");
                cell = row.getCell(3);
                dataObject.setArt((cell != null) ? cell.getStringCellValue() : "");
                cell = row.getCell(4);
                dataObject.setLaenge((double) row.getCell(4).getNumericCellValue());
                cell = row.getCell(5);
                dataObject.setDimension((cell != null) ? cell.getStringCellValue() : "");
                cell = row.getCell(6);
                dataObject.setZuordnung((cell != null) ? cell.getStringCellValue() : "");
                dataObjects.add(dataObject);
            }
        }
        workbook.close();
        return dataObjects;
    }
    
    public List<BLS> readExcelBLS() throws IOException, IllegalAccessException, InvocationTargetException {
        
        List<Dateiaufbau> dateiliste = dateiaufbau.findAll();
            
        List<BLS> dataObjects = new ArrayList<>();
        FileInputStream excelFile = new FileInputStream(new File(FILE_PATH_BLS));
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet sheet = workbook.getSheetAt(0);
        
        for (int rowNum = 1; rowNum <= 14815; rowNum++) {
            Row row = sheet.getRow(rowNum);
            if (row != null) {
                log.info("rowNum: " + rowNum);
                BLS bls = new BLS();   
                Method[] methods = bls.getClass().getDeclaredMethods();
                        
                Cell cell = row.getCell(0);
                bls.setSBLS((cell != null) ? cell.getStringCellValue() : "");
                
                cell = row.getCell(1);
                bls.setST((cell != null) ? cell.getStringCellValue() : "");
                
                cell = row.getCell(2);
                bls.setSTE((cell != null) ? cell.getStringCellValue() : "");
                
                for (Method method : methods) {
                    if (method.getName().startsWith("set")) {
                        for(Dateiaufbau datei : dateiliste){
                            if(method.getName().substring(3).equals(datei.getKurz()) && !method.getName().substring(3).equals("SBLS") && !method.getName().substring(3).equals("ST") && !method.getName().substring(3).equals("STE")){
                                //log.info("feld: " + datei.getFeld() + " " + datei.getKurz());
                                method.invoke(bls, (double) row.getCell(datei.getFeld() - 1).getNumericCellValue());
                            }
                        }                      
                    }
                }                                      
                dataObjects.add(bls);
            }
        }
        workbook.close();
        return dataObjects;
    }
    
}
