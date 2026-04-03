package com.mane.umakant.chatGpt;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlattenExample {
    public static void main(String[] args) {
        List<List<String>> nestedList= Arrays.asList(
                Arrays.asList("Java", "Spring"),
                Arrays.asList("Hibernate", "JPA"),
                Arrays.asList("Microservices", "Docker")
        );
        System.out.println(nestedList.stream()
                .map(List::stream)
                .collect(Collectors.toList()));
        System.out.println("-------");
        System.out.println(nestedList.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList()));

        List<String> names = Arrays.asList("Java", null, "Spring", "Hibernate");

// ❌ This will throw NullPointerException
        names.stream()
                .filter(Objects::nonNull)
                .map(String::toUpperCase)
                .forEach(System.out::println);

        String name = null;

        String result = Optional.ofNullable(name)
                .map(String::toUpperCase)
                .orElse("DEFAULT");

        System.out.println(result);

        System.out.println("1111111111111111111111");

        // Safely create a stream even if names is null
        Optional.ofNullable(names)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .forEach(System.out::println);
        List<String> result1 = Stream.of("Java", "Spring", "Hibernate", "JPA")
                .filter(s -> s.length() > 4)
                .peek(s -> System.out.println("After filter: " + s))
                .map(String::toUpperCase)
                .peek(s -> System.out.println("After map: " + s))
                .collect(Collectors.toList());

    }
}
