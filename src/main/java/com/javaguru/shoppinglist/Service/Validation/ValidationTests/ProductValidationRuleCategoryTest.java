package com.javaguru.shoppinglist.Service.Validation.ValidationTests;

import com.javaguru.shoppinglist.Domain.Product;
import com.javaguru.shoppinglist.Service.Validation.ProductValidationRuleCategory;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.*;

class ProductValidationRuleCategoryTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private ProductValidationRuleCategory victim = new ProductValidationRuleCategory() {
        @Override
        public void validate(Product product) {

        }
    };

    @Test
    void validateCategoryTestCheckIfNull() {
        Product nameCategoryTest = new Product();
        nameCategoryTest.setCategory(null);
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Product category must not be null");
        victim.validate(nameCategoryTest);
    }

}