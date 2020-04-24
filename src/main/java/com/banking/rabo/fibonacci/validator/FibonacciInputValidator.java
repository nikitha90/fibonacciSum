package com.banking.rabo.fibonacci.validator;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FibonacciInputValidator {

    private static final Logger log = LoggerFactory.getLogger(FibonacciInputValidator.class);

    public static boolean validateInput(int inputValue) {
        boolean isValid = true;
        try {
            if (inputValue < 0) {
                isValid = false;
                log.error("Input value is negative");
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            log.error("Number format Exception - Given number {} is negative", inputValue);
        }
        return isValid;
    }
}
