package com.mane.umakant.java8.features.Optional.emptyMethod.realWorldExample;

import java.util.*;

public class OptionalDemo {
    // Main Method
    public static void main(String[] args)
    {
        String[] words = new String[10];

        Optional<String> checkNull = Optional.ofNullable(words[5]);

        if (checkNull.isPresent()) {
            String word = words[5].toLowerCase();
            System.out.print(word);
        }
        else
            System.out.println("word is null");


        List<String> list = Arrays.asList("A", "B", "C", "A", "B", "D");
        Set<String> uniques = new HashSet<>();
        Set<String> duplicates = new HashSet<>();

        for (String s : list) {
            if (!uniques.add(s)) {
                duplicates.add(s);
            }
        }

        System.out.println("duplicates: "+duplicates); // Output: [A, B]
        System.out.println("uniques: "+uniques);
    }


}
