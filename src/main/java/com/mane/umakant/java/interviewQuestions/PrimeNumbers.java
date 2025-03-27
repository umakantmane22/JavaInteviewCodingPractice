package com.mane.umakant.java.interviewQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumbers {
    // https://www.youtube.com/watch?v=Lu0hQ1wVPWw
    //A prime number is any positive number that can only be divided by itself and the number 1.
    //prime numbers are
    //2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97.
    public static void main(String args[]) {
        //System.out.println(Math.sqrt(5));System.out.println(5/2);
        // Check given number is prime or not?
        int number = 29;
        // using Java7
        // Prime numbers are greater than 1
        boolean primeFlag = true;
        if (number <= 1) {
            primeFlag = false;
        } else {
            for (int i = 2; i <= number / 2; i++) {
                if (number % i == 0) {
                    primeFlag = false;
                    break;
                } else {
                    primeFlag = true;
                }
            }
        }
        System.out.println(number + " is prime:: " + primeFlag);

        // or

        // Prime numbers are greater than 1
        if (number <= 1) {
            primeFlag = false;
        } else {
            // Check if the number has any divisors other than 1 and itself
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    primeFlag = false; // Not a prime number
                    break;
                } else {
                    primeFlag = true;
                }
            }
        }
        System.out.println(number + " is prime:: " + primeFlag);

        // using Java8
        // System.out.println(number + " is prime number?: " + isPrime(number));
        if (IntStream.range(2, number).noneMatch(n -> number % n == 0) && number > 1) {
            System.out.println(number + " is prime number?: Yes ");
        } else {
            System.out.println(number + " is prime number?: No");
        }
        //or
        if (IntStream.rangeClosed(2, (int) Math.sqrt(number)).noneMatch(n -> number % n == 0) && number > 1) {
            System.out.println(number + " is prime number?: Yes ");
        } else {
            System.out.println(number + " is prime number?: No");
        }

        // print prime numbers upto 17
        int primeNoUpto = 17; // Start checking for primes from 2
        List<Integer> primNumbers = new ArrayList<>();
        for (int i = 2; i <= primeNoUpto; i++) {
            boolean isPrimeCheck = true;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    isPrimeCheck = false;
                    break;
                }
            }
            if (isPrimeCheck) {
                System.out.println(i + " ");
                primNumbers.add(i);
            }
        }
        System.out.println(primNumbers);
        // using Java8

        primNumbers = IntStream.rangeClosed(2, primeNoUpto)  // Stream numbers from 2 to 17
                .filter(PrimeNumbers::isPrime)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(primNumbers);
    }

    private static boolean isPrime(int number) {
        return IntStream.range(2, number).noneMatch(n -> number % n == 0 && number > 1);
    }
}
