package com.javaguru.shoppinglist.Domain;

import com.javaguru.shoppinglist.Repository.ProductCategories;

import java.math.BigDecimal;

public class Product {

    private Long id;
    private String name;
    private BigDecimal price;
    private BigDecimal discountedPrice;
    private ProductCategories category;
    private String description;
    private BigDecimal discount = BigDecimal.valueOf(0);

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

    public BigDecimal getDiscount() {
        return discount;
    }

    public BigDecimal getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
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

    public void setDiscountedPrice(BigDecimal discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", discountedPrice=" + discountedPrice +
                ", category=" + category +
                ", description='" + description + '\'' +
                ", discount=" + discount +
                '}';
    }
}
