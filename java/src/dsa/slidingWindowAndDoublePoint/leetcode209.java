package dsa.slidingWindowAndDoublePoint;

public class leetcode209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int sum = 0;
        int left = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < len; right++) {
            sum += nums[right];
            while (left < right && sum - nums[left] >= target) {
                sum -= nums[left];
                left++;
            }
            if (sum >= target) {
                result = Math.min(result, right - left + 1);
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(target, nums));
    }
}
