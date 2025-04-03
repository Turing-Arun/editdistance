package com.example.editdistance.controller;

import com.example.editdistance.dto.EditDistanceResult;
import com.example.editdistance.service.EditDistanceService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for handling edit distance related requests. Provides an endpoint to calculate
 * the edit distance between two words.
 */
@RestController
@RequestMapping("/editdistance")
public class EditDistanceController {

  /** Logger for logging messages. */
  private static final Logger logger = LoggerFactory.getLogger(EditDistanceController.class);

  /** Service for calculating the edit distance between two strings. */
  private final EditDistanceService editDistanceService;

  /**
   * Constructs an instance of EditDistanceController with the specified EditDistanceService.
   *
   * @param editDistanceService the service used to calculate edit distance
   */
  public EditDistanceController(EditDistanceService editDistanceService) {
    this.editDistanceService = editDistanceService;
  }

  /**
   * Endpoint to calculate the edit distance between two words.
   *
   * @param word1 the first word to compare
   * @param word2 the second word to compare
   * @return a ResponseEntity containing the edit distance between the two words
   */
  @GetMapping
  public ResponseEntity<?> getEditDistance(
      @Valid @RequestParam String word1, @Valid @RequestParam String word2) {
    logger.info("Received request to calculate edit distance between '{}' and '{}'", word1, word2);
    int distance = editDistanceService.findEditDistance(word1, word2);
    logger.info("Calculated edit distance: {}", distance);
    return ResponseEntity.ok(new EditDistanceResult(distance));
  }
}
