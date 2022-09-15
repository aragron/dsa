package dsa.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class leetcode202 {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while ( n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    public int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            sum += d * d;
        }
        return sum;
    }

    public static void main(String[] args) {
        int num = 19;
        String s = "" + num;
        char[] chars = s.toCharArray();
        System.out.println(Arrays.toString(chars));
    }
}
