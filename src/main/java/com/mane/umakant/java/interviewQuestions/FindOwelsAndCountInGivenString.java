package com.mane.umakant.java.interviewQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindOwelsAndCountInGivenString {
    public static void main(String a[]) {
        String vowelsString = "Naveen AutomationLabs";

        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        // Find and print all vowels from the string
        String vowelsInString = vowelsString.chars()  // Convert the string to an IntStream
                .mapToObj(c -> (char) c)  // Convert each int to char
                .filter(vowels::contains)  // Filter only vowels
                .map(String::valueOf)  // Convert each character to a string
                .collect(Collectors.joining());  // Collect the result as a single string

        System.out.println("Vowels in the string: " + vowelsInString);

        // sub que:  Find vowels with there count or occurence
        Map<Character, Long> vowels_with_there_count = vowelsString.chars()
                .mapToObj(c -> (char) c)
                .filter(vowels::contains)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("vowels_with_there_count:: " + vowels_with_there_count);

        long vowelsCount = vowelsString.chars()
                .mapToObj(c -> (char) c)
                .filter(vowels::contains)
                .count();
        System.out.println("vowelsCount:: " + vowelsCount);
    }

}
