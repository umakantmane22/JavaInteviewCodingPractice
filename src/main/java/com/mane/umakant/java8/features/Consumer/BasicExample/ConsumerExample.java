package com.mane.umakant.java8.features.Consumer.BasicExample;

import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<String> printConsumer = str -> System.out.println("Hello, " + str);
        printConsumer.accept("Java"); // Output: Hello, Java
    }
}
