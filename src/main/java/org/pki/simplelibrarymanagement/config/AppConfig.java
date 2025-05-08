package org.pki.simplelibrarymanagement.config;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {
    @Bean
    ValidatorFactory validatorFactory() {
        return Validation.buildDefaultValidatorFactory();
    }

    @Bean
    Validator validator(ValidatorFactory factory) {
        return factory.getValidator();
    }

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
