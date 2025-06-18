package com.mane.umakant.java8.features.Function.SquareNumberAndConvertToString;

import java.util.function.Function;

public class SquareNumberAndConvertToString {
    public static void main(String[] args) {
        Function<Integer, Integer> square = n -> n * n;
        Function<Integer, String> toString = n -> "Result: " + n;

        Function<Integer, String> squareAndConvert = square.andThen(toString);

        System.out.println(squareAndConvert.apply(5)); // Output: Result: 25

    }
}
