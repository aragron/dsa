package dsa.arrayAndString;

import java.util.Arrays;

public class leetcode344 {
    public static void reverseString(char[] s) {
        int len =  s.length;
        int low = 0, high = len -1;
        while (low <= high){
            char tmp = s[high];
            s[high--] = s[low];
            s[low++] = tmp;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        System.out.println(Arrays.toString(s));;

    }
}
