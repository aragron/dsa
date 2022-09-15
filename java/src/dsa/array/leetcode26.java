package dsa.array;

import java.util.Arrays;

public class leetcode26 {

    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        int left = 0;
        for (int right = 1; right < len; right++) {
            if (nums[right] != nums[left])
                nums[++left] = nums[right--];
        }
        return left + 1;
    }

    public static void main(String[] args) {
        //int[] nums = {1,1,2};
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int i = removeDuplicates(nums);
        System.out.println(i);
    }
}
