package com.example.editdistance.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GlobalExceptionHandlerTest {

  // Mock the GlobalExceptionHandler class
  @InjectMocks private GlobalExceptionHandler globalExceptionHandler;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testHandleIllegalArgumentException() {
    IllegalArgumentException exception = new IllegalArgumentException("Invalid argument");

    // Simulate an illegal argument exception
    ResponseEntity<Map<String, String>> response =
        globalExceptionHandler.handleIllegalArgumentException(exception);

    // Verify the response status is bad request and the message is as expected
    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    assertEquals(response.getBody().get("message"), "Invalid argument");
  }

  @Test
  public void missingServletRequestParameterException() {
    org.springframework.web.bind.MissingServletRequestParameterException exception =
        new org.springframework.web.bind.MissingServletRequestParameterException("param", "String");

    // Simulate a missing request parameter exception
    ResponseEntity<Map<String, String>> response =
        globalExceptionHandler.handleMissingServletRequestParameterException(exception);

    // Verify the response status is bad request and the message is as expected
    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    assertEquals(response.getBody().get("message"), "Parameter 'param' is missing");
  }

  @Test
  public void testHandleGenericException() {
    Exception exception = new Exception("Generic exception");

    // Simulate a generic exception
    ResponseEntity<Map<String, String>> response =
        globalExceptionHandler.handleGenericException(exception);

    // Verify the response status is internal server error and the message is as expected
    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    assertEquals(response.getBody().get("message"), "An unexpected error occurred");
  }
}
