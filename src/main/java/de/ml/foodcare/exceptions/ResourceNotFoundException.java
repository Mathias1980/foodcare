package de.ml.foodcare.exceptions;

/**
 *
 * @author mathi
 */
public class ResourceNotFoundException extends RuntimeException{
    
    public ResourceNotFoundException(String message){
        super(message);
    }
}
