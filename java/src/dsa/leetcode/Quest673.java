package dsa.leetcode;

import java.util.Arrays;

public class Quest673 {

    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        int numberOfLIS = findNumberOfLIS(nums);
        System.out.println(numberOfLIS);
    }


    public static int findNumberOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int[] cnt = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);
        int res = 0;
        int ans = 0;
        for (int i = 0; i < nums.length ; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            if (dp[i] > res) {
                res = dp[i];
                ans = cnt[i];
            }else if (dp[i] == res) {
                ans += cnt[i];
            }
        }
        System.out.println(res);
        return ans;
    }
}
