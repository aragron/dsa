package dsa.queue;

import java.util.*;

public class leetcode417 {

    public static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        int[] pRet = new int[m * n];
        int[] aRet = new int[m * n];

        for (int i = 0; i < m; i++) {
            helper(heights, i, 0, m, n, pRet);
        }
        for (int j = 0; j < n; j++) {
            helper(heights, 0, j, m, n, pRet);
        }

        for (int i = 0; i < m; i++) {
            helper(heights, i, n - 1, m, n, aRet);
        }
        for (int j = 0; j < n; j++) {
            helper(heights, m - 1, j, m, n, aRet);
        }
        for (int i = 0; i < m * n; i++) {
            if (pRet[i] == 1 && aRet[i] == 1) {
                int pr = i / n;
                int pc = i % n;
                List<Integer> list = new ArrayList<>();
                list.add(pr);
                list.add(pc);
                result.add(list);
            }
        }

        return result;
    }

    public void helper(int[][] heights, int i, int j, int row, int column, int[] ret) {
        // row = m, column = n
        //i * m + n
        Deque<Integer> queue = new LinkedList<>();
        ret[i * column + j] = 1;
        //visited[i * column + j] = 1;
        queue.offer(i * column + j);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            int curR = poll / column;
            int curC = poll % column;
            //visited[poll] = 1;
            for (int[] direction : DIRECTIONS) {
                int nextR = curR + direction[0];
                int nextC = curC + direction[1];
                int nextP = nextR * column + nextC;
                if (nextR < 0 || nextC < 0 || nextR >= row || nextC >= column || ret[nextP] == 1) {
                    continue;
                }
                if (heights[curR][curC] <= heights[nextR][nextC]) {
                    queue.offer(nextP);
                    //visited[nextP] = 1;
                    ret[nextP] = 1;
                }
            }
        }
    }
}
