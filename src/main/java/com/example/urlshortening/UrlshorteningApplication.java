package com.example.urlshortening;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "urlshortening", version = "v1", description = "Documentation of urlshortening"))
public class UrlshorteningApplication {

    public static void main(String[] args) {
        SpringApplication.run(UrlshorteningApplication.class, args);
    }

}
