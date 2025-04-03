package com.example.editdistance.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class EditDistanceServiceTest {

  private final EditDistanceService service = new EditDistanceService();

  @Test
  public void testEditDistance() {
    assertEquals(3, service.findEditDistance("kitten", "sitting"));
  }

  @Test
  public void testEditDistanceCaseSensitive() {
    assertEquals(5, service.findEditDistance("HELLO", "hello"));
    assertEquals(1, service.findEditDistance("Java", "java"));
  }

  @Test
  public void testEditDistanceEmptyWords() {
    assertEquals(0, service.findEditDistance("", ""));
    assertEquals(4, service.findEditDistance("", "test"));
    assertEquals(4, service.findEditDistance("test", ""));
  }

  @Test
  public void testEditDistanceSameWord() {
    assertEquals(0, service.findEditDistance("example", "example"));
  }

  @Test
  public void testOneReplace() {
    assertEquals(1, service.findEditDistance("example", "ebample"));
  }

  @Test
  public void testOneInsert() {
    assertEquals(1, service.findEditDistance("examle", "example"));
  }

  @Test
  public void testOneDelete() {
    assertEquals(1, service.findEditDistance("example", "Pexample"));
  }

  @Test
  public void testEditDistanceLargeStrings() {
    String word1 = "a".repeat(1000);
    String word2 = "b".repeat(1000);
    assertEquals(1000, service.findEditDistance(word1, word2));

    word1 = "a".repeat(500) + "b".repeat(500);
    word2 = "a".repeat(1000);
    assertEquals(500, service.findEditDistance(word1, word2));

    word1 = "ab".repeat(500);
    word2 = "ba".repeat(500);
    assertEquals(2, service.findEditDistance(word1, word2));
  }

  @Test
  public void testEditDistanceSpecialCharacters() {
    assertEquals(2, service.findEditDistance("hello!", "he!lo"));
    assertEquals(1, service.findEditDistance("hello@", "hello#"));
  }
}
