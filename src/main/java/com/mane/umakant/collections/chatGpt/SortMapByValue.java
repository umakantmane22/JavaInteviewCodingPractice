package com.mane.umakant.collections.chatGpt;

import java.util.*;
import java.util.stream.Collectors;

public class SortMapByValue {
    public static void main(String[] args) {
        // Recommended Approach
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 50);
        map.put("Banana", 10);
        map.put("Cherry", 30);

        // Sort by value (ascending order)
        LinkedHashMap<String, Integer> sortedMap = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,       // merge function for duplicates
                        LinkedHashMap::new    // preserve insertion order
                ));

        System.out.println("Sorted Map (by value): " + sortedMap);

        //Sort by value (descending  order)

        LinkedHashMap<String, Integer> sortedMapDesc = map.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())

                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,       // merge function for duplicates
                        LinkedHashMap::new    // preserve insertion order
                ));

        System.out.println("Desc Sorted Map (by value): " + sortedMapDesc);

        // Using Pre-Java 8 Approach (Comparator + Collections.sort)

        // Convert entries to a list
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        // Sort the list by value
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return e1.getValue().compareTo(e2.getValue());
            }
        });

        // Preserve sorted order using LinkedHashMap
        Map<String, Integer> sortedMap1 = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap1.put(entry.getKey(), entry.getValue());
        }
        System.out.println("Sorted Map (by value) Pre-Java 8 Approach: " + sortedMap1);

    }
}
