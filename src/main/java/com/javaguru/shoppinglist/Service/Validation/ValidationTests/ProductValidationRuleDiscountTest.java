package com.javaguru.shoppinglist.Service.Validation.ValidationTests;

import com.javaguru.shoppinglist.Domain.Product;
import com.javaguru.shoppinglist.Service.Validation.ProductValidationRuleDiscount;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductValidationRuleDiscountTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private ProductValidationRuleDiscount victim = new ProductValidationRuleDiscount() {
        @Override
        public void validate(Product product) {

        }
    };

    @Test
    void validateDiscountTestCheckIfNull() {
        Product discountInputTest = new Product();
        discountInputTest.setDiscount(null);
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Product category must not be null");
        victim.validate(discountInputTest);
    }

    @Test
    void validateDiscountTestCheckMarginsHigh() {
        Product discountInputTest = new Product();
        discountInputTest.setDiscount(BigDecimal.valueOf(102));
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Product discount must not be more than 100%");
        victim.validate(discountInputTest);
    }
}