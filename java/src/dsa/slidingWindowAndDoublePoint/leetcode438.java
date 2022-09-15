package dsa.slidingWindowAndDoublePoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode438 {
    public static List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> list = new ArrayList<>();
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        int len = sChars.length;
        int pLen = pChars.length;
        if (pLen > len) {
            return list;
        }
        int[] pArray = new int[26];
        for (char pChar : pChars) {
            int c = pChar - 'a';
            pArray[c]++;
        }
        int[] sArray = new int[26];
        int left = 0, right = 0;
        while ( right <= len) {
            if (right < len && right - left + 1 <= pLen) {
                sArray[sChars[right] - 'a']++;
                right++;
            }
            if (right - left + 1 > pLen) {
                if (Arrays.equals(pArray,sArray)) {
                    list.add(left);
                };
                sArray[sChars[left]-'a']--;
                left++;
            }
            if (right == len) {break;}
        }
        return list;
    }

    public static void main(String[] args) {
        String s = "abab", p = "ab";
        List<Integer> list = findAnagrams(s, p);
        System.out.println(list);
    }
}
