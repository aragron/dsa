package dsa.stack;

public class leetcode695 {
    final static int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == 1) {
                    int area = area(grid, i, j, 0);
                    result = Math.max(area, result);
                }
            }
        }
        return result;
    }

    public int area(int[][] grid, int row, int col, int v) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        if (grid[row][col] != 1) {
            return v;
        }
        grid[row][col]++;
        v++;
        for (int[] direction : DIRECTIONS) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];
            if (nextRow < 0 || nextCol < 0 || nextRow >= rowLen || nextCol >= colLen) {
                continue;
            }
            int area = area(grid, nextRow, nextCol, 0);
            v += area;
        }
        return v;
    }

    public static void main(String[] args) {
        leetcode695 leetcode695 = new leetcode695();
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        int area = leetcode695.maxAreaOfIsland(grid);
        System.out.println(area);
    }
}
