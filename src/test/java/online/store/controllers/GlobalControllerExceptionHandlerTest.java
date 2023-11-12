package online.store.controllers;

import online.store.exceptions.CreditCardValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

@ExtendWith(MockitoExtension.class)
class GlobalControllerExceptionHandlerTest {

    @InjectMocks
    private GlobalControllerExceptionHandler globalControllerExceptionHandler;

    @Mock
    private HttpServletRequest request;

    @Test
    void testDefaultErrorHandler() {
        ResponseEntity<String> errorOccurred = new ResponseEntity<>("Error Occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        Assertions.assertEquals(errorOccurred,
                globalControllerExceptionHandler.defaultErrorHandler(request, new IllegalStateException("Error Occurred")));
    }

    @Test
    void testCreditCardValidationExceptionHandler() {
        ResponseEntity<String> errorOccurred = new ResponseEntity<>("Error Occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        Assertions.assertEquals(errorOccurred, globalControllerExceptionHandler.creditCardValidationExceptionHandler(
                new CreditCardValidationException("Error Occurred", HttpStatus.INTERNAL_SERVER_ERROR)));
    }
}