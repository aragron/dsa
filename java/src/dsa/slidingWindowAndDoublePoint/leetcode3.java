package dsa.slidingWindowAndDoublePoint;

import java.util.HashSet;

public class leetcode3 {
    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len < 2) {return len;}
        char[] chars = s.toCharArray();
        int[] freq = new int[128];
        int low = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int high = 0; high < len; high++) {
            int c = chars[high];
            freq[c]++;
            if (freq[c] > 1) {
                set.add(c);
            }
            if (low <= high && set.size() > 0) {
                int lowC = chars[low];
                freq[lowC]--;
                if (freq[lowC] <= 1) {
                    set.remove(lowC);
                }
                low++;
            }
        }
        return len-low;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
