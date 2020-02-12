package com.javaguru.shoppinglist.Service.Validation;

import com.javaguru.shoppinglist.Domain.Product;

public class ProductValidationRuleDescription implements ProductValidationRule {
    @Override
    public void validate(Product product) {
        if (product.getDescription() == null) {
            throw new IllegalArgumentException("Product description must not be null");
        }
    }
}
