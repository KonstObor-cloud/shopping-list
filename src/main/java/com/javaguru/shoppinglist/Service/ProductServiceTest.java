package com.javaguru.shoppinglist.Service;

import com.javaguru.shoppinglist.Domain.Product;
import com.javaguru.shoppinglist.Repository.ProductCategories;
import com.javaguru.shoppinglist.Repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.Service.Validation.ProductValidationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.Captor;
import org.mockito.ArgumentCaptor;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    private ProductInMemoryRepository repositoryMock;

    @Mock
    private ProductValidationService validationMockService;

    @InjectMocks
    private ProductService victim;

    @Captor
    private ArgumentCaptor<Product> productMockCaptor;

    private Product productServiceMockProduct() {
        Product productServiceMockProduct = new Product();
        productServiceMockProduct.setName("Testmilk");
        productServiceMockProduct.setPrice(BigDecimal.valueOf(10));
        productServiceMockProduct.setId(10L);
        productServiceMockProduct.setDescription("milk for testing");
        productServiceMockProduct.setCategory(ProductCategories.FOOD);
        productServiceMockProduct.setDiscount(BigDecimal.valueOf(10));
        productServiceMockProduct.setDiscountedPrice(productServiceMockProduct.getPrice());
        return productServiceMockProduct;
    }

    @Test
    public void ShouldCreateProduct() {
        Product productMockCreated = productServiceMockProduct();
        when(repositoryMock.insert(productMockCreated)).thenReturn(productMockCreated);
        Long result = victim.createProduct(productMockCreated);
        verify(validationMockService).validate(productMockCaptor.capture());
        Product captorResult = productMockCaptor.getValue();
        assertEquals(captorResult, productMockCreated);
        assertEquals(productMockCreated.getId(), result);
    }

    @Test
    public void shouldFindProduct() {
        when(repositoryMock.findProductById(10L)).thenReturn(productServiceMockProduct());
        Product result = victim.findProductById(10L);
        assertEquals(productServiceMockProduct(), result);
    }

    @Test
    public void shouldCreateDiscount() {
        Product productMockDiscounted = productServiceMockProduct();
        BigDecimal discountMocked = victim.createDiscount(productMockDiscounted, productMockDiscounted.getDiscount());
        BigDecimal discountActual = productMockDiscounted.getDiscountedPrice();
        assertEquals(discountMocked, discountActual);
    }
}