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
    String url = "/edit-distance?word1=kitten&word2=sitting";

    ResponseEntity<EditDistanceResult> response =
        restTemplate.getForEntity(url, EditDistanceResult.class);
    assertThat(response.getStatusCode().value()).isEqualTo(200);
    assertThat(response.getBody().getDistance()).isEqualTo(3);
  }

  @Test
  public void testCalculatEeditDistanceEmptyStrings() {
    String url = "/edit-distance?word1=\"\"&word2=\"\"";
    ResponseEntity<EditDistanceResult> response =
        restTemplate.getForEntity(url, EditDistanceResult.class);
    assertThat((response.getStatusCode()).value()).isEqualTo(200);
    assertThat(response.getBody().getDistance()).isEqualTo(0);
  }

  @Test
  public void testCalculateEditDistanceSameStrings() {
    String url = "/edit-distance?word1=kitten&word2=kitten";
    ResponseEntity<EditDistanceResult> response =
        restTemplate.getForEntity(url, EditDistanceResult.class);
    assertThat((response.getStatusCode()).value()).isEqualTo(200);
    assertThat(response.getBody().getDistance()).isEqualTo(0);
  }

  @Test
  public void testCalculateEditDistanceOneEdit() {
    String url = "/edit-distance?word1=kitten&word2=Pkitten";
    ResponseEntity<EditDistanceResult> response =
        restTemplate.getForEntity(url, EditDistanceResult.class);
    assertThat((response.getStatusCode()).value()).isEqualTo(200);
    assertThat(response.getBody().getDistance()).isEqualTo(1);
  }
}
