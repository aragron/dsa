package dsa.queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class leetcode934 {

    Queue<int[]> queue;
    Deque<int[]> stack;
    public static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int shortestBridge(int[][] grid) {
        queue = new LinkedList<>();
        stack = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int[] firstIslandStartPoint = new int[2];
        int flag = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    firstIslandStartPoint[0] = i;
                    firstIslandStartPoint[1] = j;
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                break;
            }
        }
        dfs(grid, firstIslandStartPoint);
        return bfs(grid);
    }

    public void dfs(int[][] grid, int[] point) {
        int m = grid.length;
        int n = grid[0].length;
        stack.push(point);
        grid[point[0]][point[1]] = 2;
        while (!stack.isEmpty()) {
            int[] p = stack.pop();
            int currR = p[0];
            int currC = p[1];
            for (int[] direction : DIRECTIONS) {
                int nextR = currR + direction[0];
                int nextC = currC + direction[1];
                if (nextR < 0 || nextC < 0 || nextR >= m || nextC >= n) {
                    continue;
                }
                if (grid[nextR][nextC] == 0) {
                    queue.offer(new int[]{nextR, nextC});
                    grid[nextR][nextC] = -1;
                }
                if (grid[nextR][nextC] == 1) {
                    stack.push(new int[]{nextR, nextC});
                    grid[nextR][nextC] = 2;
                }
            }
        }
    }

    public int bfs(int[][] grid) {
        int ret = 0;
        int m = grid.length;
        int n = grid[0].length;
        while (!queue.isEmpty()) {
            ret++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] p = queue.poll();
                int currR = p[0];
                int currC = p[1];
                for (int[] direction : DIRECTIONS) {
                    int nextR = currR + direction[0];
                    int nextC = currC + direction[1];
                    if (nextR < 0 || nextC < 0 || nextR >= m || nextC >= n || grid[nextR][nextC] == 2 || grid[nextR][nextC] == -1) {
                        continue;
                    }
                    if (grid[nextR][nextC] == 1) {
                        return ret;
                    }
                    if (grid[nextR][nextC] == 0) {
                        queue.offer(new int[]{nextR, nextC});
                        grid[nextR][nextC] = -1;
                    }
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        leetcode934 leetcode934 = new leetcode934();
        System.out.println(leetcode934.shortestBridge(grid));
    }
}
