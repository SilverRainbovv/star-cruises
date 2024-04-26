package com.didenko.starcruises.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ChangePasswordValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PasswordChangeDtoValidator {

    String message() default "Passwords don't match";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
