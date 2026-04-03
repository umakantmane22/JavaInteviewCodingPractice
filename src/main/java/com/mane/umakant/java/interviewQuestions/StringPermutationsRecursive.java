package com.mane.umakant.java.interviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class StringPermutationsRecursive {
    static List<String> combo = new ArrayList<>();
    public static void main(String[] args) {
        String input = "ABC";
        permute("", input);
        System.out.println("combo:: "+combo);
    }

    private static void permute(String prefix, String remaining) {
        if (remaining.isEmpty()) {
            System.out.println(prefix);
            combo.add(prefix);
            return;
        }

        for (int i = 0; i < remaining.length(); i++) {
            char ch = remaining.charAt(i);
            String rest = remaining.substring(0, i) + remaining.substring(i + 1);
            permute(prefix + ch, rest);
        }
    }
}
