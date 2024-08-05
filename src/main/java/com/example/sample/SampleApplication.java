package com.example.sample;

import com.example.sample.DTO.ContactInfo;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.client.RestTemplate;

@EnableJpaAuditing
@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Products Microservice CRUD Documentation",
                description = "ShopIT Products microservice REST API Documentation",
                version = "v1",
                contact = @Contact(
                        name = "Kanaparthi Phani",
                        email = "kanaparthiphani0@gmail.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.eazybytes.com"
                )
        )
)
@EnableConfigurationProperties(value = {ContactInfo.class})
public class SampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);
    }
}
