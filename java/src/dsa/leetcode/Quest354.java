package dsa.leetcode;

import java.util.Arrays;

public class Quest354 {
    public static void main(String[] args) {
        int[][] envelopes = {{5, 5}, {2, 4}, {6, 4}, {6, 7}, {2, 3}};

        int i = maxEnvelopes(envelopes);
        System.out.println(i);
    }

    public static int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }
        int n = envelopes.length;
        Arrays.sort(envelopes, (int[] o1, int[] o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });

        for (int[] envelope : envelopes) {
            System.out.println(Arrays.toString(envelope));
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if ( envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }


}
