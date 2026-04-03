package com.mane.umakant.chatGpt.java8;

import java.util.*;
import java.util.stream.Collectors;

public class MapListConversion {
    public static void main(String[] args) {
        // Create a Map
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Alice");
        map.put(2, "Bob");
        map.put(3, "Charlie");

        // ✅ Convert Map to List (of values)
        List<String> listFromMap = map.values()
                .stream()
                .collect(Collectors.toList());

        System.out.println("List from Map values: " + listFromMap);

        // ✅ Convert Map to List (of keys)
        List<Integer> keyList = map.keySet()
                .stream()
                .collect(Collectors.toList());

        System.out.println("List from Map keys: " + keyList);

        // ✅ Convert List to Map (example: name -> length of name)
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        Map<String, Integer> mapFromList = names.stream()
                .collect(Collectors.toMap(name -> name, String::length));

        System.out.println("Map from List: " + mapFromList);
    }
}

