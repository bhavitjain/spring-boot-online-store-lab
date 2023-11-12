package online.store.controllers;

import online.store.model.Product;
import online.store.services.ProductsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class HomepageControllerTest {

    @Mock
    private ProductsService productsService;

    @InjectMocks
    private HomepageController homepageController;

    @Test
    void testGetAllCategories() {
        Mockito.when(productsService.getAllSupportedCategories()).thenReturn(List.of("e1"));
        Assertions.assertEquals("e1", homepageController.getAllCategories());
    }

    @Test
    void testGetDealsOfTheDay() {
        List<Product> products = new ArrayList<>();
        Mockito.when(productsService.getAtMostNumberOfProducts(Mockito.anyInt())).thenReturn(products);
        Assertions.assertEquals(products, homepageController.getDealsOfTheDay(1).getProducts());
    }

    @Test
    void testGetALLProducts() {
        List<Product> products = new ArrayList<>();
        Mockito.when(productsService.getAllProducts()).thenReturn(products);
        Assertions.assertEquals(products, homepageController.getProductsByCategory(null).getProducts());
    }

    @Test
    void testGetProductsByCategory() {
        List<Product> products = new ArrayList<>();
        Mockito.when(productsService.getByCategory(Mockito.anyString())).thenReturn(products);
        Assertions.assertEquals(products, homepageController.getProductsByCategory("e1").getProducts());
    }
}