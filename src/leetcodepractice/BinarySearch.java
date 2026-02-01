package leetcodepractice;
/*
704. Binary Search
https://leetcode.com/problems/binary-search/description/
*/
public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0; // index 0
        int right = nums.length - 1; // end of array
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;      // target found
            }  else if (nums[mid] < target) {
                left = mid + 1;  // search right half
            }  else {
                right = mid - 1; // search left half
            }
        }
        return -1;              // target not found
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();

        System.out.println(bs.search(new int[]{-1,0,3,5,9,12}, 9)); // 4
        System.out.println(bs.search(new int[]{-1,0,3,5,9,12}, 2)); // -1
    }
}
