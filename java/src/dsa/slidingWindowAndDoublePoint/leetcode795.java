package dsa.slidingWindowAndDoublePoint;

public class leetcode795 {
    public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return lessEqualsThan(nums, right) - lessEqualsThan(nums,left-1);
    }
    public static int lessEqualsThan(int[] nums, int max) {
        int res = 0;
        int countArray = 0;
        for (int num : nums) {
            if (num <= max) {
                countArray++;
                res += countArray;
            } else {
                countArray = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,4,3}; int left = 2, right = 3;
        System.out.println(numSubarrayBoundedMax(nums, left, right));
    }
}
