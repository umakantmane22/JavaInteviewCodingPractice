package com.mane.umakant.java.interviewQuestions;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SecondHighestOddOccuredNumber {
    public static void main(String a[]) {
        //Q37 : find 2nd highest odd occured number");

        int[] inputArray = {13, 13, 13, 13, 13, 1, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 7, 7, 11, 11, 11, 11, 11, 11, 11};
        // op:  occurrenceMap: {1=1, 3=3, 5=3, 7=2, 11=7, 13=5}
        //op: The 2nd highest odd occurred number is: 13
    /*    Meaning 1 (Most Common Interview Interpretation)
        Find the number whose occurrence count is odd, and among those numbers, return the 2nd highest occurrence count.
        Example:
        Number	Count	Count is Odd?
        13	5	✅
        1	1	✅
        2	2	❌
        3	3	✅
        4	3	✅
        5	3	✅
        6	2	❌
        7	2	❌
        11	7	✅

        Odd occurrence numbers are

        13 -> 5
        11 -> 7
        3  -> 3
        4  -> 3
        5  -> 3
        1  -> 1

        Sort by occurrence count descending

        11 -> 7
        13 -> 5
        3 -> 3
        4 -> 3
        5 -> 3
        1 -> 1

        So answer is

        13

        Your(Below) code is solving this problem.
    */
        Optional<Integer> second_highest_odd_occured_number = Arrays.stream(inputArray).boxed()
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                )
                .entrySet().stream()
                .filter(data -> data.getValue() % 2 != 0)
                .sorted(Comparator.comparing(Entry::getValue, Comparator.reverseOrder()))
                .map(Entry::getKey)
                .skip(1)
                .findFirst();
        if (second_highest_odd_occured_number.isPresent()) {
            System.out.println("second_highest_odd_occured_number:: " + second_highest_odd_occured_number.get());
        } else {
            System.out.println("second_highest_odd_occured_number not found");
        }
    /*    Meaning 2
        Find the 2nd highest odd number which occurs in the array.
        Odd numbers are:
        1
        3
        5
        7
        11
        13
        Highest:
        13
        Second highest:
        11
        This is a completely different problem.
        */

    }
}
