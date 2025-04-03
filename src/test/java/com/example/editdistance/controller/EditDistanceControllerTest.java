package com.example.editdistance.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.editdistance.service.EditDistanceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

// Test class for EditDistanceController
@WebMvcTest(EditDistanceController.class)
public class EditDistanceControllerTest {

  /** Logger for logging messages. */
  @Autowired private MockMvc mockMvc;

  /** Service for calculating the edit distance between two strings. */
  @MockitoBean private EditDistanceService editDistanceService;

  /**
   * Constructs an instance of EditDistanceControllerTest with the specified MockMvc and
   * EditDistanceService.
   */
  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testGetEditDistance() throws Exception {
    String word1 = "kitten";
    String word2 = "sitting";
    int expectedDistance = 3;

    // Mocking the service call
    when(editDistanceService.findEditDistance(word1, word2)).thenReturn(expectedDistance);

    // Perform the GET request and verify the response
    mockMvc
        .perform(get("/editdistance").param("word1", word1).param("word2", word2))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.distance").value(expectedDistance));
  }

  @Test
  public void testGetEditDistanceWithEmptyStrings() throws Exception {
    String word1 = "";
    String word2 = "";
    int expectedDistance = 0;

    // Mocking the service call to return the expected distance
    when(editDistanceService.findEditDistance(word1, word2)).thenReturn(expectedDistance);

    // Perform the GET request and verify the response
    mockMvc
        .perform(get("/editdistance").param("word1", word1).param("word2", word2))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.distance").value(expectedDistance));
  }

  @Test
  public void testGetEditDistanceWithOneEmptyString() throws Exception {
    String word1 = "hello";
    String word2 = "";
    int expectedDistance = 5;

    //  Mocking the service call to return the expected distance
    when(editDistanceService.findEditDistance(word1, word2)).thenReturn(expectedDistance);

    // Perform the GET request and verify the response
    mockMvc
        .perform(get("/editdistance").param("word1", word1).param("word2", word2))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.distance").value(expectedDistance));
  }

  @Test
  public void testGetEditDistanceWithMissingParameter() throws Exception {
    String word1 = "hello";

    // Perform the GET request without the second word parameter
    mockMvc.perform(get("/editdistance").param("word1", word1)).andExpect(status().isBadRequest());
  }
}
