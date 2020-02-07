package com.javaguru.shoppinglist.Repository;

import com.javaguru.shoppinglist.Domain.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductInMemoryRepository {
    Map<Long, Product> productRepository = new HashMap<>();
    Long productIdSequence = 0L;

    public Product insert(Product product) {
        product.setId(productIdSequence);
        productRepository.put(productIdSequence, product);
        productIdSequence++;
        return product;
    }

    public Product findProductById(Long Id) {
        return productRepository.get(Id);
    }


}