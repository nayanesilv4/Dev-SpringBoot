package com.luv2code.springdemo.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    // define course code padrão
    public String value() default "LUV";

    // define a mensagem de erro padrão
    public String message() default "must start with LUV";

    // define os grupos
    public Class<?>[] groups() default {};

    // define payloads
    public Class<? extends Payload>[] payload() default {};

}
