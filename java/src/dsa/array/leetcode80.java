package dsa.array;

import java.util.Arrays;

public class leetcode80 {

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int len = nums.length;
       int slow = 2, fast = 2;
       while (fast < len) {
           if (nums[slow-2] != nums[fast]) {
               nums[slow++] = nums[fast];
           }
           ++fast;
       }
        System.out.println(Arrays.toString(nums));
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1,2,3,4,4};
        //int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(removeDuplicates(nums));
    }
}
