package dsa.arrayAndString;

public class leetcode27 {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int slow = 0, fast = 0;
        for (fast = 0; fast < len; fast++) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
    public static void main(String[] args) {

    }
}
