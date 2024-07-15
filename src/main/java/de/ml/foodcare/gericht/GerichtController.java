package de.ml.foodcare.gericht;

import de.ml.foodcare.exceptions.ConflictException;
import de.ml.foodcare.bls.BLSService;
import de.ml.foodcare.gericht.zutat.ZutatDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import java.net.URI;
import java.util.List;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mathi
 */
@RestController
@RequestMapping("/gerichte")
public class GerichtController {
    
    private GerichtService gerichtservice;
    private BLSService blsservice;
    
    private static final Logger log = LoggerFactory.getLogger(GerichtController.class);
    
    public GerichtController(GerichtService gerichtservice, BLSService blsservice){
        this.gerichtservice = gerichtservice;
        this.blsservice = blsservice;
    }
    
    @GetMapping("/")                          
    public Stream<GerichtDto> getGerichte() throws IllegalArgumentException, IllegalAccessException {
        return gerichtservice.listeToDto(gerichtservice.getGerichte(), false).stream();
    }
    
    @GetMapping("/{id}")                    
    public ResponseEntity<GerichtDto> getGericht(
        @PathVariable int id
    ) throws IllegalArgumentException, IllegalAccessException {
        return ResponseEntity.ok( gerichtservice.toDto( gerichtservice.getGericht(id), false ));
    }
    
    @GetMapping("/ns")                          
    public Stream<GerichtDto> getGerichteNs() throws IllegalArgumentException, IllegalAccessException {
        return gerichtservice.listeToDto(gerichtservice.getGerichte(), true).stream();
    }
    
    @GetMapping("/ns/{id}")                    
    public ResponseEntity<GerichtDto> getGerichtNs(
        @PathVariable int id
    ) throws IllegalArgumentException, IllegalAccessException {
        return ResponseEntity.ok( gerichtservice.toDto( gerichtservice.getGericht(id), true ));
    }
     
    @PostMapping                           
    public ResponseEntity<?> postGericht(
        @Valid @RequestBody GerichtDto gdto
    ) throws IllegalAccessException {
        if(gerichtservice.existsGerichtByTitelKategorie(gdto.getTitel(), gdto.getKategorie())){
            throw new ConflictException("Titel + Kategorie bereits vorhanden.");
        }else{
            long id = gerichtservice.create(gdto);
            return ResponseEntity
                .created(URI.create("/gerichte/" + id))
                .body(gerichtservice.toDto(gerichtservice.getGericht(id), false));
        }
    }
    
    @PutMapping("/{id}")                    
    public ResponseEntity<?> putGericht(
        @Positive @PathVariable int id,
        @Valid @RequestBody GerichtDto gDto  
    ) throws IllegalAccessException {
        if (id != gDto.getId()) {
            throw new ConflictException("ID passt nicht zu Gericht.");
        }
        Gericht gericht = gerichtservice.getGericht(id);

        StringBuilder sb = new StringBuilder();
        String SEPARATOR = "";
        for(ZutatDto dto: gDto.getZutaten()){
            if(!blsservice.existsBLSBySBLS(dto.getSbls())){ 
                sb.append(SEPARATOR);
                sb.append(dto.getSbls());
                SEPARATOR = ", ";
                gDto.getZutaten().remove(dto);
            }
        }
        GerichtDto res = gerichtservice.toDto(gerichtservice.update(gericht, gDto), false);
        res.setMessage(sb.toString());
        return ResponseEntity.ok(res);
    }
    
    @DeleteMapping("/{id}")          
    public ResponseEntity<?> deleteGericht(
        @PathVariable int id
    ) {
        gerichtservice.removeGericht(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/kategorie/{username}")                    
    public ResponseEntity<List<String>> getKategorienByUsername(
        @PathVariable String username
    ){
        return ResponseEntity.ok(gerichtservice.findDistinctKategorieByUsername(username));
    }
    
}
