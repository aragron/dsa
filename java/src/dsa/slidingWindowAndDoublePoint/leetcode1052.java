package dsa.slidingWindowAndDoublePoint;

import java.util.Arrays;

public class leetcode1052 {

    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int len = grumpy.length;
        if (minutes >= len) {
            return Arrays.stream(customers).sum();
        }
        int left = 0;
        int maxCount = 0; // 连续不生气的时间段内的时候的最多的人
        int result = Integer.MIN_VALUE;
        int count = 0;
        for (int right = 0; right < len; right++) {
            count += customers[right] * (1-grumpy[right]);
            int lenContinue = right - left + 1;
            if (lenContinue < minutes) {
                maxCount += customers[right] * grumpy[right];
            } else if (lenContinue == minutes) {
                maxCount += customers[right] * grumpy[right];
                result = Math.max(result, maxCount);
                maxCount -= customers[left] * grumpy[left];
                left++;
            }
        }
        return count + result;
    }

    public static void main(String[] args) {
        int[] customers = {1,0,1,2,1,1,7,5}, grumpy = {0,1,0,1,0,1,0,1};
        int minutes = 3;
        System.out.println(maxSatisfied(customers, grumpy, minutes));
    }
}
