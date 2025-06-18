package com.mane.umakant.java8.features.Function.Composefunctions;

import java.util.function.Function;

public class FirstConvertToDoubleThenSquare {
    public static void main(String[] args) {
        Function<String, Integer> parse = s -> Integer.parseInt(s);
        Function<Integer, Integer> square = x -> x * x;

        Function<String, Integer> parseAndSquare = parse.andThen(square);

        System.out.println(parseAndSquare.apply("6")); // Output: 36

    }
}
