package dsa.array;

import java.util.HashSet;

public class leetcode345 {

    public static String reverseVowels(String s) {
        StringBuilder builder = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int len = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (set.contains(Character.toLowerCase(chars[i]))) {
                builder.append(chars[i]);
            }
        }
        builder.reverse();
        int p1 = 0;
        for (int i = 0; i < chars.length; i++) {
            if (set.contains(Character.toLowerCase(chars[i]))) {
                chars[i] = builder.charAt(p1++);
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "aA";
        System.out.println(reverseVowels(s));
    }
}
