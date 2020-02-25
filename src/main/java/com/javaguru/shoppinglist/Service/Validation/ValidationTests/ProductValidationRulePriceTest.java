package com.javaguru.shoppinglist.Service.Validation.ValidationTests;

import com.javaguru.shoppinglist.Domain.Product;
import com.javaguru.shoppinglist.Service.Validation.ProductValidationRulePrice;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductValidationRulePriceTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private ProductValidationRulePrice victim = new ProductValidationRulePrice() {
        @Override
        public void validate(Product product) {

        }
    };

    @Test
    void validatePriceTestCheckIfNull() {
        Product priceInputTest = new Product();
        priceInputTest.setPrice(null);
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Product price must not be null");
        victim.validate(priceInputTest);
    }

    @Test
    void validatePriceTestCheckMarginsLow() {
        Product priceInputTest = new Product();
        priceInputTest.setPrice(BigDecimal.valueOf(-10));
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Error! Price cannot be less than 0.");
        victim.validate(priceInputTest);
    }

}