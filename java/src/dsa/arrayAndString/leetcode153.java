package dsa.arrayAndString;

public class leetcode153 {
    public static int findMin(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int low = 0;
        int high = len-1;
        while (low < high) {
            int mid = low + (high-low)/2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else if (nums[mid] < nums[high]) {
                high = mid;
            }
        }
        return nums[low];
    }
    public static void main(String[] args) {
        int[] nums = {11,13,15,17};
        System.out.println(findMin(nums));
    }
}
