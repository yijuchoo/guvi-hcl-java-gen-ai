package leetcodepractice;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/longest-palindrome/description/
409. Longest Palindrome
*/
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        // Step 1: Count frequency of each character
        Map<Character, Integer> map = new HashMap<>();

        // Converts string → char array
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            // If c exists in the map, return its value.
            // If it does NOT exist, return 0.
            // If c's value doesn't exist, give it a default value of 0 first.
            // then add 1 to value of c.
            // map.getOrDefault('a', 0)  → 0
            // 0 + 1                    → 1
            // map.put('a', 1)
        }

        // Step 2: Calculate the maximum palindrome length
        int length = 0;
        boolean hasCenter = false;

        for (int count : map.values()) {
            // Add the even part
            // solves odd cases such as (5/2) * 2 = 4
            length += (count / 2) * 2;

            // If count is odd and we haven't used a center yet
            if (count % 2 == 1 && !hasCenter) {
                length += 1;
                hasCenter = true;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        // Step 1: Prepare input
        String s = "abccccdd"; // Output: 7
//        String s = "a"; // Output: 1

        // Step 2: Create an object of LongestPalindrome
        LongestPalindrome lp = new LongestPalindrome();

        // Step 3: Call the method
        int result = lp.longestPalindrome(s);

        // Step 4: Print the result
        System.out.println(result);
    }
}
