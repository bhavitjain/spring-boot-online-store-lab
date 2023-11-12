package online.store.services;

import online.store.model.Order;
import online.store.repositories.OrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class OrdersServiceTest {

    @Mock
    private OrderRepository OrderRepository;

    @InjectMocks
    private OrdersService ordersService;

    private Order order;

    @BeforeEach
    void setUp() {
        order = new Order();
    }

    @Test
    void testPlaceOrderFailure() {
        order.setQuantity(30);
        Assertions.assertThrows(IllegalStateException.class,
                () -> ordersService.placeOrder(List.of(order)));
    }

    @Test
    void testPlaceOrderSuccess() {
        order.setQuantity(0);
        ordersService.placeOrder(List.of(order));
    }
}