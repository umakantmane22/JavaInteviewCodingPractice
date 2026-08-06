package com.mane.umakant.java.interviewQuestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.OptionalInt;

public class MinMaxNumberFromGivenInteger {
    public static void main(String a[]) {
        //Q35: Write a program to find min and max number from given integer" // op: Optional[1] Optional[9]
        int number = 3912578;
        int oldNumber = number;
        int number2 = number;
        // using java7 logic
        // Initialize min and max with extreme values
        //  int min = 9;  // Maximum possible digit
        //  int max = 0;  // Minimum possible digit
        int min = Integer.MAX_VALUE;  // Maximum possible digit
        int max = Integer.MIN_VALUE;  // Minimum possible digit
        // Iterate through each digit without using predefined functions
        if (number == 0) {
            min = max = 0;
        } else {
            while (number > 0) {
                int digit = number % 10; // Extract the last digit
                // Update min if the current digit is smaller
                if (digit < min) {
                    min = digit;
                }
                // Update max if the current digit is larger
                if (digit > max) {
                    max = digit;
                }
                // Remove the last digit from the number
                number = number / 10;
            }
        }
        // Output the results
        System.out.println("Min Digit: " + min);
        System.out.println("Max Digit: " + max);
        System.out.println("Updated value in number variable: " + number);

        // using Java8
        // Best approch 1:
        IntSummaryStatistics intSummaryStatistics = String.valueOf(number2).chars()
                // .map(ch->ch-'0')
                .map(Character::getNumericValue)
                .summaryStatistics();
        System.out.println(intSummaryStatistics.getMax() + " " + intSummaryStatistics.getMin());

        // Best approch 2:
        OptionalInt maxJava8UsingMaxOperator = String.valueOf(number2).chars()
                //   .map(ch->ch-'0')
                .map(Character::getNumericValue)
                .max();
        System.out.println("maxJava8UsingMaxOperator:: " + maxJava8UsingMaxOperator);
        OptionalInt minJava8UsingMaxOperator = String.valueOf(number2).chars()
                // .map(ch->ch-'0')
                .map(Character::getNumericValue)
                .min();
        System.out.println("minJava8UsingMaxOperator:: " + minJava8UsingMaxOperator);

        // int number = 3912578;
        // Best approch 3:
        String numStr = String.valueOf(oldNumber);
        int min8 = numStr.chars()
                // .map(c -> c - '0')
                .map(Character::getNumericValue).min().orElseThrow();
        int max8 = numStr.chars()
                // .map(c -> c - '0')
                .map(Character::getNumericValue).max().getAsInt();

        System.out.println("Min digit: " + min8);
        System.out.println("Max digit: " + max8);
    }
}
