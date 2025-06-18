package com.mane.umakant.java8.features.Function.SimpleFunction;

import java.util.function.Function;

public class FunctionExample1 {
    public static void main(String[] args) {
        Function<String,Integer> stringLengthFunction=s->s.length();
        System.out.println(stringLengthFunction.apply("Java")); // Output: 4
    }
}
