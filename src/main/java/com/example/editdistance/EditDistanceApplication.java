package com.example.editdistance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The EditDistanceApplication class serves as the entry point for the Spring Boot application. It
 * contains the main method which launches the application using SpringApplication.run().
 *
 * <p>This application is designed to calculate the edit distance between two strings.
 *
 * <p>Usage: Run the main method to start the Spring Boot application.
 *
 * <p>Dependencies: - Spring Boot
 */
@SpringBootApplication
public class EditDistanceApplication {

  public static void main(String[] args) {
    SpringApplication.run(EditDistanceApplication.class, args);
  }
}
