package com.mane.umakant.java8.features.Predicate.FilterEvenNumbersUsingPredicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateExample1 {
    public static void main(String[] args) {
        List<Integer> numbers= Arrays.asList(10,15,20,25,30);

        Predicate<Integer> isEven=num -> num % 2 == 0;
        List<Integer> evenNumbers=numbers.stream()
                .filter(isEven)
                .collect(Collectors.toList());
        System.out.println("evenNumbers:: "+evenNumbers);
    }
}
