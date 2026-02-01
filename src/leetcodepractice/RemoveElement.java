package leetcodepractice;

import java.util.Arrays;
/*
https://leetcode.com/problems/remove-element/description/
27. Remove Element
*/
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        // 2-pointer approach: left, n
        int left = 0;
        int n = nums.length;

        while (left < n){
            if (nums[left] == val) {
                nums[left] = nums[n - 1]; // replace with last element
                n--; // shrink array size; move in from right
            } else { // if left != val
                left++; // move left in
            }
        }
        return n;
    }
    /*
    Approach 2: order-preserving (slow–fast pointer)
    i → fast pointer; Scans every element in the array
    index → slow pointer; Tracks where the next valid element should go.
    Also becomes the final count k

    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            // If it’s not equal to val, we want to keep it
            // If it is equal, we skip it (effectively removing it)
            if (nums[i] != val) {
                // Move the valid element to the front part of the array
                nums[index] = nums[i];
                // Prepare the next position for the next valid element
                index++; // 0 + 1
            }
        }
        return index;
    }
    */

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int k = new RemoveElement().removeElement(nums, val);
        System.out.println(nums.length); // 4
        System.out.println(nums.length - 1); // 3

        System.out.println(Arrays.toString(Arrays.copyOf(nums, k))); // [2, 2]
    }
}
/*
nums = [3,2,2,3], val = 3
index   0 1 2 3
if i = 3
nums[i] = nums[n - 1] replace with last element
3 = 3
n-- shrink array size

else if i != 3
left++ move left pointer in
-----------------
i=0 → nums[0]==3
i = 3; 3 = 3 -> true
nums[n - 1] = nums[3] = 3; replace 3 with 3
n--; -> move n pointer from 3 to 2

nums = [3,2,2,_]
is 3 = 3? true.
nums[i] = nums[n - 1]
replace n - 1 = 2 at 3 = nums = [2,2,_,_]

 */