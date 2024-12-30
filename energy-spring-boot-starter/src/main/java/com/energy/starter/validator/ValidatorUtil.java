package com.energy.starter.validator;

import com.energy.base.exception.EnergyException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;

/**
 * @author zhangwenlin
 * @since 2024-12-30
 */
public class ValidatorUtil {

    private static final Validator validator;


    static {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    public static void validate(Object t) {
        Set<ConstraintViolation<Object>> violations = validator.validate(t);
        violations.stream().findFirst().ifPresent(violation -> {
            throw new EnergyException(violation.getMessage());
        });
    }

}
