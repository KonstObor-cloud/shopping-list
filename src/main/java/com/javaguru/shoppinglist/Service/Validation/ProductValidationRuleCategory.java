package com.javaguru.shoppinglist.Service.Validation;

import com.javaguru.shoppinglist.Domain.Product;

public class ProductValidationRuleCategory implements ProductValidationRule {
    @Override
    public void validate(Product product) {
        if (product.getCategory() == null) {
            throw new IllegalArgumentException("Product category must not be null");
        }
    }
}
