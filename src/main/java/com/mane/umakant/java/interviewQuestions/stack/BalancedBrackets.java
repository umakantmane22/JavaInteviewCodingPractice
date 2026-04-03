package com.mane.umakant.java.interviewQuestions.stack;
import java.util.Stack;
public class BalancedBrackets {

    /*
    You are given a string like:
    ✅ Valid: [()()]{}
    ❌ Invalid: ([{]})
     */
    public static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {

            // Step 1: Push opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // Step 2: Handle closing brackets
            else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // Step 3: Stack should be empty
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String input1 = "[()()]{}";
        String input2 = "([{]})";

        System.out.println(input1 + " → " + isValid(input1)); // true
        System.out.println(input2 + " → " + isValid(input2)); // false
    }
}