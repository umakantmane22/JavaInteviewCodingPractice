package com.mane.umakant.collections.chatGpt;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateElementsInList {
    public static void main(String[] args) {
        // Using Set
        // Idea: If an element cannot be added to a Set, it is a duplicate.
        List<String> list = Arrays.asList("A", "B", "C", "A", "B", "D");
        Set<String> uniques = new HashSet<>();
        Set<String> duplicates = new HashSet<>();

        for (String s : list) {
            if (!uniques.add(s)) {
                duplicates.add(s);
            }
        }

        System.out.println("duplicates:: " + duplicates); // Output: [A, B]

        //        Explanation:
        //	HashSet.add() returns false if element already exists → detected as duplicate.
        //Time Complexity: O(n)

        // 2️⃣ Using Collections.frequency()
        // •	Not the most efficient for large lists (O(n²)), but simple:
        for (String s : list) {
            if (Collections.frequency(list, s) > 1) {
                duplicates.add(s);
            }
        }

        System.out.println("duplicates1:: " + duplicates); // Output: [A, B]

        // 3️⃣ Using Java 8 Streams

        duplicates = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println("duplicates2:: " + duplicates); // Output: [A, B]
        //Explanation:
        // 1.	groupingBy counts occurrences of each element
        // 2.	Filter elements with count > 1 → duplicates
        // 3.	Collect keys into a Set

        // 4️⃣ Using Map (Classic Approach)

        Map<String, Integer> map = new HashMap<>();
        for (String s : list) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey());
            }
        }
        //Advantages:
	//  Efficient for large lists
	//  Can also track frequency if needed


    }
}
