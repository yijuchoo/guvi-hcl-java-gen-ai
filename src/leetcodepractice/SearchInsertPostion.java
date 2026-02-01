package leetcodepractice;
/*
35. Search Insert Position
https://leetcode.com/problems/search-insert-position/description/
*/
public class SearchInsertPostion {
    public int searchInsert(int[] nums, int target) {
        // Loop through array
        for (int i = 0; i < nums.length; i++) {
            // If target is found OR should be inserted here
            if (nums[i] >= target) {
                return i;
            }
        }

        // If target is greater than all elements
        return nums.length;
    }

    public static void main(String[] args) {
        SearchInsertPostion si = new SearchInsertPostion();

        System.out.println(si.searchInsert(new int[]{1,3,5,6}, 5)); // 2
        System.out.println(si.searchInsert(new int[]{1,3,5,6}, 2)); // 1
        System.out.println(si.searchInsert(new int[]{1,3,5,6}, 7)); // 4
    }
}
