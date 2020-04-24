package com.banking.rabo.fibonacci.controller;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciControllerTest {

    @Test
    public void checkFibonacciSumWithCorrectValues() {
        FibonacciController fibonacciController = new FibonacciController();
        int result = fibonacciController.findFibonacci(4);
        assertEquals(7, result);
    }

}
