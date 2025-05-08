package org.pki.simplelibrarymanagement.config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPI {
    @Bean
    Contact contact() {
        Contact contact = new Contact();
        contact.setUrl("https://github.com/SepehrIsHere");
        contact.setEmail("sepehrjedaridv@gmail.com");
        return contact;
    }

    @Bean
    Info info() {
        return new Info()
                .title("Simple Library Management API")
                .version("1.0")
                .contact(contact())
                .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                .description("Simple Library Management API using Spring");
    }
}
