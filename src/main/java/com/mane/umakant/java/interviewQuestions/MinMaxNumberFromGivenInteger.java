package com.mane.umakant.java.interviewQuestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;

public class MinMaxNumberFromGivenInteger {
    public static void main(String a[]){
        //Q35: Write a program to find min and max number from given integer" // op: Optional[1] Optional[9]
        int number = 3912578;
        int oldNumber=number;
        // using java7 logic
        // Initialize min and max with extreme values
        int min = 9;  // Maximum possible digit
        int max = 0;  // Minimum possible digit
        // Iterate through each digit without using predefined functions
        while (number>0){
            int digit=number % 10; // Extract the last digit
            // Update min if the current digit is smaller
            if(digit<min){
                min=digit;
            }
            // Update max if the current digit is larger
            if (digit>max){
                max=digit;
            }
            // Remove the last digit from the number
            number = number / 10;
        }
        // Output the results
        System.out.println("Min Digit: " + min);
        System.out.println("Max Digit: " + max);
        System.out.println("Updated value in number variable: " + number);

        // using Java8
        Optional<String> minNumber = Arrays.stream(String.valueOf(oldNumber).split("")).min(Comparator.comparing(Integer::valueOf));
        System.out.println("minNumber:: "+minNumber);
        String maxNumber=Arrays.stream(String.valueOf(oldNumber).split("")).max(Comparator.comparing(Integer::valueOf)).get();
        System.out.println("maxNumber:: "+maxNumber);

        int minJava8=Arrays.stream(String.valueOf(oldNumber).split(""))
                .map(Integer::valueOf)
                .sorted()
                .findFirst().get();

        int maxjava8=Arrays.stream(String.valueOf(oldNumber).split(""))
                .map(Integer::valueOf)
                .sorted(Collections.reverseOrder())
                .findFirst().get();

        System.out.println("minJava8: "+minJava8+" maxjava8: "+maxjava8);


    }
}
