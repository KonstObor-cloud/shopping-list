package com.javaguru.shoppinglist.Service.Validation;

import com.javaguru.shoppinglist.Domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductValidationRuleName implements ProductValidationRule {
    @Override
    public void validate(Product product) {
        checkIfNull(product);
        if (product.getName() == null) {
            throw new IllegalArgumentException("Product name must not be null");
        }
        if (product.getName().length() < 3 || product.getName().length() > 25) {
            throw new IllegalArgumentException("Error! Name must contain 3 to 25 characters.");
        }
    }
}
