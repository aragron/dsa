package dsa.arrayAndString;

public class leetcode283 {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return;
        }
        int low = 0;
        int high = len -1;
        while (low < high) {
            if (nums[high] != 0) {
                int tmp = nums[low];
                nums[low++] = nums[high];
                nums[high] = tmp;
            } else {
                high--;
            }
        }
    }
    public static void main(String[] args) {

    }
}






