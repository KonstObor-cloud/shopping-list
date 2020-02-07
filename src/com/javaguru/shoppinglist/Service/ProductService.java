package com.javaguru.shoppinglist.Service;

import com.javaguru.shoppinglist.Domain.Product;
import com.javaguru.shoppinglist.Repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.Service.Validation.ProductValidationService;

import java.math.BigDecimal;

public class ProductService {
    private ProductInMemoryRepository ProductServiceRepository = new ProductInMemoryRepository();
    private ProductValidationService validationService = new ProductValidationService();

    public Long createProduct(Product product) {
        validationService.validate(product);
        Product newProduct = ProductServiceRepository.insert(product);
        return newProduct.getId();
    }

    public void createDiscount(Product discountedProduct, BigDecimal discount) {
        discountedProduct.setDiscount(discount);
        validationService.validate(discountedProduct);
        BigDecimal discountTemp = discountedProduct.getPrice().divide(BigDecimal.valueOf(100)).multiply(discount);
        BigDecimal discountResult = discountedProduct.getPrice().subtract(discountTemp);
        discountedProduct.setDiscountedPrice(discountResult);
    }

}
