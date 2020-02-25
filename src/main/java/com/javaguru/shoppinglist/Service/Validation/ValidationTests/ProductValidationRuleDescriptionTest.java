package com.javaguru.shoppinglist.Service.Validation.ValidationTests;

import com.javaguru.shoppinglist.Domain.Product;
import com.javaguru.shoppinglist.Service.Validation.ProductValidationRuleDescription;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.*;

class ProductValidationRuleDescriptionTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private ProductValidationRuleDescription victim = new ProductValidationRuleDescription() {
        @Override
        public void validate(Product product) {

        }
    };

    @Test
    void validateDescriptionTestCheckIfNull() {
        Product nameDescriptionTest = new Product();
        nameDescriptionTest.setDescription(null);
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Product description must not be null");
        victim.validate(nameDescriptionTest);
    }
}