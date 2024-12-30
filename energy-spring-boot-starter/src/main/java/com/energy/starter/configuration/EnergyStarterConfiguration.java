package com.energy.starter.configuration;

import com.energy.base.jackson.JacksonEnum;
import com.energy.starter.exception.GlobalExceptionHandler;
import com.energy.starter.spring.SpringUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.Set;

/**
 * @author zhangwenlin
 * @since 2024-12-17
 */
@Configuration
@Import({GlobalExceptionHandler.class, SpringUtil.class})
public class EnergyStarterConfiguration {

    @Bean
    public ObjectMapper objectMapper() {
        return JacksonEnum.INSTANCE.getObjectMapper();
    }


    public Validator validator() {
        return Validation.buildDefaultValidatorFactory().getValidator();
    }

}

