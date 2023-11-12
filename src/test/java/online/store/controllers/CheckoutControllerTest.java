package online.store.controllers;

import online.store.model.Product;
import online.store.model.wrappers.CheckoutRequest;
import online.store.model.wrappers.ProductInfo;
import online.store.services.CreditCardValidationService;
import online.store.services.OrdersService;
import online.store.services.ProductsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class CheckoutControllerTest {

    @Mock
    private OrdersService ordersService;

    @Mock
    private ProductsService productsService;

    @Mock
    private CreditCardValidationService validationService;

    @InjectMocks
    private CheckoutController checkoutController;

    private CheckoutRequest checkoutRequest;

    @BeforeEach
    void setUp() {
        checkoutRequest = new CheckoutRequest();
    }

    @Test
    void testCreditCardInformationIsMissing() {
        ResponseEntity<String> creditCardInformationIsMissing = new ResponseEntity<>("Credit card information is missing",
                HttpStatus.PAYMENT_REQUIRED);

        Assertions.assertEquals(creditCardInformationIsMissing, checkoutController.completeCheckout(checkoutRequest));
    }

    @Test
    void testFirstNameIsMissing() {
        checkoutRequest.setCreditCard("card");

        ResponseEntity<String> firstNameIsMissing = new ResponseEntity<>("First name is missing", HttpStatus.BAD_REQUEST);
        Assertions.assertEquals(firstNameIsMissing, checkoutController.completeCheckout(checkoutRequest));
    }

    @Test
    void testLastNameIsMissing() {
        checkoutRequest.setCreditCard("card");
        checkoutRequest.setFirstName("card");

        ResponseEntity<String> lastNameIsMissing =  new ResponseEntity<>("Last name is missing", HttpStatus.BAD_REQUEST);
        Assertions.assertEquals(lastNameIsMissing, checkoutController.completeCheckout(checkoutRequest));
    }

    @Test
    void testCompleteCheckout() {
        checkoutRequest.setCreditCard("1111114511111111");
        checkoutRequest.setFirstName("card");
        checkoutRequest.setLastName("card");
        checkoutRequest.setProducts(List.of(new ProductInfo(1L, 10L)));

        Product product = new Product();
        Mockito.when(productsService.getProductById(Mockito.anyLong())).thenReturn(product);

        ResponseEntity<String> response =  new ResponseEntity<>("success", HttpStatus.OK);
        Assertions.assertEquals(response, checkoutController.completeCheckout(checkoutRequest));
    }
}