package dsa.arrayAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class leetcode151 {

    public static String reverseWords2(String s) {
        int len = s.length();
        ArrayList<String> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ' && builder.length() > 0) {
                list.add(builder.toString());
                builder = new StringBuilder();
            } else {
                char c = s.charAt(i);
                if (c != ' '){
                    builder.append(s.charAt(i));
                }
            }
        }
        list.add(builder.toString());
        Collections.reverse(list);
        char[] chars = new char[len];
        Arrays.fill(chars,' ');
        int offsite = 0;
        for (int i = 0; i < list.size(); i++) {
            char[] array = list.get(i).toCharArray();
            int length = array.length;
            System.arraycopy(array, 0, chars, offsite, length);
            offsite += length + 1;
        }
        return new String(chars).trim();
    }


    public static String reverseWords(String s) {
        s = s.trim();
        String[] strings = s.split("\\s+");
        List<String> list = Arrays.asList(strings);
        Collections.reverse(list);
        return String.join(" ", list);
    }
    public static void main(String[] args) {
        String s = "a good   example";
        String s1 = reverseWords(s);
        System.out.println(s1);
    }
}
