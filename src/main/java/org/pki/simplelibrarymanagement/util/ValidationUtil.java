package org.pki.simplelibrarymanagement.util;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.pki.simplelibrarymanagement.exception.InvalidFieldException;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
@RequiredArgsConstructor
public class ValidationUtil {
    private final Validator validator;

    public boolean objectHasViolation(Object target) {
        return validator.validate(target).isEmpty();
    }

    public void throwViolations(Object target) {
        Set<ConstraintViolation<Object>> constraintViolations = getViolations(target);
        if (!objectHasViolation(target)) {
            for (ConstraintViolation<Object> violation : constraintViolations) {
                throw new InvalidFieldException(violation.getMessage());
            }
        }
    }

    private Set<ConstraintViolation<Object>> getViolations(Object object) {
        return validator.validate(object);
    }
}
