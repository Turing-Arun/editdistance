package com.example.editdistance;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EditDistanceApplicationTest {

  // This test is used to check if the Spring application context loads successfully.
  @Test
  void contextLoads() {}

  // This test is used to check if the main class of the Spring application can be executed.
  @Test
  void testMainClass() {
    EditDistanceApplication.main(new String[] {});
    assertTrue(true);
  }
}
