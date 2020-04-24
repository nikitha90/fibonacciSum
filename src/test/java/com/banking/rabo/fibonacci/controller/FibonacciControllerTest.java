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

    @Test
    public void checkFibonacciWithNegativeInteger() {
        try {
            FibonacciController fibonacciController = new FibonacciController();
            fibonacciController.findFibonacci(-8);
        } catch (Exception ex) {
            assertEquals(ex.getMessage(), "Input value is negative");
        }
    }

    @Test
    public void checkResultWhichisNegative() {
        try {
            FibonacciController fibonacciController = new FibonacciController();
            int result = fibonacciController.findFibonacci(45);
        } catch (Exception ex) {
            assertEquals(ex.getMessage(), "Exceeded the integer value range");
        }
    }
}
