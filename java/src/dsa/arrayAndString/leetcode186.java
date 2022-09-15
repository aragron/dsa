package dsa.arrayAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class leetcode186 {

    public static void reverseWords(char[] s) {
        int len = s.length;
        ArrayList<String> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                list.add(builder.toString());
                builder = new StringBuilder();
            } else {
                builder.append(s[i]);
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
        System.arraycopy(chars, 0, s, 0, len);
    }


    public static void reverseWords2(char[] s) {
        int len = s.length;
        int low = 0,high = 1;

        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' '){
                swap(s, low, i-1);
                low = i+1;
            }
        }
        swap(s,low,len-1);
        swap(s,0,len-1);
    }

    public static void swap(char[] s, int left, int right){
        while (left <= right) {
            char tmp = s[right];
            s[right] = s[left];
            s[left] = tmp;
            right--;
            left++;
        }
    }


    public static void main(String[] args) {
        char[] s = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        reverseWords2(s);
        System.out.println(Arrays.toString(s));
    }
}
