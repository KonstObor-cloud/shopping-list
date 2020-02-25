package com.javaguru.shoppinglist.Console;

import com.javaguru.shoppinglist.Domain.Product;
import com.javaguru.shoppinglist.Repository.ProductCategories;
import com.javaguru.shoppinglist.Repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
@Controller
public class ProductUIConsole {

    private final ProductService productService;
    @Autowired
    public ProductUIConsole(ProductService productService) {
        this.productService = productService;
    }

    public void execute () {
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
                        createProduct();
                        break;
                    case "2":
                        findProduct();
                        break;
                    case "3":
                       discountThisProduct();
                        break;
                    case "4":
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
                e.printStackTrace();
            }
        }
    }
    private void createProduct () {
        Scanner scanner = new Scanner(System.in);
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
        product.setDescription(description);
        product.setCategory(category);
        product.setDiscount(BigDecimal.valueOf(0));
        product.setDiscountedPrice(product.getPrice());
        productService.createProduct(product);
        System.out.println("Result: " + product.getId());
    }
    private void findProduct () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id: ");
        Long id = scanner.nextLong();
        Product product = productService.findProductById(id);
        System.out.println(product);
    }
    private void discountThisProduct () {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Enter product id: ");
        long idDiscount = scanner.nextLong();
        System.out.println("Enter product discount (whole or fractional): ");
        BigDecimal discount = scanner.nextBigDecimal();
        Product findProductDiscountResult = productService.findProductById(idDiscount);
        productService.createDiscount(findProductDiscountResult, discount);
        System.out.println("Price with discount is : " + findProductDiscountResult.getDiscountedPrice());
    }
}
