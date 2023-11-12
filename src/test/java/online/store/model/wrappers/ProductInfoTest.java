package online.store.model.wrappers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductInfoTest {

    private ProductInfo productInfo;

    @BeforeEach
    void setUp() {
        productInfo = new ProductInfo(1L, 10L);
    }

    @Test
    void testGetterSetterProductId() {
        productInfo.setProductId(1L);
        Assertions.assertEquals(1L, productInfo.getProductId());
    }

    @Test
    void testGetterSetterQuantity() {
        productInfo.setQuantity(1L);
        Assertions.assertEquals(1L, productInfo.getQuantity());
    }

    @Test
    void testNoArgsConstructor() {
        ProductInfo productInfo1 = new ProductInfo();
        productInfo1.setQuantity(1L);
        Assertions.assertEquals(1L, productInfo1.getQuantity());
    }
}