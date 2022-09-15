package dsa.slidingWindowAndDoublePoint;

public class leetcode340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        if (n <= k) {return n;}

        char[] chars = s.toCharArray();
        int left = 0;
        int count = 0;
        int[] array = new int[128];
        for (int right = 0; right < n; right++) {
            int c = chars[right];
            array[c]++;

            if (array[c] == 1){
                count++;
            }

            if (count > k) {
                int leftC = chars[left];
                if (array[leftC] == 1) {
                    count--;
                }
                array[leftC]--;
                left++;
            }
        }
        return n-left;
    }
    public static void main(String[] args) {
        System.out.println((int)'z');
    }
}
