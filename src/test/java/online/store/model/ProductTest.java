package online.store.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductTest {

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product();
    }

    @Test
    void testGetterSetterId() {
        product.setId(1L);
        Assertions.assertEquals(1L, product.getId());
    }

    @Test
    void testGetterSetterName() {
        product.setName("Name");
        Assertions.assertEquals("Name", product.getName());
    }

    @Test
    void testGetterSetterDescription() {
        product.setDescription("Description");
        Assertions.assertEquals("Description", product.getDescription());
    }

    @Test
    void testGetterSetterImageFileName() {
        product.setImageFileName("ImageFileName");
        Assertions.assertEquals("ImageFileName", product.getImageFileName());
    }

    @Test
    void testGetterSetterPriceUSD() {
        product.setPriceUSD(1);
        Assertions.assertEquals(1, product.getPriceUSD());
    }

    @Test
    void testGetterSetterCategory() {
        product.setCategory("category");
        Assertions.assertEquals("category", product.getCategory());
    }

    @Test
    void testAllArgsConstructor() {
        Product product1 = new Product("Name", "Description", "ImageFileName", 1, "category");
        Assertions.assertEquals("category", product1.getCategory());
    }
}