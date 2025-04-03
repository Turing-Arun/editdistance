package com.example.editdistance.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * GlobalExceptionHandler is a controller advice class that handles exceptions thrown by the
 * application. It provides a centralized exception handling mechanism across all controllers.
 *
 * <p>This class currently handles the following exceptions:
 *
 * <ul>
 *   <li>IllegalArgumentException - returns a BAD_REQUEST status with the exception message
 * </ul>
 *
 * <p>Example usage:
 *
 * <pre>{@code
 * throw new IllegalArgumentException("Invalid argument");
 * }</pre>
 *
 * <p>Spring will automatically call the appropriate handler method when an exception is thrown.
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
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
  }
}
