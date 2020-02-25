package com.javaguru.shoppinglist.Console;

import com.javaguru.shoppinglist.Repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.Service.ProductService;
import com.javaguru.shoppinglist.Service.Validation.*;

import java.util.HashSet;
import java.util.Set;

public class ProductApplication {
    public static void main(String[] args) {
        ProductInMemoryRepository repository = new ProductInMemoryRepository();
        ProductValidationRule ProductValidationRuleName = new ProductValidationRuleName();
        ProductValidationRule ProductValidationRulePrice = new ProductValidationRulePrice();
        ProductValidationRule ProductValidationRuleDescription = new ProductValidationRuleDescription();
        ProductValidationRule ProductValidationRuleCategory = new ProductValidationRuleCategory();
        ProductValidationRule ProductValidationRuleDiscount = new ProductValidationRuleDiscount();
        Set<ProductValidationRule> rules = new HashSet<>();
        rules.add(ProductValidationRuleName);
        rules.add(ProductValidationRulePrice);
        rules.add(ProductValidationRuleDescription);
        rules.add(ProductValidationRuleCategory);
        rules.add(ProductValidationRuleDiscount);

        ProductValidationService validationService = new ProductValidationService(rules);

        ProductService taskService = new ProductService(repository, validationService);

        ProductUIConsole consoleUI = new ProductUIConsole(taskService);
        consoleUI.execute();
    }

}
