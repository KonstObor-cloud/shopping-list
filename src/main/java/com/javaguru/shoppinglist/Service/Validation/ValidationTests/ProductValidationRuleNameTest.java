package com.javaguru.shoppinglist.Service.Validation.ValidationTests;

import com.javaguru.shoppinglist.Domain.Product;
import com.javaguru.shoppinglist.Service.Validation.ProductValidationRuleName;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.*;

class ProductValidationRuleNameTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private ProductValidationRuleName victim = new ProductValidationRuleName() {
        @Override
        public void validate(Product product) {

        }
    };

    @Test
    void validateNameTestCheckIfNull() {
        Product nameInputTest = new Product();
        nameInputTest.setName(null);
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Product name must not be null");
        victim.validate(nameInputTest);
    }

    @Test
    void validateNameTestCheckMarginsLow() {
        Product nameInputTest = new Product();
        nameInputTest.setName("w");
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Error! Name must contain 3 to 25 characters.");
        victim.validate(nameInputTest);
    }

    @Test
    void validateNameTestCheckMarginsHigh() {
        Product nameInputTest = new Product();
        nameInputTest.setName("reallyhopethisismorethantwentyfivelettersbutnotreallysure");
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Error! Name must contain 3 to 25 characters.");
        victim.validate(nameInputTest);
    }

}