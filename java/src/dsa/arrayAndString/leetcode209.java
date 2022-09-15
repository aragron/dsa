package dsa.arrayAndString;

public class leetcode209 {

    public static int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int slow = 0;
        int sum = 0;
        int count = Integer.MAX_VALUE;
        for (int fast = 0; fast < len; fast++) {
            sum += nums[fast];
            if (sum >= target) {
                while (sum >= target) {
                    count = Math.min(count, fast-slow+1);
                    sum -= nums[slow++];
                }
            }
        }
        return count == Integer.MAX_VALUE ? 0 :count;
    }
    public static void main(String[] args) {
//        int[] nums = {2,3,1,2,4,3};
//        int target = 7;

        int[] nums = {1,4,4};
        int target = 4;
        System.out.println(minSubArrayLen(target, nums));
    }
}
