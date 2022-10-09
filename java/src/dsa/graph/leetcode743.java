package dsa.graph;

import java.util.*;

public class leetcode743 {
    public int networkDelayTime(int[][] times, int n, int k) {

        final int INF = Integer.MAX_VALUE / 2;
        // 邻接矩阵
        int[][] g = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(g[i], INF);
        }
        for (int[] t : times) {
            int x = t[0] - 1, y = t[1] - 1;
            g[x][y] = t[2];
        }

        int[] dist = new int[n];
        Arrays.fill(dist,INF);
        dist[k-1] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(k-1);
        while (!queue.isEmpty()) {
            int s = queue.poll();
            for (int i = 0; i < n; i++) {
                if (g[s][i] == INF){continue;}
                int len = g[s][i];
                if (dist[s] + len < dist[i] || dist[i] == -1) {
                    dist[i] = dist[s] + len;
                    queue.offer(i);
                }
            }
        }
        System.out.println(Arrays.toString(dist));
        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == INF ? -1 : ans;
    }


    public static void main(String[] args) {
        leetcode743 leetcode743 = new leetcode743();
        int n = 3, k = 2;
        int[][] times = {{1, 2, 1}, {2, 3, 7}, {1, 3, 4}, {2, 1, 2}};
        System.out.println(leetcode743.networkDelayTime(times, n, k));
    }
}
