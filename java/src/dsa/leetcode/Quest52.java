package dsa.leetcode;

import java.util.Arrays;

public class Quest52 {
    public static void main(String[] args) {
        int[] nums = {-2, -3, -2, 4};
        int i = maxProduct(nums);
        System.out.println(i);
    }

    public static int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int[] maxDp = Arrays.copyOf(nums, n);
        int[] minDp = Arrays.copyOf(nums, n);
        for (int i = 1; i < n; ++i) {
            maxDp[i] = Math.max(maxDp[i - 1] * nums[i], Math.max(nums[i], minDp[i - 1] * nums[i]));
            minDp[i] = Math.min(maxDp[i - 1] * nums[i], Math.min(nums[i], minDp[i - 1] * nums[i]));
        }
        int res = maxDp[0];
        for (int num : maxDp) {
            res = Math.max(res, num);
        }
        return res;
    }
}
