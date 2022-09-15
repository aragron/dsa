package dsa.slidingWindowAndDoublePoint;

public class leetcode424 {
    public static int characterReplacement(String s, int k) {
        int len = s.length();
        if (len < 2) {
            return len;
        }
        int[] freq = new int[26];
        char[] chars = s.toCharArray();
        int left = 0, right = 0;
        int maxCount = Integer.MIN_VALUE;

        while (right < len) {
            int c = chars[right] -'A';
            freq[c]++;
            maxCount = Math.max(maxCount, freq[c]);

            if ( maxCount + k < right -left + 1) {
                int lowC = chars[left]-'A';
                freq[lowC]--;
                left++;
            }
            right++;
        }
        return len-left;
    }
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        int i = characterReplacement(s, k);
        System.out.println(i);
    }
}
