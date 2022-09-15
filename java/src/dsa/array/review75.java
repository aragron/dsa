package dsa.array;

import java.util.Arrays;

public class review75 {

    public static void sortColors(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return;
        }
        int left = 0, right = len - 1;
        partition(nums, left, right, 1);
    }

    public static int partition(int[] nums, int left, int right, int pivot) {
        //int pivot = 1;
        int le = left;
        int ge = right;
        int mid = left;
        for (int i = ge; i >= mid; i--) {
            int tmp = nums[i];
            if (pivot < tmp) {
                --ge;
            } else if (tmp == pivot) {
                swap(nums, mid, ge);
                mid++;
                ++i;
            } else { // tmp < pivot
                swap(nums, mid, ge);
                swap(nums, le, mid);
                le++;
                mid++;
                ++i;
            }
        }
        return le;
    }

    public static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
