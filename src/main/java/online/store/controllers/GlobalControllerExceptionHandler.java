package online.store.controllers;

import lombok.extern.slf4j.Slf4j;
import online.store.exceptions.CreditCardValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class GlobalControllerExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<String> defaultErrorHandler(HttpServletRequest request, Exception exception) {
        log.error("Exception in handling request to {}: {}/n",
                request.getRequestURI(), exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<String> creditCardValidationExceptionHandler(CreditCardValidationException exception) {
        log.error("Exception in handling request: {}/n", exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), exception.getStatusCode());
    }

}
