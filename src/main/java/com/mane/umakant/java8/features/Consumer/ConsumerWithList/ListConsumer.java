package com.mane.umakant.java8.features.Consumer.ConsumerWithList;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ListConsumer {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jane", "Jack");

        Consumer<String> printName = name -> System.out.println("Name: " + name);
        names.forEach(printName);
    }
}
