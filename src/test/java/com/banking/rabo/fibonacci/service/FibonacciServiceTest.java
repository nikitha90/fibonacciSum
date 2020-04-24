package com.banking.rabo.fibonacci.service;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.banking.rabo.fibonacci.service.FibonacciService.*;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

public class FibonacciServiceTest {

    @Test
    public void findFibonacciSeriesForInput(){
        List<Integer> fibonacciValues = fibonacci(4);
        assertThat(fibonacciValues, hasSize(4));
        assertThat(fibonacciValues, contains(1,1,2,3));
    }

    @Test
    public void findSumOfFibonacciSerries(){
        List<Integer> fibonacciValues = new ArrayList<>();
        fibonacciValues.add(1);
        fibonacciValues.add(1);
        fibonacciValues.add(2);
        fibonacciValues.add(3);
        int result = findSumOfFibonacci(fibonacciValues);
        assertEquals(7, result);

    }
}
