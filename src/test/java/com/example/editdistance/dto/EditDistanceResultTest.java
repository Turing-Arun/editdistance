package com.example.editdistance.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

public class EditDistanceResultTest {

  @Test
  public void testNoArgsConstructor() {
    EditDistanceResult result = new EditDistanceResult();
    assertEquals(0, result.getDistance());
  }

  @Test
  public void testAllArgsConstructor() {
    EditDistanceResult result = new EditDistanceResult(5);
    assertEquals(5, result.getDistance());
  }

  @Test
  public void testSetDistance() {
    EditDistanceResult result = new EditDistanceResult();
    result.setDistance(10);
    assertEquals(10, result.getDistance());
  }

  @Test
  public void testGetDistance() {
    EditDistanceResult result = new EditDistanceResult(7);
    assertEquals(7, result.getDistance());
  }

  @Test
  public void equalsVerifierTest() {
    EqualsVerifier.simple().forClass(EditDistanceResult.class).verify();
  }

  @Test
  public void testToString() {
    EditDistanceResult result = new EditDistanceResult(3);
    String expected = "EditDistanceResult(distance=3)";
    assertEquals(expected, result.toString());
  }
}
