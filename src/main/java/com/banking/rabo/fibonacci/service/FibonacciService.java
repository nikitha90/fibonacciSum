package com.banking.rabo.fibonacci.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Interface to calculate fibonacci series
 */
public interface FibonacciService {

    /**
     * Java 8 feature of default method where the implementation of the method
     * can be present inside the interface with keyword default
     *
     * @param inputValue
     * @return sum
     */
    static final Logger log = LoggerFactory.getLogger(FibonacciService.class);

    default int calculateFibonacci(int inputValue) {
        int sum;
        int fibonnaciValue = 0;
        if (inputValue == 0) {
            return 0;
        } else if (inputValue == 1) {
            return 1;
        } else {
            int[] inputArray = new int[inputValue + 1];
            inputArray[0] = 0;
            inputArray[1] = 1;
            sum = inputArray[0] + inputArray[1];
            for (int i = 2; i <= inputValue; i++) {
                inputArray[i] = inputArray[i - 1] + inputArray[i - 2];
                fibonnaciValue = inputArray[i];
                sum += inputArray[i];
            }
            log.info("The fibonacci value for the given input value is {}", fibonnaciValue);
        }
        return sum;
    }
}
