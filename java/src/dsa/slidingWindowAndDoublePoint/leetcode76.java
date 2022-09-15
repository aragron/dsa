package dsa.slidingWindowAndDoublePoint;

import java.util.HashSet;

public class leetcode76 {
    public static String minWindow(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int[] tCharsCount = new int[58];
        for (char tChar : tChars) {
            int c = tChar - 'A';
            tCharsCount[c]++;
        }
        int distance = 0;
        for (int i = 0; i < 58; i++) {
            if (tCharsCount[i] > 0) {
                distance++;
            }
        }

        int[] sCharsCount = new int[58];
        int low = 0, high;
        int resultLow = 0, resultHigh = 0;
        int len = sChars.length;
        int result = Integer.MAX_VALUE;
        int count = 0;
        int match = 0;
        for (high = 0; high < len; high++) {
            int c = sChars[high] - 'A';
            if (tCharsCount[c] == 0) {
                continue;
            }
            sCharsCount[c]++;
            if (sCharsCount[c] == tCharsCount[c]) {
                match++;
            }
            while (low <= high && match == distance) {
                count = high - low + 1;
                if (result > count) {
                    result = count;
                    resultLow = low;
                    resultHigh = high;
                }
                int lowC = sChars[low] - 'A';
                if (tCharsCount[lowC] == 0) {
                    ++low;
                    continue;
                }
                if (sCharsCount[lowC] <= tCharsCount[lowC]) {
                    break;
                } else if (sCharsCount[lowC] > tCharsCount[lowC]) {
                    sCharsCount[lowC]--;
                    ++low;
                }
            }
        }
        return count == 0 ? "" : s.substring(resultLow, resultHigh + 1);
    }

    public static void main(String[] args) {
        //String s = "ADOBECODEBANC", t = "ABC";
        String s = "a", t = "a";
        String minWindow = minWindow(s, t);
        System.out.println(minWindow);
    }
}
