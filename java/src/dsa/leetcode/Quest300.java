package dsa.leetcode;

import java.util.Arrays;

public class Quest300 {
    public static void main(String[] args) {
        int[] nums = {0};
        int i = lengthOfLIS(nums);
        System.out.println(i);
    }

    /**
     * 300 最长递增子序列
     * i表示最长子序列的末尾字符
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < nums.length ; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
