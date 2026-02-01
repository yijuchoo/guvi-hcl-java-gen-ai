package leetcodepractice;

import java.util.Arrays;

/*
https://leetcode.com/problems/build-array-from-permutation/description/
1920. Build Array from Permutation
*/
public class ZeroBasedPermutation {
    public int[] buildArray(int[] nums) {

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }

    public static void main(String[] args) {
         int[] nums = {0, 2, 1, 5, 3, 4}; // Output: [0, 1, 2, 4, 5, 3]
//        int[] nums = {5, 0, 1, 2, 3, 4}; // Output: [4, 5, 0, 1, 2, 3]

        // Create object
        ZeroBasedPermutation zp = new ZeroBasedPermutation();

        // Call method
        // buildArray(nums) creates a new array called ans
        // ans is returned
        // result now points to that new array
        int[] result = zp.buildArray(nums);

        // Print result
        System.out.println(Arrays.toString(result));
        //        0  1  2  3  4  5
        //     ans = {0, 1, 2, 4, 5, 3}
        /*
            nums[1] = 2         nums[4] = 3
            nums[2] = 1         nums[3] = 5
            ans[1] = 1          ans[4] = 5

            nums[2] = 1         nums[5] = 4
            nums[1] = 2         nums[4] = 3
            ans[2] = 2          ans[5] = 3

            nums[3] = 5
            nums[5] = 4
            ans[3] = 4
        */
    }
}
