package com.example.editdistance.controller;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.editdistance.dto.EditDistanceResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EditDistanceIntegrationTest {

  @Autowired private TestRestTemplate restTemplate;

  @Test
  public void testCalculatEeditDistance() {
    String url = "/editdistance?word1=kitten&word2=sitting";

    // Send a GET request to the endpoint
    ResponseEntity<EditDistanceResult> response =
        restTemplate.getForEntity(url, EditDistanceResult.class);

    // Verify the response status code should be 200 and distance should be 3
    assertThat(response.getStatusCode().value()).isEqualTo(200);
    assertThat(response.getBody().getDistance()).isEqualTo(3);
  }

  @Test
  public void testCalculateEditDistanceEmptyStrings() {
    String url = "/editdistance?word1=\"\"&word2=\"\"";

    // Send a GET request to the endpoint
    ResponseEntity<EditDistanceResult> response =
        restTemplate.getForEntity(url, EditDistanceResult.class);

    // Verify the response status code should be 200 and distance should be 0
    assertThat((response.getStatusCode()).value()).isEqualTo(200);
    assertThat(response.getBody().getDistance()).isEqualTo(0);
  }

  @Test
  public void testCalculateEditDistanceSameStrings() {
    String url = "/editdistance?word1=kitten&word2=kitten";

    // Send a GET request to the endpoint
    ResponseEntity<EditDistanceResult> response =
        restTemplate.getForEntity(url, EditDistanceResult.class);

    // Verify the response status code should be 200 and distance should be 0
    assertThat((response.getStatusCode()).value()).isEqualTo(200);
    assertThat(response.getBody().getDistance()).isEqualTo(0);
  }

  @Test
  public void testCalculateEditDistanceOneEdit() {
    String url = "/editdistance?word1=kitten&word2=Pkitten";

    // Send a GET request to the endpoint
    ResponseEntity<EditDistanceResult> response =
        restTemplate.getForEntity(url, EditDistanceResult.class);

    // Verify the response status code should be 200 and distance should be 1
    assertThat((response.getStatusCode()).value()).isEqualTo(200);
    assertThat(response.getBody().getDistance()).isEqualTo(1);
  }
}
