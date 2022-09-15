package dsa.slidingWindowAndDoublePoint;

public class leetcode713 {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) {return 0;}
        int len = nums.length;
        int res = 0;
        int countSum = 1;
        int left = 0, right = 0;
        while (right < len) {
            countSum *=  nums[right];
            right++;
            while ( left <right && countSum >= k) {
                countSum /= nums[left];
                left++;
            }
            res += right-left;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 1;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }
}
