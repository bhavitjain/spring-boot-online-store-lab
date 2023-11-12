package online.store.services;

import online.store.model.Product;
import online.store.model.ProductCategory;
import online.store.repositories.ProductCategoryRepository;
import online.store.repositories.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductsServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductCategoryRepository productCategoryRepository;

    @InjectMocks
    private ProductsService productsService;

    @Test
    void testGetAllSupportedCategories() {
        List<ProductCategory> categoryList = List.of(new ProductCategory("category"));
        List<String> output = categoryList.stream().map(ProductCategory::getCategory).collect(Collectors.toList());

        Mockito.when(productCategoryRepository.findAll()).thenReturn(categoryList);

        Assertions.assertEquals(output, productsService.getAllSupportedCategories());
    }

    @Test
    void testGetAtMostNumberOfProducts() {
        Page<Product> page = Page.empty();
        List<Product> productList = page.toList();
        Mockito.when(productRepository.findAll(Mockito.any(Pageable.class))).thenReturn(page);
        Assertions.assertEquals(productList, productsService.getAtMostNumberOfProducts(2));
    }

    @Test
    void testGetByCategory() {
        List<Product> output = List.of(new Product());
        Mockito.when(productRepository.findByCategory(Mockito.anyString())).thenReturn(output);
        Assertions.assertEquals(output, productsService.getByCategory("category"));
    }

    @Test
    void testGetAllProducts() {
        List<Product> output = List.of(new Product());

        Mockito.when(productRepository.findAll()).thenReturn(output);

        Assertions.assertEquals(output, productsService.getAllProducts());
    }

    @Test
    void testGetProductByIdFound() {
        Product output = new Product();
        Mockito.when(productRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(output));
        Assertions.assertEquals(output, productsService.getProductById(1L));
    }

    @Test
    void testGetProductById() {
        Mockito.when(productRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
        Assertions.assertThrows(IllegalStateException.class, () -> productsService.getProductById(1L));
    }
}