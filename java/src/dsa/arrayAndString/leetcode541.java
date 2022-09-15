package dsa.arrayAndString;

public class leetcode541 {

    public static String reverseStr(String s, int k) {
        int len = s.length();
        int low = 0;
        char[] chars = s.toCharArray();
        while (low <= len - 1) {
            if (low + k - 1 <= len - 1) {
                swap(chars, low, low + k - 1);
                low = low + k * 2;
            } else if (low + k - 1 > len - 1) {
                swap(chars, low, len - 1);
                low = low + k * 2;
            }
        }
        return new String(chars);
    }

    public static void swap(char[] s, int left, int right) {
        while (left <= right) {
            char tmp = s[right];
            s[right] = s[left];
            s[left] = tmp;
            right--;
            left++;
        }
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseStr(s, k));
    }
}
