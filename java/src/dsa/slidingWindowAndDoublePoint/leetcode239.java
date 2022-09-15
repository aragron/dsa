package dsa.slidingWindowAndDoublePoint;

import java.util.*;

public class leetcode239 {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] ans = new int[len - k + 1];
        Deque<Integer> pq = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            while (!pq.isEmpty() && nums[pq.peekLast()] <= nums[i]) {
                pq.pollLast();
            }
            pq.offerLast(i);
            while (pq.peekFirst() <= i-k){
                pq.pollFirst();
            }
            if (i >= k-1) {
                ans[i-k+1] = nums[pq.peekFirst()];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7}; int k = 3;
        int[] ints = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ints));
    }
}
