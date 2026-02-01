package leetcodepractice;
/*
977. Squares of a Sorted Array
https://leetcode.com/problems/squares-of-a-sorted-array/description/
*/
import java.util.Arrays;

public class SquareSortedArray {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        int[] result = new int[n];
        int index = n - 1; // fill from the back

        while (left <= right){
            int leftSq = nums[left] * nums[left];
            int rightSq = nums[right] * nums[right];
            // original [-4, -1, 0, 3, 10]
            // squared  [16, 1, 0, 9, 100]
            if (leftSq > rightSq){
                // 16 > 9 -> true
                // result[3] = 16
                result[index] = leftSq;
                // [9, 1, 0, 16^, 100]
                // move left pointer in
                // [9, ^1, 0, 16^, 100]
                left++;
            } else {
                // 16 < 100
                // result[4] = 100 -> remain at 4th index
                result[index] = rightSq;
                // [16, 1, 0, 9, 100]
                // move right pointer inwards
                right--;
            }
            index--;
        }
        return result;
        // [_, _, _, _, 100]
        // [_, _, _, 16, 100]
    }
    public static void main(String[] args) {
        SquareSortedArray ss = new SquareSortedArray();
        System.out.println(Arrays.toString(ss.sortedSquares(new int[]{-4, -1, 0, 3, 10})));
    }
}
