package dsa.slidingWindowAndDoublePoint;

import java.util.Arrays;

public class leetcode567 {
    public static boolean checkInclusion(String s1, String s2) {
        int lenS2 = s2.length();
        int lenS1 = s1.length();
        if (lenS2 < lenS1) {return false;}

        int[] arrayS1 = new int[26];
        int[] arrayS2 = new int[26];
        char[] chars = s1.toCharArray();
        for (char aChar : chars) {
            int c = aChar - 'a';
            arrayS1[c]++;
        }

        char[] charsS2 = s2.toCharArray();

        int left = 0;
        for (int right = 0; right < lenS2; right++) {
            int len = right-left+1;
            arrayS2[charsS2[right]-'a']++;
            if (len == lenS1) {
                if (Arrays.equals(arrayS1,arrayS2)) {
                    return true;
                }
                arrayS2[charsS2[left]-'a']--;
                left++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidboooo";
        System.out.println(checkInclusion(s1, s2));
    }
}
