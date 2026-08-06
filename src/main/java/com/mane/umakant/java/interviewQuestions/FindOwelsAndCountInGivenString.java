package com.mane.umakant.java.interviewQuestions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindOwelsAndCountInGivenString {
    public static void main(String a[]) {
        // Q 27 Find vowels count in given string.
        String vowelsString = "Naveen AutomationLabs";
        List<Character> vowels = Arrays.asList(
                'a', 'A',
                'e', 'E',
                'i', 'I',
                'o', 'O',
                'u', 'U'
        );
        Set<Character> vowelsSet = Set.of(
                'a','e','i','o','u',
                'A','E','I','O','U'
        );
        int count = 0;
        int countSet=0;
        // Now we will Find and print all vowels and there count from the given string
        Set<Character> foundVowels=new HashSet<>();
        for (char ch : vowelsString.toCharArray()) {
            // System.out.println(ch);
            if (vowels.contains(ch)) {
                count = count + 1;
                foundVowels.add(ch);
            }
            if (vowelsSet.contains(ch)) {
                countSet = countSet + 1;
            }
        }
        System.out.println(count+" "+count);
        System.out.println(countSet+" "+countSet);
        System.out.println("foundVowels:: "+foundVowels);

        long countJava8=vowelsString
                .toLowerCase()
                .chars()
                .filter(ch->"aeiou".indexOf(ch)>=0)
                .count();
        System.out.println("countJava8:: "+countJava8);

        Set<String> foundVowelsSet =
                vowelsString
                        .chars()
                        .filter(ch->"aAeEiIoOuU".indexOf(ch)>=0)
                        .mapToObj(ch -> String.valueOf((char) ch))
                        .collect(Collectors.toSet());
        System.out.println("foundVowelsSet:: "+foundVowelsSet);


    }

}
