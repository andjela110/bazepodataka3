/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;

/**
 *
 * @author Korisnik
 */
public class Validator {
    
    private final List<String> validationErros;

    private Validator() {
        validationErros = new ArrayList();
    }

    public static Validator startValidation() {
        return new Validator();
    }

    public Validator validateNotNullOrEmpty(String value, String errorMessage) throws ValidationException {
        if (value == null || value.trim().isEmpty()) {
            this.validationErros.add(errorMessage);
        }
        return this;
    }
    
     public Validator validateValueIsInteger(String value, String errorMessage) throws ValidationException {
        try {
            int i = Integer.parseInt(value);
        } catch (NumberFormatException nfe) {
            this.validationErros.add(errorMessage);
        }
        return this;
    }
    
    public Validator validateValueIsDouble(String value, String errorMessage) throws ValidationException {
        try {
            double d = Double.parseDouble(value);
        } catch (NumberFormatException nfe) {
            this.validationErros.add(errorMessage);
        }
        return this;
    }
    
    public Validator validateDateIsNotNull(Date value, String errorMessage) throws ValidationException { 
            if (value == null) {
            this.validationErros.add(errorMessage);
            }
        return this;
    }
/*
    public Validator validateNotNull(Object value, String errorMessage) throws ValidationException {
        if (value == null) {
            this.validationErros.add(errorMessage);
        }
        return this;
    }

    public Validator validateValueComboBox(String value, String errorMessage) throws ValidationException {
        if (value == null) {
            this.validationErros.add(errorMessage);
        }
        return this;
    }
   
    
    public Validator validateListIsNotEmpty(List list , String errorMessage) throws ValidationException {
            if (list == null || list.isEmpty()) {
                this.validationErros.add(errorMessage);
            }
        return this;
    }*/

    public void throwIfInvalide() throws ValidationException {
        if (!validationErros.isEmpty()) {
            throw new ValidationException(this.validationErros.stream().collect(Collectors.joining("\n")));
        }
    }
}
