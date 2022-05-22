package dsa.leetcode;

import java.util.Arrays;

public class Quest740 {
    public static void main(String[] args) {
        int[] nums = {2,2,3,3,3,4};

        int i = deleteAndEarn(nums);
        System.out.println(i);
    }

    public static int deleteAndEarn(int[] nums) {
        int maxValue = 0;
        for (int num : nums) {
            maxValue = Math.max(maxValue, num);
        }
        int[] dp = new int[maxValue + 1];
        for (int num : nums) {
            dp[num] += num;
        }
        return rob(dp);
    }

    public static int rob(int[] nums) {
        int length = nums.length;
        int first = nums[0], second = Math.max(nums[0], nums[1]);

        for (int i = 2; i < length; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
