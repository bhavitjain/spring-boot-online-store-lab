package online.store.services;

import online.store.model.Order;
import online.store.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {
    @Autowired
    private OrderRepository orderRepository;

    @Value("${products.service.max-number-of-items:25}")
    private long maxNumberOfItems;


    private void validateNumberOfItemsOrdered(Iterable<Order> orders) {
        long totalNumberOfItems = 0;
        for (Order order: orders)  {
            totalNumberOfItems += order.getQuantity();
        }
        if (totalNumberOfItems > maxNumberOfItems) {
            throw new IllegalStateException(String.format("Number of products %d exceeded the limit of %d",
                    totalNumberOfItems, maxNumberOfItems));
        }
    }

    public void placeOrder(Iterable<Order> orders) {
        validateNumberOfItemsOrdered(orders);

        orderRepository.saveAll(orders);
    }
}
