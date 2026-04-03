package com.mane.umakant.java.interviewQuestions.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedBracketsMap {
    /*
        You are given a string like:
        ✅ Valid: [()()]{}
        ❌ Invalid: ([{]})
         */
    public static void main(String[] args) {

        String input1 = "[()()]{}";
        String input2 = "([{]})";

        System.out.println(input1 + " → " + isValid(input1)); // true
        System.out.println(input2 + " → " + isValid(input2)); // false
    }

    public static boolean isValid(String str) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (map.containsValue(ch)) {
                stack.push(ch);
            } else if (map.containsKey(ch)) {
                if (stack.isEmpty() || stack.pop() != map.get(ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
