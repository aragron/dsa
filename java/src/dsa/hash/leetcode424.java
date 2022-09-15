package dsa.hash;

public class leetcode424 {

    public int characterReplacement(String s, int k) {
        int[] array = new int[26];
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int historyCharMax = 0;
        for (right = 0; right < chars.length; right++) {
            int index = chars[right] - 'A';
            array[index]++;
            historyCharMax = Math.max(historyCharMax, array[index]);
            if (right - left + 1 > historyCharMax + k) {
                array[chars[left] - 'A']--;
                left++;
            }
        }
        return chars.length - left;
    }

    public static void main(String[] args) {
        char b = 'B';
        char a = 'A';
        char x = 'X';
        char z = 'Z';
        System.out.println(a);
        System.out.println(z);
    }
}
