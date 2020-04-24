package com.banking.rabo.fibonacci.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.banking.rabo.fibonacci.service.FibonacciService.*;
import static com.banking.rabo.fibonacci.validator.FibonacciInputValidator.validateInput;

/**
 * This is the entry class for the fibonacci sum system
 */
@RestController
public class FibonacciController {

    private static final Logger log = LoggerFactory.getLogger(FibonacciController.class);

    /**
     * This method is accepts the input values and finds the sum of the fibonacci
     *
     * @param inputValue
     * @return result
     */
    @GetMapping(value = "/fibonacci/calculate")
    public int findFibonacci(@RequestParam int inputValue) {
        log.info("The number entered to calculate sum of fibonacci is {}", inputValue);
        int result = 0;
        try {
            if (validateInput(inputValue)) {
                List<Integer> fibonacciValues = fibonacci(inputValue);
                log.info("The fibonacci series is {}", fibonacciValues);
                result = findSumOfFibonacci(fibonacciValues);
                log.info("The sum of fibonacci series is {}", result);
                if (result > Integer.MAX_VALUE) {
                    throw new Exception();
                }
            } else {
                log.error("An error occured while processing the request");
            }

        } catch (Exception ex) {
            log.error("Exception occured while processing the request");
        }
        return result;
    }
}
