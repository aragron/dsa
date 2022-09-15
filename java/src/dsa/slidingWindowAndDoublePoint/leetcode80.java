package dsa.slidingWindowAndDoublePoint;

import java.util.Arrays;

public class leetcode80 {
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len<=2) {
            return len;
        }
        int slow = 2, fast = 2;
        while (fast < len) {
            if (nums[slow-2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int i = removeDuplicates(nums);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }
}
