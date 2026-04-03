package com.mane.umakant.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SequentialParallelStreams {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.stream()
                .forEach(num -> System.out.println(Thread.currentThread().getName() + ":: " + num));
        System.out.println("-------------------------");

        numbers.parallelStream()
                .forEach(n -> System.out.println(Thread.currentThread().getName() + ":: " + n));

        System.out.println("-------------");

        List<Integer> bigList = IntStream.rangeClosed(1, 50000000).boxed().collect(Collectors.toList());

// Sequential
        long start1 = System.currentTimeMillis();
        bigList.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sequential took: " + (System.currentTimeMillis() - start1) + " ms");

// Parallel
        long start2 = System.currentTimeMillis();
        bigList.parallelStream().mapToInt(Integer::intValue).sum();
        System.out.println("Parallel took: " + (System.currentTimeMillis() - start2) + " ms");

    }
}
