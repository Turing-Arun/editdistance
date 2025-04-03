package com.example.editdistance.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

  /** Logger for the EditDistanceService class. */
  private static final Logger logger = LoggerFactory.getLogger(EditDistanceService.class);

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
    logger.info("Calculating edit distance between '{}' and '{}'", word1, word2);

    int m = word1.length();
    int n = word2.length();
    int[][] dp = new int[m + 1][n + 1];

    // word1 and word2 are the same, distance is 0
    if (word1.equals(word2)) {
      logger.info("Words are identical. Edit distance is 0.");
      return 0;
    }

    // if any of the words is empty, distance is the length of the other word
    if (word1.length() == 0) {
      logger.info(
          "First word is empty. Edit distance is the length of the second word: {}",
          word2.length());
      return word2.length();
    }

    if (word2.length() == 0) {
      logger.info(
          "Second word is empty. Edit distance is the length of the first word: {}",
          word1.length());
      return word1.length();
    }

    // memoization for results happens inside two-dimensional dp array
    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0) {
          dp[i][j] = j;
        } else if (j == 0) {
          dp[i][j] = i;
        } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          // if the characters are the same, no operation is needed
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          // if the characters are different, consider all possibilities
          dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
        }
      }
    }

    int result = dp[m][n];
    logger.info("Edit distance between '{}' and '{}' is {}", word1, word2, result);
    return result;
  }
}
