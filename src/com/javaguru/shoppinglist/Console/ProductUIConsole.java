package com.javaguru.shoppinglist.Console;

import com.javaguru.shoppinglist.Domain.Product;
import com.javaguru.shoppinglist.Repository.ProductCategories;
import com.javaguru.shoppinglist.Service.ProductService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductUIConsole {
    public static void main(String[] args) {
        Map<Long, Product> productRepository = new HashMap<>();
        Long productIdSequence = 0L;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Set discount");
                System.out.println("4. Exit");
                String userInput = scanner.nextLine();
                switch (userInput) {
                    case "1":
                        System.out.println("Enter product name: ");
                        String name = scanner.nextLine();
                        System.out.println("Enter product price: ");
                        BigDecimal price = new BigDecimal(scanner.nextLine());
                        System.out.println("Enter product description");
                        String description = scanner.nextLine();
                        System.out.println("Enter product category: FOOD, DRINK, APPLIANCES, FURNISHINGS");
                        ProductCategories category = ProductCategories.valueOf(scanner.nextLine());
                        Product product = new Product();
                        product.setName(name);
                        product.setPrice(price);
                        product.setId(productIdSequence);
                        product.setDescription(description);
                        product.setCategory(category);
                        product.setDiscount(BigDecimal.valueOf(0));
                        product.setDiscountedPrice(product.getPrice());
                        productRepository.put(productIdSequence, product);
                        productIdSequence++;
                        System.out.println("Result: " + product.getId());
                        break;
                    case "2":
                        System.out.println("Enter product id: ");
                        long id = scanner.nextLong();
                        Product findProductResult = productRepository.get(id);
                        System.out.println(findProductResult);
                        break;
                    case "3":
                        System.out.println("Enter product id: ");
                        long idDiscount = scanner.nextLong();
                        System.out.println("Enter product discount (whole or fractional): ");
                        BigDecimal discount = scanner.nextBigDecimal();
                        Product findProductDiscountResult = productRepository.get(idDiscount);
                        ProductService ProductServiceDiscount = new ProductService();
                        ProductServiceDiscount.createDiscount(findProductDiscountResult, discount);
                        System.out.println("Price with discount is : " + findProductDiscountResult.getDiscountedPrice());
                        break;
                    case "4":
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
            }
        }
    }
}
