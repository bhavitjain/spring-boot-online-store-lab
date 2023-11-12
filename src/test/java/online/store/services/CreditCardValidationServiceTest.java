package online.store.services;

import online.store.exceptions.CreditCardValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreditCardValidationServiceTest {

    @InjectMocks
    private CreditCardValidationService validationService;

    @Test
    void testCardValidity() {
        Assertions.assertThrows(CreditCardValidationException.class,
                () -> validationService.validate("123456891234567"),
                "123456891234567 is invalid credit card");
    }

    @Test
    void testValidateCardStolen() {
        Assertions.assertThrows(CreditCardValidationException.class,
                () -> validationService.validate("1111111111111111"),
                "1111111111111111 is a stolen credit card");
    }
}