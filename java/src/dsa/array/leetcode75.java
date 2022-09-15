package dsa.array;

import java.util.Arrays;

public class leetcode75 {

    public static void sortColors(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }
        int right = len - 1;
        int left = 0;
        for (int i = 0; i < len; i++) {
            if (left >= right || i > right) {
                return;
            }
            if (nums[i] == 0) {
                int tmp = nums[left];
                nums[left] = nums[i];
                nums[i] = tmp;
                ++left;
            } else if (nums[i] == 2) {
                int tmp = nums[right];
                nums[right] = nums[i];
                nums[i] = tmp;
                --right;
                --i;
            }
        }
    }

    public static void main(String[] args) {
        //int[] nums = {2, 0,  1};
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
