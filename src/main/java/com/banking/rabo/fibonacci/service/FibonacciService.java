package com.banking.rabo.fibonacci.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * This class is the implementation of the default method in interface
 */
@Service
public class FibonacciServiceImpl {


    /**
     * This method is used to find the fibonacci series for the given list
     *
     * @param inputValue
     * @return integer list
     */
    public static List<Integer> fibonacci(int inputValue) {
        return Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(inputValue)
                .map(n -> n[1])
                .collect(Collectors.toList());
    }

    /**
     * This method is used to find the sum of the fibonacci series
     *
     * @param inputValues
     * @return
     */
    public static int findSumOfFibonacci(List<Integer> inputValues) {
        return inputValues.stream().mapToInt(Integer::intValue).sum();
    }
}
