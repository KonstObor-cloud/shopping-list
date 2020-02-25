package com.javaguru.shoppinglist.Domain;

import com.javaguru.shoppinglist.Repository.ProductCategories;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Objects;
@Component
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(price, product.price) &&
                Objects.equals(discountedPrice, product.discountedPrice) &&
                category == product.category &&
                Objects.equals(description, product.description) &&
                Objects.equals(discount, product.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, discountedPrice, category, description, discount);
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
