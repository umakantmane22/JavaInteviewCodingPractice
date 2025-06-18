package com.mane.umakant.java8.features.Predicate.CombinePredicatesAndOrNegate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateExample2 {
    public static void main(String[] args) {
        Predicate<Integer> isEven=num->num%2==0;
        Predicate<Integer> isGreaterThan20=num->num>20;

        List<Integer> numbers= Arrays.asList(10,15,20,25,30,35);

        // Even AND >20
       // System.out.println("Even and >20:");
        List<Integer> evenAndGreaterThan20 = numbers.stream()
                .filter(isEven.and(isGreaterThan20))
                .collect(Collectors.toList()); // 30
        System.out.println("evenAndGreaterThan20:: "+evenAndGreaterThan20);
        System.out.println("--- using forEach evenAndGreaterThan20:: --------");
        numbers.stream()
                .filter(isEven.and(isGreaterThan20))
                .forEach(System.out::println); // 15, 25, 35

        // NOT even using negate()

        System.out.println("NOT even using negate()");
        numbers.stream()
                .filter(isEven.negate())
                .forEach(System.out::println);


    }
}
