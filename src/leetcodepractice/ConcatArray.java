package leetcodepractice;

import java.util.Arrays;

/*
https://leetcode.com/problems/concatenation-of-array/description/
1929. Concatenation of Array
*/
public class ConcatArray {
    public int[] getConcatenation(int[] nums) {
        // nums = [1, 2, 1] -> n = 3 (length)
        int n = nums.length; // n = 3

        // Creating two copies of nums
        // instantiating into ans
        // ans = [0, 0, 0, 0, 0, 0]
        int[] ans = new int[2 * n];

        // Looping i from 0, 1, 2
        // i < n
        // n = 3
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
            // nums = [1, 2, 1]
            // index   0  1  2
            // ans[0] = nums[0]
            // ans = 1 = nums
            // ans[0 + 3] = nums[0]
            // ans[3] = 1 = nums[0]
            // ans = [1, 0, 0, 1, 0, 0]
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        System.out.println(nums.length); // 3
        ConcatArray ca = new ConcatArray();
        int[] ans = ca.getConcatenation(nums);
        System.out.println(Arrays.toString(ans)); // [1, 2, 1, 1, 2, 1]
    }
}
