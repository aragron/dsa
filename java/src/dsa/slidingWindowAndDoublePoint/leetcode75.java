package dsa.slidingWindowAndDoublePoint;

import java.util.Arrays;

public class leetcode75 {
    public static void sortColors(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return;
        }
        int left = 0, right = len - 1;
        partition(nums,left,right,1);
    }

    public static int partition(int[] nums, int left, int right, int pivot) {
        //int pivot = 1;
        int zero = left;
        int two = right;
        int p = left;

        while (p <= two) {
            int tmp = nums[p];
            if (tmp < pivot) {
                swap(nums,zero,p);
                zero++;
                p++;
            } else if (tmp == pivot) {
                p++;
            } else { // tmp > pivot
                swap(nums,two,p);
                two--;
            }
        }
        return zero;
    }

    public static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
