package com.javaguru.shoppinglist.Service;

import com.javaguru.shoppinglist.Domain.Product;
import com.javaguru.shoppinglist.Repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.Service.Validation.ProductValidationService;

public class ProductService {
    private ProductInMemoryRepository ProductServiceRepository = new ProductInMemoryRepository();
    private ProductValidationService validationService = new ProductValidationService();

    public long createProduct(Product product) {
        validationService.validate(product);
        Product newProduct = ProductServiceRepository.insert(product);
        return newProduct.getId();
    }
}
