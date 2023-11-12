package online.store.model.wrappers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class CheckoutRequestTest {

    private CheckoutRequest checkoutRequest;


    @BeforeEach
    void setUp() {
        checkoutRequest = new CheckoutRequest();
    }

    @Test
    void testGetterSetterFirstName() {
        checkoutRequest.setFirstName("fn");
        Assertions.assertEquals("fn", checkoutRequest.getFirstName());
    }

    @Test
    void testGetterSetterLastName() {
        checkoutRequest.setLastName("ln");
        Assertions.assertEquals("ln", checkoutRequest.getLastName());
    }

    @Test
    void testGetterSetterEmail() {
        checkoutRequest.setEmail("email");
        Assertions.assertEquals("email", checkoutRequest.getEmail());
    }

    @Test
    void testGetterSetterShippingAddress() {
        checkoutRequest.setShippingAddress("ShippingAddress");
        Assertions.assertEquals("ShippingAddress", checkoutRequest.getShippingAddress());
    }

    @Test
    void testGetterSetterCreditCard() {
        checkoutRequest.setCreditCard("CreditCard");
        Assertions.assertEquals("CreditCard", checkoutRequest.getCreditCard());
    }

    @Test
    void testGetterSetterProducts() {
        List<ProductInfo> product = List.of(new ProductInfo());
        checkoutRequest.setProducts(product);
        Assertions.assertEquals(product, checkoutRequest.getProducts());
    }

    @Test
    void testAllArgsConstructor() {
        CheckoutRequest checkoutRequest1 = new CheckoutRequest("fn", "ln", "email", "ShippingAddress",
                "CreditCard", List.of(new ProductInfo()));

        Assertions.assertEquals("CreditCard", checkoutRequest1.getCreditCard());
    }
}