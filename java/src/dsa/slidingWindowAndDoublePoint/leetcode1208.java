package dsa.slidingWindowAndDoublePoint;

public class leetcode1208 {
    public static int equalSubstring(String s, String t, int maxCost) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int len = s.length();
        int[] array = new int[len];
        int left = 0;
        int sum = 0;
        int maxLength = 0;
        for (int right = 0; right < len; right++) {
            int c = Math.abs(sChars[right] - tChars[right]);
            array[right] = c;
            sum += c;
            while (left < right && sum > maxCost) {
                sum -= array[left];
                left++;
            }
            if (sum <= maxCost) {
                maxLength = Math.max(maxLength, right-left+1);
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {
        String s = "abcd", t = "bcdf";
        int maxCost = 3;
        System.out.println(equalSubstring(s, t, maxCost));
    }
}
