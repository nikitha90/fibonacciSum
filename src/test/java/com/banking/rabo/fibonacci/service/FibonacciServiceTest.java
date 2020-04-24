package com.banking.rabo.fibonacci.service;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.banking.rabo.fibonacci.service.FibonacciService.fibonacci;
import static com.banking.rabo.fibonacci.service.FibonacciService.findSumOfFibonacci;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class FibonacciServiceTest {

    @Test
    public void findFibonacciSeriesForInput(){
        List<Integer> fibonacciValues = fibonacci(4);
        assertThat(fibonacciValues, hasSize(4));
        assertThat(fibonacciValues, contains(1,1,2,3));
    }

    @Test
    public void findSumOfFibonacciSerries() throws Exception {
        List<Integer> fibonacciValues = new ArrayList<>();
        fibonacciValues.add(1);
        fibonacciValues.add(1);
        fibonacciValues.add(2);
        fibonacciValues.add(3);
        int result = findSumOfFibonacci(fibonacciValues);
        assertEquals(7, result);

    }
}
