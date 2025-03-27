package com.mane.umakant.java8.javatechie.interviewQuestions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SecondHighestOddOccuredNumber {
    public static void main(String a[]){
        //Q37 : find 2nd highest odd occured number");

        int[] inputArray = {13,13,13,13,13,1,2,2,3,3,3,4,4,4,5,5,5,6,6,7,7,11,11,11,11,11,11,11};
      // op:  occurrenceMap: {1=1, 3=3, 5=3, 7=2, 11=7, 13=5}
       //op: The 2nd highest odd occurred number is: 13
        // Create a map to store the occurrence of each odd number
        Map<Integer, Integer> occurrenceMap = new HashMap<>();
        // Loop through the array to populate the map with odd numbers and their occurrence counts
        for (int num : inputArray) {
            if (num % 2 != 0) {  // Only consider odd numbers
                occurrenceMap.put(num, occurrenceMap.getOrDefault(num, 0) + 1);
            }
        }
        System.out.println("occurrenceMap: "+occurrenceMap);
        // Create a list to store all occurrence counts
        ArrayList<Integer> occurrences = new ArrayList<>(occurrenceMap.values());
        // Sort the occurrences in descending order
        Collections.sort(occurrences, Collections.reverseOrder());
        // Get the second highest occurrence
        if (occurrences.size() > 1) {
            int secondHighestOccurrence = occurrences.get(1);

            // Find and print the odd number(s) with the second highest occurrence
            for (Map.Entry<Integer, Integer> entry : occurrenceMap.entrySet()) {
                if (entry.getValue() == secondHighestOccurrence) {
                    System.out.println("The 2nd highest odd occurred number is: " + entry.getKey());
                    break;
                }
            }
        } else {
            System.out.println("Not enough distinct odd numbers to find the 2nd highest occurrence.");
        }

        // java8
        Optional<Integer>secondHighestOddOccuredNumber=Arrays.stream(inputArray).boxed()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .filter(x->x.getValue()%2!=0)
                .sorted((x,y)->(int)(y.getValue()-x.getValue()))
                .map(x->x.getKey())
                .skip(1)
                .findFirst();
        System.out.println("secondHighestOddOccuredNumber using Java8:: "+secondHighestOddOccuredNumber);
    }
}
