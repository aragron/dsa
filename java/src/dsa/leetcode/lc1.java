package dsa.leetcode;

import java.util.Arrays;

public class lc1 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp,1);
        int maxNum = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    maxNum = Math.max(dp[i], maxNum);
                }
            }
        }
        return maxNum;
    }
}
