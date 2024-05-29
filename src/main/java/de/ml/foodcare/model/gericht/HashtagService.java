package de.ml.foodcare.model.gericht;

import de.ml.foodcare.data.HashtagRepository;
import java.util.List;
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
    
    public Hashtag findById(long id){
        return this.hrep.findById(id).get();
    }
    
    public List<Hashtag> findAll(){
        return hrep.findAll();
    }
    
    public List<Hashtag> findByUsername(String username){
        return hrep.findByUsername(username);
    }

}
