package com.javaguru.shoppinglist.Service.Validation;

import com.javaguru.shoppinglist.Domain.Product;

import java.math.BigDecimal;

public class ProductValidationRuleDiscount implements ProductValidationRule {
    @Override
    public void validate(Product product) {
        if (product.getCategory() == null) {
            throw new IllegalArgumentException("Product category must not be null");
        }
        BigDecimal expectedDiscount = product.getDiscount();
        System.out.println(product.getDiscount());
        BigDecimal discountMaxMargin =BigDecimal.valueOf(100);
        if (expectedDiscount.compareTo(discountMaxMargin) > 0) {
            throw new IllegalArgumentException("Product discount must not be more than 100%");
        }
    }
}
