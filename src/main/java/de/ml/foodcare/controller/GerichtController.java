package de.ml.foodcare.controller;

import de.ml.foodcare.exceptions.ConflictException;
import de.ml.foodcare.exceptions.ResourceNotFoundException;
import de.ml.foodcare.service.BLSService;
import de.ml.foodcare.model.gericht.Gericht;
import de.ml.foodcare.model.dto.GerichtDto;
import de.ml.foodcare.service.GerichtService;
import de.ml.foodcare.model.dto.ZutatDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import java.net.URI;
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
    
    @GetMapping                          
    public Stream<Gericht> getGerichte() {
        return gerichtservice.getGerichte().stream();
    }
    
    @GetMapping("/dto")                          
    public Stream<GerichtDto> getGerichteDto() {
        return gerichtservice.getGerichteDto().stream();
    }
    
    @GetMapping("/{id}")                    
    public ResponseEntity<Gericht> getGericht(
        @PathVariable int id
    ) {
        return ResponseEntity.of(gerichtservice.getGericht(id));
    }
    
    @PostMapping                           
    public ResponseEntity<?> postGericht(
        @Valid @RequestBody GerichtDto gdto
    ) {
        if(gerichtservice.existsGerichtByTitelKategorie(gdto.getTitel(), gdto.getKategorie())){
            throw new ConflictException("Titel + Kategorie bereits vorhanden.");
        }else{
            long id = gerichtservice.create(gdto);
            return ResponseEntity
                .created(URI.create("/gerichte/" + id))
                .body(gerichtservice.gerichtToDto(gerichtservice.getGericht(id).get()));
        }
    }
    
    @PutMapping("/{id}")                    
    public ResponseEntity<?> putGericht(
        @Positive @PathVariable int id,
        @Valid @RequestBody GerichtDto gDto  
    ) {
        if (id != gDto.getId()) {
            throw new ConflictException("ID passt nicht zu Gericht.");
        }
        Gericht gericht = gerichtservice.getGericht(id).orElseThrow(() -> new ResourceNotFoundException("Gericht nicht vorhanden"));

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
        GerichtDto res = gerichtservice.gerichtToDto(gerichtservice.update(gericht, gDto));
        res.setMessage(sb.toString());
        return ResponseEntity.ok(res);
    }
    
    @DeleteMapping("/{id}")          
    public ResponseEntity<?> deleteGericht(
        @PathVariable int id
    ) {
        gerichtservice.getGericht(id).orElseThrow(() -> new ResourceNotFoundException("Gericht nicht vorhanden"));
        gerichtservice.removeGericht(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
