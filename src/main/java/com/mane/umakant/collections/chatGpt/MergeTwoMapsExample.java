package com.mane.umakant.collections.chatGpt;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeTwoMapsExample {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 10);
        map1.put("B", 20);
        map1.put("C", 30);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 40);
        map2.put("D", 50);

        // Merge using Streams
        Map<String, Integer> mergedMap = Stream.concat(map1.entrySet().stream(), map2.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (v1, v2) -> v1 + v2 // merge function when duplicate keys found
                ));
        System.out.println("Merged Map1: " + mergedMap);

        map2.forEach((key, value) ->
                map1.merge(key, value, (v1, v2) -> v1 + v2));
        System.out.println("Merged Map2: " + map1);

        Map<String, Integer> merged = new HashMap<>(map1);
        merged.putAll(map2);

        System.out.println("Merged Map3: " + merged);

    }
}