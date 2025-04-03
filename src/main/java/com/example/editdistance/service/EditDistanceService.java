package com.example.editdistance.service;

import org.springframework.stereotype.Service;

/**
 * Service class for calculating the minimum edit distance between two words. The edit distance is
 * the minimum number of operations (insertions, deletions, or substitutions) required to transform
 * one word into the other.
 *
 * <p>This class uses dynamic programming to compute the edit distance efficiently.
 *
 * <p>Example usage:
 *
 * <pre>{@code
 * EditDistanceService service = new EditDistanceService();
 * int distance = service.findEditDistance("kitten", "sitting");
 * System.out.println("Edit Distance: " + distance); // Output: Edit Distance: 3
 * }</pre>
 *
 * @see <a href="https://en.wikipedia.org/wiki/Edit_distance">Edit Distance (Wikipedia)</a>
 */
@Service
public class EditDistanceService {

  /**
   * Calculates the minimum edit distance between two words using dynamic programming. The edit
   * distance is the minimum number of operations (insertions, deletions, or substitutions) required
   * to transform one word into the other.
   *
   * @param word1 the first word
   * @param word2 the second word
   * @return the minimum edit distance between word1 and word2
   */
  public int findEditDistance(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();
    int[][] dp = new int[m + 1][n + 1];

    // word1 and word 2 are same then distance is 0
    if (word1.equals(word2)) {
      return 0;
    }

    // if any of the word is empty then distance is length of other word
    if (word1.length() == 0) {
      return word2.length();
    }

    if (word2.length() == 0) {
      return word1.length();
    }

    // memoization for results happen inside two dimensional dp array
    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0) {
          dp[i][j] = j;
        } else if (j == 0) {
          dp[i][j] = i;
        } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
        }
      }
    }
    return dp[m][n];
  }
}
