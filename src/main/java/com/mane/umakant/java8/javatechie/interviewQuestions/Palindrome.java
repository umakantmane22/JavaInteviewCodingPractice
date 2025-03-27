package com.mane.umakant.java8.javatechie.interviewQuestions;

import java.util.stream.IntStream;

public class Palindrome {
    public static void main(String a[]){
        // A string is said to be a palindrome if it reads the same backward as forward. e.g, racecar, level
        // Q 28 Find given string is Palindrome or not?
        //String palindromStr = "aba aba aba";
        String palindromStr = "level";
        boolean palFlag=true;
        for (int i=0;i<palindromStr.length()/2;i++){
            //System.out.println(palindromStr.charAt(i)+"  "+palindromStr.charAt(palindromStr.length()-i-1));
            if (palindromStr.charAt(i)!=palindromStr.charAt(palindromStr.length()-i-1)){
                System.out.println("Not pal");
                palFlag=false;
                break;
            }
        }
        if (palFlag){
            System.out.println("Using Java7:: yes");
        }else {
            System.out.println("Using Java7:: no");
        }
        // Java8
        palFlag=IntStream.rangeClosed(0,palindromStr.length()/2)
                .noneMatch(i->palindromStr.charAt(i)!=palindromStr.charAt(palindromStr.length()-i-1));
        if (palFlag){
            System.out.println("Using Java8:: yes");
        }else {
            System.out.println("Using Java8:: no");
        }
    }
}
