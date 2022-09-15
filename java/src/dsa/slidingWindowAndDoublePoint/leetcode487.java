package dsa.slidingWindowAndDoublePoint;

public class leetcode487 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int target = 1;
        int len = nums.length;
        int left = 0;
        int zeroCount = 0;
        for (int right = 0; right < len; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            if (zeroCount > target) {
                if (nums[left] == 0) {
                    left++;
                    zeroCount--;
                } else {
                    left++;
                }
            }
        }
        return len - left;
    }
    public static void main(String[] args) {

    }
}
