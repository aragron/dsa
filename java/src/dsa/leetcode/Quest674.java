package dsa.leetcode;

public class Quest674 {
    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2};
        int lengthOfLCIS = findLengthOfLCIS(nums);
        System.out.println(lengthOfLCIS);
    }

    public static int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        int res = 0, i = 0, j = 0;
        while (j < len) {
            if (j > 0 && nums[j-1]>=nums[j]) {
                i=j;
            }
            j++;
            res = Math.max(res, j-i);
        }
        return res;
    }
}
