package online.store.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author Michael Pogrebinsky - www.topdeveloperacademy.com
 * Credit Card Validation exception, thrown when an invalid or stolen credit card is used during purchase
 */
@Getter
public class CreditCardValidationException extends RuntimeException {
    private final String message;
    private final HttpStatus statusCode;
    public CreditCardValidationException(String message, HttpStatus statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }
}
