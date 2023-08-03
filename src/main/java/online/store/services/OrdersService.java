package online.store.services;

import online.store.model.Order;
import online.store.repositories.OrderRepository;
import online.store.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    public void placeOrder(Iterable<Order> order){
       orderRepository.saveAll(order);
    }
}
