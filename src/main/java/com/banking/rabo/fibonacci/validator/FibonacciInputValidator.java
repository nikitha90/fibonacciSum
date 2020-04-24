package com.banking.rabo.fibonacci.validator;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FibonacciInputValidator {

    private static final Logger log = LoggerFactory.getLogger(FibonacciInputValidator.class);

    public static boolean validateInput(int inputValue) throws Exception {
        boolean isValid = true;
        if (inputValue < 0) {
            throw new Exception("Input value is negative");
        }
        return isValid;
    }
}
