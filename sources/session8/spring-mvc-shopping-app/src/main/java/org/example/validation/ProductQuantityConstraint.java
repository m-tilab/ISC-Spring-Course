package org.example.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.example.validation.ProductQuantityConstraintValidator;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ProductQuantityConstraintValidator.class)
public @interface ProductQuantityConstraint {

    String message() default "Quantity should be between 2 and 1000 numbers and should be even";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int lowest() default 2;

    int highest() default 1000;

}
