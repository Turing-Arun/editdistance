package com.example.editdistance.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * GlobalExceptionHandler is a controller advice class that handles exceptions
 * thrown by the application globally.
 * 
 * It currently handles the following exceptions:
 * 
 * - IllegalArgumentException: Returns a response entity with the exception message
 *   and a BAD_REQUEST (400) HTTP status.
 * 
 * This class is annotated with @ControllerAdviceBean to indicate that it provides
 * global exception handling.
 */
public class GlobalExceptionHandler {

    /**
     * Handles IllegalArgumentException exceptions.
     *
     * @param ex the IllegalArgumentException thrown by the application
     * @return a ResponseEntity containing the exception message and a BAD_REQUEST status
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());  
        //return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
