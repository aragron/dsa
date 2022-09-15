package dsa.array;

import java.util.Arrays;

public class leetcode27 {

    public static int removeElement(int[] nums, int val) {
        int left = 0, len = nums.length ;
        for (int right = 0; right < len; right++) {
            if (nums[right] != val) {
                nums[left++]=nums[right];
            }
        }
        return left;
    }

    public static void main(String[] args) {
        //int[] nums = {3,2,2,3};int val = 3;
        //int[] nums = {4,5};int val = 4;
        //int[] nums = {0,1,2,2,3,0,4,2};int val = 2;
        //int[] nums = {3,3};int val = 3;
        int[] nums = {2};int val = 3;

        int element = removeElement(nums, val);
        System.out.println(element);
    }
}
