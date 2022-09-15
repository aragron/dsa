package dsa.slidingWindowAndDoublePoint;

import java.util.Random;

public class leetcode215 {
    private static Random random = new Random(System.currentTimeMillis());
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int target = len -k;
        int left = 0, right = len -1;
        while (true) {
            int pIndex = partition(nums,left,right);
            if (pIndex == target) {
                return nums[pIndex];
            } else if (pIndex < target) {
                left = pIndex+1;
            }else {
                right = pIndex-1;
            }
        }
    }

    public static int partition(int[] nums, int left, int right) {
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, randomIndex);
        int pivot = nums[left];
        int low = left;
        for (int i = left+1; i <= right; i++) {
            if (nums[i] <= pivot) {
                low++;
                swap(nums,low,i);
            }
        }
        swap(nums,left,low);
        return low;
    }
    public static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    public static void main(String[] args) {

    }
}
