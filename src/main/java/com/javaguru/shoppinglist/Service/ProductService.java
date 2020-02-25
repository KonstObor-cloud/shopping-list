package com.javaguru.shoppinglist.Service;

import com.javaguru.shoppinglist.Domain.Product;
import com.javaguru.shoppinglist.Repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.Service.Validation.ProductValidationService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class ProductService {
    private ProductInMemoryRepository productServiceRepository;
    private ProductValidationService validationService;

    public ProductService (ProductInMemoryRepository productServiceRepository, ProductValidationService validationService) {
        this.productServiceRepository = productServiceRepository;
        this.validationService = validationService;
    }

    public Long createProduct(Product product) {
        validationService.validate(product);
        Product newProduct = productServiceRepository.insert(product);
        return newProduct.getId();
    }

    public Product findProductById(Long Id) {
        return productServiceRepository.findProductById(Id);
    }

    public BigDecimal createDiscount(Product discountedProduct, BigDecimal discount) {
        discountedProduct.setDiscount(discount);
        validationService.validate(discountedProduct);
        BigDecimal discountTemp = discountedProduct.getPrice().divide(BigDecimal.valueOf(100)).multiply(discount);
        BigDecimal discountResult = discountedProduct.getPrice().subtract(discountTemp);
        discountedProduct.setDiscountedPrice(discountResult);
        return discountResult;
    }
}
