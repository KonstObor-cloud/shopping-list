package com.javaguru.shoppinglist.Service.Validation;

import com.javaguru.shoppinglist.Domain.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
public class ProductValidationRulePrice implements ProductValidationRule {
    @Override
    public void validate(Product product) {
        checkIfNull(product);
        if (product.getPrice() == null) {
            throw new IllegalArgumentException("Product price must not be null");
        }
        if (product.getPrice().compareTo(BigDecimal.valueOf(0)) < 0) {
            System.out.println("Error! Price cannot be less than 0.");
        }
    }
}
