package com.mane.umakant.java8.javatechie.interviewQuestions;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CountTheNumberOfWordsPresentInString {
    public static void main(String a[]) {
        // Q32: Write a Java program to count the number of words present in a string
        // input String s = "Sharma is a good player and he is so punctual";
        // op: 10
        String inputString = "Sharma is a good player and he is so punctual";
        String[] words = inputString.split(" ");
        System.out.println("Q32: number of words present in a string:: "+words.length);
        for (String word:words) {
            //System.out.println(word);
        }

        // Java8

        Long number_of_words_present_in_a_string = Arrays.stream(inputString.split(" ")).collect(Collectors.counting());
        System.out.println("number_of_words_present_in_a_string:: "+number_of_words_present_in_a_string);


    }
}
