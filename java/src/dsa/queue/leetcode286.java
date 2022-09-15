package dsa.queue;

import java.util.*;

public class leetcode286 {


    public static void main(String[] args) {
        int[][] rooms = {{2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0,-1,2147483647,2147483647}
        };
        leetcode286 leetcode286 = new leetcode286();
        leetcode286.wallsAndGates(rooms);
        int row = rooms.length;
        int column = rooms[0].length;
        List<int[]> gates = new ArrayList<>();
        //记录门的位置
        for (int i = 0; i < row; i++) {
            int[] rows = rooms[i];
            System.out.println(Arrays.toString(rows));
        }
    }

    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[] { 1,  0},
            new int[] {-1,  0},
            new int[] { 0,  1},
            new int[] { 0, -1}
    );
    public  void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> q = new LinkedList<int[]>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == GATE) {
                    q.add(new int[]{i, j});
                }
            }
        }
        if (q.size() == 0) {
            return;
        }
        System.out.println(q.size());
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int row = point[0];
            int col = point[1];
            for (int[] direction : DIRECTIONS) {
                int r = row + direction[0];
                int c = col + direction[1];
                if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY) {
                    continue;
                }
                rooms[r][c] = rooms[row][col] + 1;
                q.add(new int[] { r, c });
            }
        }
    }
}
