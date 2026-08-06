package com.mane.umakant.java.interviewQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class SecondHighestNumber {
    public static <Long> void main(String[] args) {
        /*
         Q6: find second highest number from given array.
         refer com.mane.umakant.java.interviewQuestions.SecondHighestNumber.java
        int[] primitiveArray = {5, 9, 11, 2, 8, 21, 21}; //op: 11
        Integer[] nonPrimitiveArray = {1, 2, 5, 6, 3, 2, 6};  // OP: 5
        int arr[] = {10, 5, 20, 8, 20, 15}; // op: 15
         */
        // int arr[] = {10, 10, 10};
        int arr[] = {5, 9, 11, 2, 8, 21, 21};
        int maxNumber = Integer.MIN_VALUE;
        int secondMaxNumber = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > maxNumber) {
                secondMaxNumber = maxNumber;
                maxNumber = num;
            } else if (num > secondMaxNumber && num != maxNumber) {
                secondMaxNumber = num;
            }
        }
        if (secondMaxNumber == Integer.MIN_VALUE) {
            System.out.println("No second highest element");
        } else {
            System.out.println("Second highest: " + secondMaxNumber);
            System.out.println(" highest: " + maxNumber);
        }
        // 🚀 2. Using Java 8 Streams
        Optional<Integer> secondHighest = Arrays.stream(arr)
                .distinct()
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();

        if (secondHighest.isPresent()) {
            System.out.println("Second highest: " + secondHighest.get());
        } else {
            System.out.println("Second highest not present");
        }

    }


}
