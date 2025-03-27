package com.mane.umakant.java.interviewQuestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseString {
    public static void main(String a[]){
        //Q34: Write a program to find reverse of given string
        // input String start = "123456";
        // OP
        //reverseStringJava7: 654321

        String inputString="123456";
        System.out.println("input string:: "+inputString);

        StringBuffer reversedUsingStringBuffer=new StringBuffer();
        String reversedUsingString = "";
        System.out.println("Reverse chars in string:: ");
        for (int i=0;i<inputString.length();i++) {
            System.out.print(inputString.charAt(inputString.length()-i-1)+" ");

            reversedUsingStringBuffer.append(inputString.charAt(inputString.length()-i-1)+" ");
            reversedUsingString=reversedUsingString+inputString.charAt(inputString.length()-i-1)+" ";
        }
        System.out.println("");
        System.out.println("reversedUsingStringBuffer:: "+reversedUsingStringBuffer);
        System.out.println("reversedUsingString:: "+reversedUsingString);
        // or
        char[]charArray=inputString.toCharArray();
        // Initialize an empty string to store the reversed string
        String reversed = "";
        // Traverse the array from the end to the beginning
        for (int i = charArray.length - 1; i >= 0; i--) {
            reversed += charArray[i];
        }
        System.out.println("reversedUsingChatGpt:: "+reversed);

        // or using Java8
        List<String> reversedUsingJava8 = Arrays.stream(inputString.split(""))
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        System.out.println("reversedUsingJava8:: "+reversedUsingJava8);
    }
}
