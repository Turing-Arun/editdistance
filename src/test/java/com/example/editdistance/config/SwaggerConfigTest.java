package com.example.editdistance.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class SwaggerConfigTest {

  @Test
  public void testSwaggerConfigBean() {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(SwaggerConfig.class);
    SwaggerConfig swaggerConfig = context.getBean(SwaggerConfig.class);
    assertNotNull(swaggerConfig, "SwaggerConfig bean should not be null");
    context.close();
  }
}
