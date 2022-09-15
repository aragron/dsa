package dsa.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class leetcode215 {
    private final static Random random = new Random(System.currentTimeMillis());

    public static int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);
//        return nums[nums.length-k];

        /* 小根堆的堆排序
        int len = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }
        for (int i = k; i < len; i++) {
            Integer minValue = minHeap.peek();
            if (nums[i] > minValue) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
        */

        // 快排思想
        int len = nums.length;
        int target = len -k;
        int left = 0;
        int right = len - 1;
        while (true) {
            int pivotIndex = partition(nums, left, right);
            if (pivotIndex == target) {
                return nums[pivotIndex];
            } else if (pivotIndex < target) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex -1;
            }
        }
    }

    public static int partition(int[] nums,int left, int right) {
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, randomIndex);
        int pivot = nums[left];
        int le = left +1;
        int ge = right;
        while (true) {
            while (le <=ge && nums[le] < pivot) {
                le++;
            }
            while (le <=ge && nums[ge] > pivot) {
                ge--;
            }
            if (le >= ge) {break;}
            swap(nums,le,ge);
            le++;
            ge--;
        }
        swap(nums,left,ge);
        return ge;
    }

    public static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
//        int[] nums = {3,2,1,5,6,4};
//        int k =2 ;

        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k =4 ;
        System.out.println(findKthLargest(nums, k));
    }
}
