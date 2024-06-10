package de.ml.foodcare.exceptions;

/**
 *
 * @author mathi
 */

public class ConflictException extends RuntimeException{
    
    public ConflictException(String message){
        super(message);
    }
}
