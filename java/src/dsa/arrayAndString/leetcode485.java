package dsa.arrayAndString;

public class leetcode485 {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int len = nums.length;
        int slow = 0;
        int maxSeriesOneCount = 0;
        for (int fast = 0; fast < len; fast++) {
            if (nums[fast] != 1) {
                maxSeriesOneCount = Math.max(maxSeriesOneCount,fast-slow);
                slow = fast+1;
            }
        }
        if (nums[len-1] == 1) {
            maxSeriesOneCount = Math.max(maxSeriesOneCount,len - slow);
        }
        return maxSeriesOneCount;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
