package dsa.slidingWindowAndDoublePoint;

public class leetcode1004 {
    public int longestOnes(int[] nums, int k) {
        int target = k;
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
