package dsa.slidingWindowAndDoublePoint;

import java.util.HashMap;

public class leetcode159 {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if (n <= 2) {return n;}
        char[] chars = s.toCharArray();
        int left = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < n; right++) {
            int c = chars[right] - 'A';
            Integer orDefault = map.getOrDefault(c, 0);
            map.put(c, ++orDefault);

            if (map.size() > 2) {
                int leftC = chars[left] - 'A';
                Integer integer = map.get(leftC);
                if (integer == 1) {
                    map.remove(leftC);
                } else {
                    map.put(leftC,--integer);
                }
            }
        }
        return n-left;
    }

    public static void main(String[] args) {
        System.out.println( 'z' - 'a');
        System.out.println('z' - 'A');
    }
}
