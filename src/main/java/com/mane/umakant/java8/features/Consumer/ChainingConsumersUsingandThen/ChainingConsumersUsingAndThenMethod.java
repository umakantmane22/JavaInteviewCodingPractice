package com.mane.umakant.java8.features.Consumer.ChainingConsumersUsingandThen;

import java.util.function.Consumer;

public class ChainingConsumersUsingAndThenMethod {
    public static void main(String[] args) {
        Consumer<String> c1 = s -> System.out.println("Upper: " + s.toUpperCase());
        Consumer<String> c2 = s -> System.out.println("Lower: " + s.toLowerCase());

        Consumer<String> combined = c1.andThen(c2);
        combined.accept("Java8");

// Output:
// Upper: JAVA8
// Lower: java8
    }
}
