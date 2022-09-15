package dsa.hash;

public class leetcode1004 {
    public static int longestOnes(int[] nums, int k) {
        int right, left = 0;
        int oneCount = 0;
        for (right = 0; right < nums.length; right++) {
            if (nums[right] == 1) {
                oneCount++;
            }
            if (right - left + 1 > oneCount + k) {
                if (nums[left] == 1) {
                    oneCount--;
                }
                left++;
            }
        }
        return nums.length - left;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int K = 3;
        System.out.println(longestOnes(nums, K));
    }
}
