package com.mane.umakant.java.interviewQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LongestCommonPrefixString {
    public static void main(String[] args) {
		/* Write a function to find the longest common prefix string amongst an array of strings.
		If there is no common prefix, return an empty string "".
		Example 1
		Input:
		strs = ["flower","flow","flight"]
		Output:
		"fl" */
        String[] input1 = {"flower", "flow", "flight"};
        List<String> input2 = Arrays.asList("flower", "flow", "flight");
        String prefix1 = input1[0];
        for (int i = 0; i < input1.length; i++) { // here we use length
            while (!input1[i].startsWith(prefix1)) {
                prefix1 = prefix1.substring(0, prefix1.length() - 1);
            }
        }
        System.out.println("comms prefix1:: " + prefix1);

        String prefix2 = input2.get(0);
        for (int i = 0; i < input2.size(); i++) { // here we use size
            while (!input2.get(i).startsWith(prefix2)) {
                prefix2 = prefix2.substring(0, prefix2.length() - 1);
            }
        }
        System.out.println("comms prefix2:: " + prefix2);

        System.out.println(longestCommonPrefix(input1));
        System.out.println(longestCommonPrefix(input2));

    }

    // 1. Normal Java Solution (Array)
    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {

            while (strs[i].startsWith(prefix) == false) {

                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    // 2. Normal Java Solution (List)
    //Only these changes:
    //strs.length  -> strs.size()
    //strs[i]      -> strs.get(i)
    public static String longestCommonPrefix(List<String> strs) {

        if (strs == null || strs.isEmpty()) {
            return "";
        }

        String prefix = strs.get(0);

        for (int i = 1; i < strs.size(); i++) {

            while (strs.get(i).startsWith(prefix) == false) {

                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    public static String longestCommonPrefixNormalArrayJava8(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        String shortest = Arrays.stream(strs)
                .min(Comparator.comparingInt(String::length))
                .get();

        for (int len = shortest.length(); len >= 0; len--) {

            String prefix = shortest.substring(0, len);

            boolean matches = Arrays.stream(strs)
                    .allMatch(str -> str.startsWith(prefix));

            if (matches) {
                return prefix;
            }
        }

        return "";
    }

    public static String longestCommonPrefixArrayListJava8(List<String> strs) {

        if (strs == null || strs.isEmpty()) {
            return "";
        }

        String shortest = strs.stream()
                .min(Comparator.comparingInt(String::length))
                .get();

        for (int len = shortest.length(); len >= 0; len--) {

            String prefix = shortest.substring(0, len);

            boolean matches = strs.stream()
                    .allMatch(str -> str.startsWith(prefix));

            if (matches) {
                return prefix;
            }
        }

        return "";
    }
}
