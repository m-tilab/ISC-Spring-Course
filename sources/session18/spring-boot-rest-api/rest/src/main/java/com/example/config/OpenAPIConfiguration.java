package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Content;

@Configuration
public class OpenAPIConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {

        Contact contact = new Contact();
        contact.setName("SpringBoot Academy OpenAPI");
        contact.setEmail("info@test.com");
        contact.setUrl("https://wwww.test.com");

        return new OpenAPI()
                .info(new Info().title("SpringBoot Academy OpenAPI")
                        .description("RESTFul API services documentation with OpenAPI 3")
                        .contact(contact));
    }

}
