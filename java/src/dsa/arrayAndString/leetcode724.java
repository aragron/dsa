package dsa.arrayAndString;

import java.util.Arrays;

public class leetcode724 {

    public static int pivotIndex(int[] nums) {
        int len = nums.length;
        int sum = Arrays.stream(nums).sum();
        int leftSum = 0;
        for (int i = 0; i < len; i++) {
            if (2 * leftSum + nums[i] == sum){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 7, 3, 6, 5, 6};
//        int[] nums = {1, 2,3};
//        int[] nums = {2,1,-1};
        int[] nums = {-1,-1,-1,-1,-1,0};
        System.out.println(pivotIndex(nums));
    }
}
