package dsa.hash;

import java.util.HashMap;
import java.util.Map;

public class leetcode205 {

    public static boolean isIsomorphic1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                if (!map.get(chars[i]).equals(chars1[i])) {
                    return false;
                }
            } else {
                map.put(chars[i], chars1[i]);
            }
        }
        return true;
    }
    public static boolean isIsomorphic(String s, String t) {
        return isIsomorphic1(s,t) && isIsomorphic1(t,s);
    }

    public static void main(String[] args) {
        String s = "badc", t = "baba";
        System.out.println(isIsomorphic(s, t));
    }
}
