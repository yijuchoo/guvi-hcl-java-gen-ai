package leetcodepractice;

import java.util.*;
/*
https://leetcode.com/problems/valid-parentheses/description/
20. Valid Parentheses
*/
public class ValidParentheses {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        // Map closing brackets to their matching opening brackets
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        // Converts the string s into a character array
        // Loops through each character one by one
        for (char ch : s.toCharArray()) {
            // If it's a closing bracket
            if (map.containsKey(ch)) {
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                if (top != map.get(ch)) return false;
            }
            // Otherwise it's an opening bracket
            else {
                stack.push(ch);
            }
        }

        // Valid only if no unclosed brackets remain
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String[] tests = {
                "()",
                "()[]{}",
                "(]",
                "([])",
                "([)]"
        };

        for (String s : tests) {
            System.out.println("Input: " + s + " -> " + isValid(s));
        }
    }
    /*
    Input: () -> true
    Input: ()[]{} -> true
    Input: (] -> false
    Input: ([]) -> true
    Input: ([)] -> false
    */
}
