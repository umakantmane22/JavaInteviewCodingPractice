package com.mane.umakant.java.interviewQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindCommonCharactersFromGivenTwoString {
    public static void main(String a[]) {
        // Q33: Write a program to find common characters from given two string
        // input 123456, 162, 21 op: common chars from first 2 string:1,2,6 & from all 3 is: 1,2
        // https://www.youtube.com/watch?v=axXg624LaC8
        Scanner sc = new Scanner(System.in); // 👉 Used to take input from user
        System.out.println("Please enter first string");
        String firstStringInput = sc.next();
        System.out.println("Please enter second string");
        String secondStringInput = sc.next();
        System.out.println("Please enter third string");
        String thirdStringInput = sc.next(); //👉 Takes 3 strings (no spaces allowed because of next())
        System.out.println("firstStringInput: " + firstStringInput + " secondStringInput: " + secondStringInput + " thirdStringInput: " + thirdStringInput);
        List<Character> commonChars = findCommonCharacters(firstStringInput, secondStringInput); //👉 Stores final result
        System.out.println("Common characters from first and second input string:: " + commonChars);
        List<Character> commonChars3InputStrings = findCommonCharacters(firstStringInput, secondStringInput, thirdStringInput);
        System.out.println("Common characters from first and second third input string:: " + commonChars3InputStrings);
    }

    private static List<Character> findCommonCharacters(String firstStringInput, String secondStringInput) {
        // Convert strings to char arrays
        char[] charArray1 = firstStringInput.toCharArray(); // . Convert first string to char array
        char[] charArray2 = secondStringInput.toCharArray();    // . Convert second string to char array

        List<Character> commonChars = new ArrayList<>();
        // Check each character from the first string
        for (char c : charArray1) { // 👉 Iterate over each character of first string only
            // If character exists in the second string and is not already added to the common list
            if (secondStringInput.indexOf(c) != -1 && !commonChars.contains(c)) {
                commonChars.add(c);
            }
        }
        return commonChars;
        /*
        Note:
        Condition:
        secondStringInput.indexOf(c) != -1
        👉 Checks:
        Is character c present in second string?

        ✔ If found → returns index (0,1,2...)
        ❌ If not found → returns -1

        🧩 Condition 3 (Very Important)
        !commonChars.contains(c)

        👉 Ensures:

        No duplicate characters in result

         */
    }

    private static List<Character> findCommonCharacters(String firstStringInput, String secondStringInput, String thirdStringInput) {
        // Convert first string to char array
        char[] charArray1 = firstStringInput.toCharArray();
        List<Character> commonChars = new ArrayList<>();
        // Check each character from the first string
        for (char c : charArray1) {
            // If character exists in both the second and third strings, and is not already added to the common list
            if (secondStringInput.indexOf(c) != -1 && thirdStringInput.indexOf(c) != -1 && !commonChars.contains(c)) {
                commonChars.add(c);
            }
        }
        return commonChars;
    }

}
