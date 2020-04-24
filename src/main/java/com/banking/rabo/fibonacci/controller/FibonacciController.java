package com.banking.rabo.fibonacci.controller;

import com.banking.rabo.fibonacci.service.FibonacciServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.banking.rabo.fibonacci.validator.FibonacciInputValidator.validateInput;

/**
 * This is the entry class for the fibonacci sum system
 */
@RestController
public class FibonacciController {

    private static final Logger log = LoggerFactory.getLogger(FibonacciController.class);

    private final FibonacciServiceImpl fibonacciServiceImpl;

    @Autowired
    FibonacciController(FibonacciServiceImpl fibonacciServiceImpl) {
        this.fibonacciServiceImpl = fibonacciServiceImpl;
    }

    /**
     * This method is accepts the input values and finds the sum of the fibonacci
     *
     * @param inputValue
     * @return result
     */
    @GetMapping(value = "/fibonacci/calculate")
    public long findFibonacci(@RequestParam int inputValue) {
        log.info("The number entered to calculate sum of fibonacci is {}", inputValue);
        long result = 0;
        try {
            if (validateInput(inputValue)) {
                result = (long) fibonacciServiceImpl.getFibonacciValue(inputValue);
                log.info("The sum of the fibonacci series is {}", result);
                if (result > Integer.MAX_VALUE) {
                    throw new ArithmeticException();
                }
            } else {
                log.error("An error occured while processing the request");
            }

        } catch (ArithmeticException ex) {
            log.error("Calculated Value is greater than the Maximum value of Integer {}", result);
        } catch (Exception ex) {
            log.error("Exception occured while processing the request");
        }
        return result;
    }
}
