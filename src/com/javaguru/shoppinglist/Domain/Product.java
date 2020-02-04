package com.javaguru.shoppinglist.Domain;

import com.javaguru.shoppinglist.Repository.ProductCategories;

import java.math.BigDecimal;

public class Product {

    private Long id;
    private String name;
    private BigDecimal price;
    private ProductCategories category;
    private String description;
    private BigDecimal discount=BigDecimal.ZERO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public ProductCategories getCategory() {
        return category;
    }

    public BigDecimal getDiscount () {
        return discount;
    }

    public void setDiscount (BigDecimal discount) {
        this.discount=discount;
        BigDecimal discountTemp = this.getPrice().divide(BigDecimal.valueOf(100)).multiply(discount);
        BigDecimal newPrice = this.getPrice().subtract(discountTemp);
        this.setPrice(newPrice);
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCategory(ProductCategories category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void discountPrice(double discount) {
        BigDecimal discountTemp = this.getPrice().divide(BigDecimal.valueOf(100)).multiply(BigDecimal.valueOf(discount));
        BigDecimal discountResult = this.getPrice().subtract(discountTemp);
        this.setPrice(discountResult);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", description='" + description + '\'' +
                '}';
    }
}
