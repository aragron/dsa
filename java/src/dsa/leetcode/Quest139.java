package dsa.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Quest139 {
    public static void main(String[] args) throws InterruptedException {
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");

        boolean b = wordBreak(s, wordDict);
        System.out.println(b);
    }

    // 单词拆分
    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        Set<String> wordSet = new HashSet<>(wordDict);
        for (int lo = 0; lo < n; lo++) {
            for (int hi = lo + 1; hi <= n; hi++) {
                String substring = s.substring(lo, hi);
                if (dp[lo] && wordSet.contains(substring)) {
                    dp[hi] = true;
                }
            }
        }
        return dp[n];
    }

    public static boolean wordBreak2(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int lo = 0; lo < n; lo++) {
            if (!dp[lo]) continue;

            for (String word : wordDict) {
                int hi = lo + word.length();
                if (hi <= n && s.substring(lo, hi).equals(word)) {
                    dp[hi] = true;
                }
            }
        }
        return dp[n];
    }
}
