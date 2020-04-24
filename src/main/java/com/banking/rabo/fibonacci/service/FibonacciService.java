package com.banking.rabo.fibonacci.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.concurrent.TimeUnit.SECONDS;


/**
 * This class is used to find the fibonacci values and its sum
 */
public class FibonacciService {

    private static final Logger log = LoggerFactory.getLogger(FibonacciService.class);

    /**
     * This method is used to find the fibonacci series for the given list
     *
     * @param inputValue
     * @return integer list
     */
    public static List<Integer> fibonacci(int inputValue) {
        List<Integer> fibonacciSeries = new ArrayList<>();
        try {
            ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
            Callable<List<Integer>> task = () -> Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                    .limit(inputValue)
                    .map(n -> n[1])
                    .collect(Collectors.toList());
            log.info("Introducing a delay of 1 second");
            ScheduledFuture<List<Integer>> future = executorService.schedule(task, 1, SECONDS);
            fibonacciSeries = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return fibonacciSeries;
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
