
package com.apexcoders.exception;

import javax.ejb.EJBException;


public class InvalidMarksException  extends RuntimeException{

    public InvalidMarksException(String message) {
        super(message);
    }
    
    
}
