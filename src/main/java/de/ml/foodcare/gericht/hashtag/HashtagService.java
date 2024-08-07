package de.ml.foodcare.gericht.hashtag;

import de.ml.foodcare.gericht.hashtag.Hashtag;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author mathi
 */
@Service
public class HashtagService {
    
    private HashtagRepository hrep;
    
    public HashtagService(HashtagRepository hrep){
        this.hrep = hrep;
    }
    
    public Optional<Hashtag> findById(long id){
        return this.hrep.findById(id);
    }
    
    public List<Hashtag> findAll(){
        return hrep.findAll();
    }
    
    public List<Hashtag> findByUsername(String username){
        return hrep.findByUsername(username);
    }

}
