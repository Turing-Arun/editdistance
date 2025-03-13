package com.example.editdistance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents the result of an edit distance calculation.
 * Contains the calculated edit distance between two strings.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EditDistanceResult {
  /**
   * The edit distance between two strings.
   */
  private int distance;
}
