package com.mane.umakant.chatGpt;
import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FrequencyOfElements {
    public static void main(String[] args)        {
        List<String> names = Arrays.asList("Java", null, "Spring", "Hibernate");

        Map<String, Integer> nameLength = names
                .stream()
                .filter(Objects::nonNull)
                .peek(System.out::println)
                .collect(Collectors.toMap(n -> n, String::length));
        System.out.println("nameLength:: "+nameLength);



    }
}
