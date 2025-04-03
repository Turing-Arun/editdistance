package com.example.editdistance.controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
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
@ControllerAdvice
public class GlobalExceptionHandler {

  /**
   * Logger instance for logging messages and exceptions in the GlobalExceptionHandler class.
   * Utilizes SLF4J for consistent and efficient logging.
   */
  private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  /**
   * Handles IllegalArgumentException exceptions.
   *
   * @param ex the IllegalArgumentException thrown by the application
   * @return a ResponseEntity containing the exception message and a BAD_REQUEST status
   */
  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<Map<String, String>> handleIllegalArgumentException(
      IllegalArgumentException ex) {
    Map<String, String> response = new HashMap<>();

    logger.error("Illegal argument exception: {}", ex.getMessage());

    // Provide a generic error response with exception message
    response.put("error", ex.getMessage());
    response.put("message", "Invalid argument");

    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }

  /**
   * Handles MissingServletRequestParameterException exceptions.
   *
   * @param ex the MissingServletRequestParameterException thrown by the application
   * @return a ResponseEntity containing error details and a BAD_REQUEST status
   */
  @ExceptionHandler(org.springframework.web.bind.MissingServletRequestParameterException.class)
  public ResponseEntity<Map<String, String>> handleMissingServletRequestParameterException(
      org.springframework.web.bind.MissingServletRequestParameterException ex) {
    Map<String, String> response = new HashMap<>();

    logger.error("Missing request parameter exception: {}", ex.getMessage());

    // Provide a generic error response with missing parameter details
    response.put("error", "Missing Request Parameter");
    response.put("message", String.format("Parameter '%s' is missing", ex.getParameterName()));

    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }

  /**
   * Handles all uncaught exceptions.
   *
   * <p><strong>Note:</strong> This is a generic fallback and should be used carefully. For
   * production systems, specific exception types should be handled individually.
   *
   * @param ex The exception thrown anywhere in the application.
   * @return A generic error message map with HTTP 500 Internal Server Error status.
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<Map<String, String>> handleGenericException(Exception ex) {
    Map<String, String> response = new HashMap<>();

    // Provide a generic error response with exception message
    response.put("error", ex.getMessage());
    response.put("message", "An unexpected error occurred");
    logger.error("Generic Exception: {}", ex.getMessage(), ex);

    // Return with 500 Internal Server Error
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
