package dsa.leetcode;

public class Quest5 {

    public static void main(String[] args) {

        String s = "babad";
        String longestPalindrome = longestPalindrome(s);
        System.out.println(longestPalindrome);
    }

    // 状态转移方程 s[i...j]
    // dp[i][j] = (s[i] == s[j]) && dp[i+1][j-1] && 3 < j-i

    /**
     * 5 最长回文字符串
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
