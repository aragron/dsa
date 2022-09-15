package dsa.queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class leetcode695 {

    Deque<int[]> q;
    public static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int area = 0;
        q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    area = Math.max(area,bfs(grid,i,j));
                }
            }
        }
        return area;
    }

    public int bfs(int[][] grid, int i, int j){
        if (grid[i][j] != 1){return 0;}
        int m = grid.length;
        int n = grid[0].length;
        int area = 1;
        grid[i][j] = -1;
        q.offer(new int[]{i,j});
        while (!q.isEmpty()){
            int[] point = q.poll();
            for (int[] direction : DIRECTIONS) {
                int x = point[0]+direction[0];
                int y = point[1]+direction[1];
                if (x < 0 || y < 0 || x>= m || y >= n){
                    continue;
                }
                if ( grid[x][y] == 1){
                    ++area;
                    grid[x][y] = -1;
                    q.offer(new int[]{x,y});
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        leetcode695 leetcode695 = new leetcode695();
        System.out.println(leetcode695.maxAreaOfIsland(grid));
    }
}
