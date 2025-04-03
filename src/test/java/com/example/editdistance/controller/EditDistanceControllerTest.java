package com.example.editdistance.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.example.editdistance.dto.EditDistanceResult;
import com.example.editdistance.service.EditDistanceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

public class EditDistanceControllerTest {

  @Mock private EditDistanceService editDistanceService;

  @InjectMocks private EditDistanceController editDistanceController;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testGetEditDistance() {
    String word1 = "kitten";
    String word2 = "sitting";
    int expectedDistance = 3;
    EditDistanceResult expectedResult = new EditDistanceResult(expectedDistance);

    when(editDistanceService.findEditDistance(word1, word2)).thenReturn(expectedDistance);

    ResponseEntity<?> response = editDistanceController.getEditDistance(word1, word2);

    assertEquals(ResponseEntity.ok(expectedResult), response);
  }

  @Test
  public void testGetEditDistanceWithEmptyStrings() {
    String word1 = "";
    String word2 = "";
    int expectedDistance = 0;
    EditDistanceResult expectedResult = new EditDistanceResult(expectedDistance);

    when(editDistanceService.findEditDistance(word1, word2)).thenReturn(expectedDistance);

    ResponseEntity<?> response = editDistanceController.getEditDistance(word1, word2);

    assertEquals(ResponseEntity.ok(expectedResult), response);
  }

  @Test
  public void testGetEditDistanceWithOneEmptyString() {
    String word1 = "hello";
    String word2 = "";
    int expectedDistance = 5;
    EditDistanceResult expectedResult = new EditDistanceResult(expectedDistance);

    when(editDistanceService.findEditDistance(word1, word2)).thenReturn(expectedDistance);

    ResponseEntity<?> response = editDistanceController.getEditDistance(word1, word2);

    assertEquals(ResponseEntity.ok(expectedResult), response);
  }

  @Test
  public void testGetEditDistanceWithMissingParameter() {
    String word1 = "hello";
    String word2 = null;

    when(editDistanceService.findEditDistance(word1, word2))
        .thenThrow(new IllegalArgumentException("Missing parameter"));

    assertThrows(
        IllegalArgumentException.class, () -> editDistanceController.getEditDistance(word1, word2));
  }
}
