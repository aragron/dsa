package dsa.slidingWindowAndDoublePoint;

public class leetcode1358 {
    public static int numberOfSubstrings(String s) {
        char[] chars = s.toCharArray();
        return atMostKDistinct(chars,3) - atMostKDistinct(chars,2);
    }

    public static int atMostKDistinct(char[] A, int k){
        int len = A.length;
        int[] freq = new int[len+1];
        int res = 0;
        int count = 0;
        int left = 0, right = 0;

        while (right < len) {
            if (freq[A[right]-'a'] == 0) {
                count++;
            }
            freq[A[right]-'a']++;
            right++;

            while (count > k) {
                freq[A[left]-'a']--;
                if (freq[A[left]-'a'] == 0) {
                    count--;
                }
                left++;
            }
            res += right-left;
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "aaacb";
        System.out.println(numberOfSubstrings(s));
    }
}
