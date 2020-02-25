package com.javaguru.shoppinglist.Service.Validation.ValidationTests;

import com.javaguru.shoppinglist.Domain.Product;
import com.javaguru.shoppinglist.Service.Validation.ProductValidationRule;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.*;

class ProductValidationRuleTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private ProductValidationRule victim = new ProductValidationRule() {
        @Override
        public void validate(Product product) {

        }

        @Override
        public void checkIfNull(Product product) {
        }
    };

    private Product inputTest;

    @Test
    public void checkIfNullTest() {
        inputTest = null;

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Product must not be null");
        victim.validate(inputTest);
    }


}