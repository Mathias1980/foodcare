package de.ml.foodcare.exceptions;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author mathi
 */

@Getter
@Setter
public class ErrorDetails {
    
    private Date timestamp;
    private String message;
    private String details;

    public ErrorDetails(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
    
}
