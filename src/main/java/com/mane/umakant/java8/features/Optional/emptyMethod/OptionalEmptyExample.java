package com.mane.umakant.java8.features.Optional.emptyMethod;

import java.util.Optional;

//✅ Optional.empty() Example
//The empty() method returns an empty Optional instance — that is, an Optional that contains no value
// (i.e., it's like null, but safer).
public class OptionalEmptyExample {
    public static void main(String[] args) {
        Optional<String> emptyOpt=Optional.empty();
        System.out.println("Is value present? " + emptyOpt.isPresent());  // false

        String result = emptyOpt.orElse("Default Value");
        System.out.println("Result: " + result);  // Output: Default Value

        }
}
