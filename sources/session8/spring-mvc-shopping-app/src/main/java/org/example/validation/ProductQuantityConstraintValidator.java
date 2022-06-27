package org.example.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProductQuantityConstraintValidator implements ConstraintValidator<ProductQuantityConstraint, Integer> {

    private int lowest;
    private int highest;

    @Override
    public void initialize(ProductQuantityConstraint constraintAnnotation) {

        lowest = constraintAnnotation.lowest();
        highest = constraintAnnotation.highest();

    }

    @Override
    public boolean isValid(Integer quantity, ConstraintValidatorContext constraintValidatorContext) {

        if (quantity == null)
            return false;

        if (quantity < lowest || quantity > highest)
            return false;

        if (quantity % 2 != 0)
            return false;

        return true;
    }
}
