package dsa.leetcode;

import java.util.Arrays;

public class Quest27 {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        int i = removeElement(nums, val);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 1) {
            return nums[0] == val ? 0 : 1;
        }
        int len = nums.length;
        int i = 0, j = len - 1;
        while (i<=j) {
            while (j >= 0 && nums[i] == val) {
                if ( nums[j] != val) {
                    nums[i] = nums[j];
                    j--;
                    break;
                }
                j--;
            }
            if (j <i) {
                break;
            }
            i++;
        }
        return i;
    }
}
