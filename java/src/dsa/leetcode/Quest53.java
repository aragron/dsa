package dsa.leetcode;

public class Quest53 {
    public static void main(String[] args) {

    }

    public static int maxSubArray(int[] nums) {

        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        int pre = 0, maxAns = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            maxAns = Math.max(maxAns, dp[i]);
        }
        return maxAns;
    }
}
