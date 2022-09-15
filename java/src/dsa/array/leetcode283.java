package dsa.array;

import java.util.Arrays;

public class leetcode283 {
    public static void moveZeroes(int[] nums) {
        int len = nums.length, left = 0, right = 0;
        while (right < len) {
            if (nums[right] != 0) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
            }
            right++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
