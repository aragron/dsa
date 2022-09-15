package dsa.array;

public class leetcode209 {

    public static int minSubArrayLen(int target, int[] nums) {
        int p1 = 0, p2 = 0, len = nums.length;
        int sum = 0;
        int minCount = Integer.MAX_VALUE;
        while (p2 < len) {
            sum += nums[p2];
            while (sum >= target) {
                minCount = Math.min(minCount, p2-p1+1);
                sum -= nums[p1];
                p1++;
            }
            p2++;
        }
        return minCount == Integer.MAX_VALUE ? 0 : minCount;
    }

    public static void main(String[] args) {
        int target = 6;
        int[] nums = {10,2,3};
        System.out.println(minSubArrayLen(target, nums));
    }
}
