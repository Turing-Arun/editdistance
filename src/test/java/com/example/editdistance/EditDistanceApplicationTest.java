package com.example.editdistance;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EditDistanceApplicationTest {

  @Test
  void contextLoads() {}

  @Test
  void testMainClass() {
    EditDistanceApplication.main(new String[] {});
    assertTrue(true);
    ;
  }
}
