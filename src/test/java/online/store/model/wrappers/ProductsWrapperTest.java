package online.store.model.wrappers;

import online.store.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ProductsWrapperTest {

    @Test
    void testGetterSetterProducts() {
        List<Product> products = List.of(new Product());
        ProductsWrapper productsWrapper1 = new ProductsWrapper(products);
        Assertions.assertEquals(products ,productsWrapper1.getProducts());
    }

    @Test
    void testNoArgsConstructor() {
        ProductsWrapper productsWrapper = new ProductsWrapper();
        Assertions.assertNull(productsWrapper.getProducts());
    }
}