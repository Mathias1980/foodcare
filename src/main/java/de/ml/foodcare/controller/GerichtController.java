package de.ml.foodcare.controller;

import de.ml.foodcare.service.BLSService;
import de.ml.foodcare.model.gericht.Gericht;
import de.ml.foodcare.model.dto.GerichtDto;
import de.ml.foodcare.service.GerichtService;
import de.ml.foodcare.model.dto.ZutatDto;
import java.net.URI;
import java.util.Optional;
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
        @RequestBody GerichtDto gdto
    ) {
        log.info(gdto.toString());
        if(gerichtservice.existsGerichtByTitelKategorie(gdto.getTitel(), gdto.getKategorie())){
            return new ResponseEntity<>("bereits vorhanden ", HttpStatus.CONFLICT);
        }else if(gdto.getTitel().isBlank() || gdto.getKategorie().isBlank() || gdto.getUsername().isBlank()){
            return new ResponseEntity<>("unvollständig ", HttpStatus.BAD_REQUEST);
        }else if(gdto.getZutaten().isEmpty()){
            return new ResponseEntity<>("fehlende Zutaten ", HttpStatus.BAD_REQUEST);
        }else{
            long id = gerichtservice.create(gdto);
            return ResponseEntity
                .created(URI.create("/gerichte/" + id))
                .body(gerichtservice.gerichtToDto(gerichtservice.getGericht(id).get()));
        }
    }
    
    @PutMapping("/{id}")                    
    public ResponseEntity<?> putGericht(
        @PathVariable int id,
        @RequestBody GerichtDto gDto  
    ) {
        log.info(gDto.toString());
        if (id != gDto.getId()) {
            return new ResponseEntity<>("Gericht does't match id ", HttpStatus.CONFLICT);
        }
        Optional<Gericht> oGericht = gerichtservice.getGericht(id);
        if (oGericht.isEmpty()) {
            return new ResponseEntity<>("Gericht nicht vorhanden ", HttpStatus.NOT_FOUND);
        }
        if(gDto.getTitel().isBlank() || gDto.getKategorie().isBlank() || gDto.getAnleitung().isBlank() || gDto.getUsername().isBlank()){
            return new ResponseEntity<>("unvollständig ", HttpStatus.BAD_REQUEST);
        }
        if(gDto.getZutaten().isEmpty()){
            return new ResponseEntity<>("fehlende Zutaten ", HttpStatus.BAD_REQUEST);
        }
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
        GerichtDto res = gerichtservice.gerichtToDto(gerichtservice.updateGericht(oGericht.get(), gDto));
        res.setMessage(sb.toString());
        return ResponseEntity.ok(res);
    }
    
    @DeleteMapping("/{id}")          
    public ResponseEntity<?> deleteGericht(
        @PathVariable int id
    ) {
        Optional<Gericht> og = gerichtservice.getGericht(id);
        if (og.isEmpty()) {
            return new ResponseEntity<>("Gericht does't exist", HttpStatus.NOT_FOUND);
        }
        gerichtservice.removeGericht(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
