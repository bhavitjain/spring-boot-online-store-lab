package online.store.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductCategoryTest {

    private ProductCategory productCategory;

    @BeforeEach
    void setUp() {
        productCategory = new ProductCategory();
    }

    @Test
    void testGetterSetterId() {
        productCategory.setId(1L);
        Assertions.assertEquals(1L, productCategory.getId());
    }

    @Test
    void testGetterSetterCategory() {
        productCategory.setCategory("category");
        Assertions.assertEquals("category", productCategory.getCategory());
    }

    @Test
    void testAllArgsConstructor() {
        ProductCategory productCategory1 = new ProductCategory("category");
        Assertions.assertEquals("category", productCategory1.getCategory());
    }
}