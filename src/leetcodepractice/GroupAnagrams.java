package leetcodepractice;

import java.util.*;
/*
https://leetcode.com/problems/group-anagrams/description/
49. Group Anagrams
*/
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            // Convert string to char array
            // String s = "eat" -> s.toCharArray() -> chars = ['e', 'a', 't']
            char[] chars = s.toCharArray();

            // Sort characters
            // Arrays are mutable; cannot sort a String directly; Arrays.sort(s); ❌ invalid
            // sorts the character array in ascending (alphabetical) order
            // char[] chars = {'e', 'a', 't'} -> chars = ['a', 'e', 't']
            Arrays.sort(chars);

            // Create key from sorted chars
            // converts the sorted char[] back into a String
            // char[] chars = {'a', 'e', 't'} -> String key = new String(chars) -> key = "aet"
            String key = new String(chars);

            // Add string to the map
//            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s); // shorthand
            if (!map.containsKey(key)) {
                /*
                If key does not exist → create a new ArrayList<> -> put it into the map
                return it
                */
                map.put(key, new ArrayList<>());
            }
            // If key exists → return the existing value
            // adds the current string to that list
            map.get(key).add(s);
        }

        // Return all grouped anagrams
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        // Output: [[eat, tea, ate], [bat], [tan, nat]]
        // String[] strs = {""}; // Output: [[]]
        // String[] strs = {"a"}; // Output: [[a]]
        // System.out.println(new GroupAnagrams().groupAnagrams(strs)); // shorthand
        GroupAnagrams obj = new GroupAnagrams();
        List<List<String>> result = obj.groupAnagrams(strs);
        System.out.println(result);
    }
}
