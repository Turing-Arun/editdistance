package com.example.editdistance.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger configuration class for the Edit Distance API.
 *
 * <p>This class is annotated with @Configuration to indicate that it is a source of bean
 * definitions. It is also annotated with @OpenAPIDefinition to provide metadata for the OpenAPI
 * documentation.
 *
 * <p>The API is titled "Edit Distance API", version "1.0", and provides a description "API to
 * calculate edit distance".
 */
@Configuration
@OpenAPIDefinition(
    info =
        @Info(
            title = "Edit Distance API",
            version = "1.0",
            description = "API to calculate edit distance"))
public class SwaggerConfig {}
