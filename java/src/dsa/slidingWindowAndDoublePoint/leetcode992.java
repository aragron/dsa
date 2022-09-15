package dsa.slidingWindowAndDoublePoint;

public class leetcode992 {
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDistinct(nums,k) - atMostKDistinct(nums,k-1);
    }
    private static int atMostKDistinct(int[] A, int K) {
        int len = A.length;
        int[] freq = new int[len + 1];

        int left = 0, right = 0;
        // [left,right)中不同整数的个数
        int count = 0;
        int res = 0;

        while (right < len) {
            if (freq[A[right]] == 0) {
                count++;
            }
            freq[A[right]]++;
            right++;

            while (count > K) {
                freq[A[left]]--;
                if (freq[A[left]] == 0) {
                    count--;
                }
                left++;
            }
            // [left, right) 区间的长度就是对结果的贡献
            res += right-left;
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
