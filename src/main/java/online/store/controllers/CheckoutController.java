package online.store.controllers;

import online.store.model.Order;
import online.store.model.wrappers.CheckoutRequest;
import online.store.model.wrappers.ProductInfo;
import online.store.services.OrdersService;
import online.store.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
public class CheckoutController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private ProductsService productsService;

    private static boolean isNullOrBlank(String input) {
        return input == null || input.isEmpty() || input.trim().isEmpty();
    }

    @PostMapping("/checkout")
    public ResponseEntity<String> completeCheckout(@RequestBody CheckoutRequest checkoutRequest){
        if(isNullOrBlank(checkoutRequest.getCreditCard()))
            return new ResponseEntity<>("Credit card information is missing",
                    HttpStatus.PAYMENT_REQUIRED);

        if(isNullOrBlank(checkoutRequest.getFirstName()))
            return new ResponseEntity<>("First name is missing", HttpStatus.BAD_REQUEST);

        if(isNullOrBlank(checkoutRequest.getLastName()))
            return new ResponseEntity<>("Last name is missing", HttpStatus.BAD_REQUEST);

        Set<Order> orders = new HashSet<>();

        for(ProductInfo info : checkoutRequest.getProducts()){
            Order order = new Order(checkoutRequest.getFirstName(),
                    checkoutRequest.getLastName(), checkoutRequest.getEmail(), checkoutRequest.getShippingAddress(),
                    info.getQuantity(), productsService.getProductById(info.getProductId()),
                    checkoutRequest.getCreditCard());

            orders.add(order);
        }
        ordersService.placeOrder(orders);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

}
