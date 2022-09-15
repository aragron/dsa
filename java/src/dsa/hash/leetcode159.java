package dsa.hash;

import java.util.HashMap;
import java.util.HashSet;

public class leetcode159 {

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() <= 2) {
            return s.length();
        }
        int left = 0, right = 0;
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (right = 0; right < chars.length; right++) {
            char rChar = chars[right];
            if (map.containsKey(rChar)) {
                Integer count = map.get(rChar);
                map.put(rChar, count + 1);
            } else {
                map.put(rChar, 1);
            }
            if (map.size() > 2) {
                char lChar = chars[left];
                Integer integer = map.get(lChar);
                if (integer == 1) {
                    map.remove(lChar);
                }else {
                    map.put(lChar, integer-1);
                }
                left++;
            }
        }
        return chars.length-left;
    }

    public static void main(String[] args) {
        String s = "abcabcabc";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s));
    }
}
