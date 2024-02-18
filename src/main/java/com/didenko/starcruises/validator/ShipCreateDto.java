package com.didenko.starcruises.validator;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = ShipCreateEditDtoValidator.class)
public @interface ShipCreateDto {

    String message() default "First seat number must be greater than last seat number";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
