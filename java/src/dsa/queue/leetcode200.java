package dsa.queue;

import java.util.*;

public class leetcode200 {

    public static void bfs(char[][] grid, int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            i = cur[0];
            j = cur[1];
            if (0 <=i && i< grid.length && 0<=j && j< grid[0].length && grid[i][j]=='1') {
                grid[i][j]='0';
                queue.offer(new int[] { i + 1, j });
                queue.offer(new int[] { i - 1, j });
                queue.offer(new int[] { i, j + 1 });
                queue.offer(new int[] { i, j - 1 });
            }
        }
    }
    public static int numIslands(char[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid,i,j);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid));
    }
}
