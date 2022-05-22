package dsa.leetcode;

public class Quest213 {
    public static void main(String[] args) {

    }

    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int length = nums.length;
        return Math.max(robRange(nums, 0, length-2), robRange(nums, 1, length - 1));
    }

    public static int robRange(int[] nums, int start, int end) {
        int first = nums[start];
        int second = Math.max(nums[start],nums[start + 1]);
        for (int i = start + 2; i <=end ; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }

}
