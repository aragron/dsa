package dsa.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class leetcode529 {

    Queue<int[]> queue;
    public static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        queue = new LinkedList<>();
        int row = click[0];
        int column = click[1];
        if (board[row][column] == 'M') {
            board[row][column] = 'X';
            return board;
        }
        if (board[row][column] == 'E') {
            char assign = assign(board, row, column);
            board[row][column] = assign;
            if (assign == 'B') {
                bfs(board, click);
            }
        }
        return board;
    }

    public void bfs(char[][] board, int[] click) {
        int m = board.length;
        int n = board[0].length;
        queue.offer(click);
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int currRow = point[0];
            int currColumn = point[1];
            if (board[currRow][currColumn] != 'B') {continue;}
            for (int[] direction : DIRECTIONS) {
                int nextRow = currRow + direction[0];
                int nextColumn = currColumn + direction[1];

                if (nextRow < 0 || nextColumn < 0 || nextRow >= m || nextColumn >= n || board[nextRow][nextColumn] != 'E') {
                    continue;
                }
                char assign = assign(board, nextRow, nextColumn);
                board[nextRow][nextColumn] = assign;
                queue.offer(new int[]{nextRow, nextColumn});
            }
        }
    }

    public char assign(char[][] board, int row, int column) {
        int count = 0;
        int m = board.length;
        int n = board[0].length;
        for (int[] direction : DIRECTIONS) {
            int nextRow = row + direction[0];
            int nextColumn = column + direction[1];
            if (nextRow < 0 || nextColumn < 0 || nextRow >= m || nextColumn >= n || board[nextRow][nextColumn] != 'M'){
                continue;
            }
            count++;
        }
        if (count > 0) {
            return  (char) (count+ '0') ;
        } else {
            return  'B';
        }
    }

    public static void main(String[] args) {
        leetcode529 leetcode529 = new leetcode529();
        char[][] board = {{'E','E','E','E','E'},{'E','E','M','E','E'},{'E','E','E','E','E'},{'E','E','E','E','E'}};
        int[] click = {3,0};
        char[][] chars = leetcode529.updateBoard(board, click);
        for (char[] aChar : chars) {
            System.out.println(Arrays.toString(aChar));
        }
    }
}
