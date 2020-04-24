package com.banking.rabo.fibonacci.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * This class is the implementation of the default method in interface
 */
@Service
public class FibonacciServiceImpl implements FibonacciService {

    private static final Logger log = LoggerFactory.getLogger(FibonacciServiceImpl.class);

    /**
     * This method calls the default method calculate fibonacci implemented in the interface
     *
     * @param inputValue
     * @return result
     */
    public int getFibonacciValue(int inputValue) {
        FibonacciServiceImpl fibonacciService = new FibonacciServiceImpl();
        return fibonacciService.calculateFibonacci(inputValue);
    }

    //This part of the code is for introducing the delay. The method should be static which cannot be done as it
    // cannot be done for default method.
    /*private void pauseExecutionForRandomSeconds(){
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(FibonacciService::calculateFibonacci, 1, TimeUnit.SECONDS);
    }*/
}
