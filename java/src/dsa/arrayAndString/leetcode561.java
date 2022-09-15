package dsa.arrayAndString;

import java.util.Arrays;

public class leetcode561 {
    public static int arrayPairSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int sum = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (i%2 == 0) {
                sum += nums[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {6, 2, 6, 5, 1, 2};
        System.out.println(arrayPairSum(nums));
    }
}
