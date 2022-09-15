package dsa.arrayAndString;

public class leetcode26 {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int slow = 0;
        for (int fast = 1; fast < len; fast++) {
            if (nums[slow] != nums[fast]) {
                nums[++slow] = nums[fast];
            }
        }
        return slow+1;
    }
    public static void main(String[] args) {

    }
}
