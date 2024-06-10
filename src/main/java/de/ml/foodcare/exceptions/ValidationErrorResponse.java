package de.ml.foodcare.exceptions;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mathi
 */
public class ValidationErrorResponse {
    
    private Map<String, String> errors = new HashMap<>();

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public void addError(String field, String message) {
        this.errors.put(field, message);
    }
}
