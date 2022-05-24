package dsa.leetcode;

public class Quest1027 {
    public static void main(String[] args) {
        int[] arr = {44, 46, 22, 68, 45, 66, 43, 9, 37, 30, 50, 67, 32, 47, 44, 11, 15, 4, 11, 6, 20, 64, 54, 54, 61, 63, 23, 43, 3, 12, 51, 61, 16, 57, 14, 12, 55, 17, 18, 25, 19, 28, 45, 56, 29, 39, 52, 8, 1, 21, 17, 21, 23, 70, 51, 61, 21, 52, 25, 28};
        //int[] arr = {15,10,5,0};
        int i = longestArithSeqLength(arr);
        System.out.println(i);
    }


    public static int longestArithSeqLength(int[] nums) {
        int n = nums.length, ans = 0;
        int[][] dp = new int[n][1010];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // 表示nums[i]与nums[j]以差为d构成等差数列
                int d = nums[i] - nums[j] + 500;
                // dp[i][d]表示：nums[i]以差为d能与前面的数构成的等差数列的长度
                dp[i][d] = Math.max(dp[i][d], dp[j][d] + 1);
                ans = Math.max(ans, dp[i][d]);
            }
        }
        return ans + 1;
    }
}
