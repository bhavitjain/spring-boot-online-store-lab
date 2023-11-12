package online.store.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderTest {

    private Order order;

    @BeforeEach
    void setUp() {
        order = new Order();
    }

    @Test
    void testGetId() {
        order.setId(1L);
        Assertions.assertEquals(1L, order.getId());
    }

    @Test
    void testGetQuantity() {
        order.setQuantity(1L);
        Assertions.assertEquals(1L, order.getQuantity());
    }

    @Test
    void testGetterSetterFirstName() {
        order.setFirstName("fn");
        Assertions.assertEquals("fn", order.getFirstName());
    }

    @Test
    void testGetterSetterLastName() {
        order.setLastName("ln");
        Assertions.assertEquals("ln", order.getLastName());
    }

    @Test
    void testGetterSetterEmail() {
        order.setEmail("email");
        Assertions.assertEquals("email", order.getEmail());
    }

    @Test
    void testGetterSetterShippingAddress() {
        order.setShippingAddress("ShippingAddress");
        Assertions.assertEquals("ShippingAddress", order.getShippingAddress());
    }

    @Test
    void testGetterSetterCreditCard() {
        order.setCreditCard("CreditCard");
        Assertions.assertEquals("CreditCard", order.getCreditCard());
    }

    @Test
    void testGetterSetterProducts() {
        Product product = new Product();
        order.setProduct(product);
        Assertions.assertEquals(product, order.getProduct());
    }

    @Test
    void testAllArgsConstructor() {
        Order order1 = new Order("fn", "ln", "email", "ShippingAddress", 1L, new Product(),
                "CreditCard");

        Assertions.assertEquals("CreditCard", order1.getCreditCard());
    }
}