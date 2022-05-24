package dsa.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Quest873 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 11, 12, 14, 18};
        int i = lenLongestFibSubseq(arr);
        System.out.println(i);
    }

    public static int lenLongestFibSubseq(int[] arr) {
        int length = arr.length;
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        int ans = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int x = arr[j], y = arr[i] + arr[j];
                int N = 2;
                while (set.contains(y)) {
                    int tmp = y;
                    y = y + x;
                    x = tmp;
                    ans = Math.max(ans, ++N);
                }
            }
        }
        return ans >= 3 ? ans : 0;
    }

    public static int lenLongestFibSubseq2(int[] arr) {
        int length = arr.length;
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < length; i++) {
            index.put(arr[i], i);
        }
        Map<Integer, Integer> longest = new HashMap<>();
        int ans = 0;

        /**
         * longest[j, k] = longest[i, j] + 1
         * arr[i] + arr[j] = arr[k]
         */
        for (int k = 0; k < length; ++k) {
            for (int j = 0; j < k; ++j) {
                int i = index.getOrDefault(arr[k] - arr[j], -1);
                if (i >= 0 && i < j) {
                    // Encoding tuple (i, j) as integer (i * N + j) 简单理解为length进制，防止出现重复数字
                    int cand = longest.getOrDefault(i * length + j, 2) + 1;
                    longest.put(j * length + k, cand);
                    ans = Math.max(ans, cand);
                }
            }
        }
        return ans >= 3 ? ans : 0;
    }
}
