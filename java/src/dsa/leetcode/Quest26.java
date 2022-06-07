package dsa.leetcode;

import java.util.Arrays;

public class Quest26 {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int n = removeDuplicates(nums);
        System.out.println(n);
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int j = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
            //System.out.println(Arrays.toString(nums));
        }
        return j + 1;
    }
}
