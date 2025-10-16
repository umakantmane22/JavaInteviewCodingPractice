package com.mane.umakant.collections.chatGpt;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyOfEachElement {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("java", "spring", "java", "hibernate", "spring", "java");
        // : Using Stream + Collectors.groupingBy()

        Map<String, Long> frequencyMap = names.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("frequencyMap:: " + frequencyMap);
        //   ✅ Explanation:
        //  •	groupingBy(Function.identity()) → groups identical elements.
        //  •	Collectors.counting() → counts how many times each element occurs.
        //  •	Returns a Map<String, Long> where the key is the element and the value is its frequency.

        //Example 2: Using forEach() (Before Java 8 Style)

        Map<String, Integer> frequencyMap1 = new HashMap<>();
        for (String name : names) {
            if (frequencyMap1.containsKey(name)) {
                frequencyMap1.put(name, frequencyMap1.get(name) + 1);
            } else {
                frequencyMap1.put(name, 1);
            }


        }
        System.out.println("Frequency of each number: " + frequencyMap1);


        List<Integer> numbers = Arrays.asList(1, 2, 2, 4, 3, 3, 3);
        Map<Integer, Integer> frequencyMap2 = new HashMap<>();

        for (Integer num : numbers) {
            frequencyMap2.put(num, frequencyMap2.getOrDefault(num, 0) + 1);
        }

        System.out.println("Frequency of each int numbers: " + frequencyMap2);

    }


}
