package com.javaguru.shoppinglist.Service.Validation;

import com.javaguru.shoppinglist.Domain.Product;
import org.springframework.stereotype.Component;

@Component
public interface ProductValidationRule {
    void validate(Product product);

    default void checkIfNull(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product must not be null");
        }
    }
}
