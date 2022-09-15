package dsa.queue;

import java.util.*;

public class leetcode130 {
    Queue<int[]> queue;
    public static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void bfs(char[][] board, int[][] ret, int[] startPoint){
        int m = board.length;
        int n = board[0].length;

        queue.offer(startPoint);
        ret[startPoint[0]][startPoint[1]] = 1;
        while (!queue.isEmpty()){
            int[] currPoint = queue.poll();
            for (int[] direction : DIRECTIONS) {
                int nextR = currPoint[0] + direction[0];
                int nextC = currPoint[1] + direction[1];
                if (nextR < 0 || nextC < 0 || nextR >= m || nextC >= n || ret[nextR][nextC] == 1) {
                    continue;
                }
                if (board[nextR][nextC] == 'O'){
                    queue.offer(new int[]{nextR,nextC});
                    ret[nextR][nextC] = 1;
                }
            }
        }
    }

    public void solve(char[][] board) {
        queue = new LinkedList<>();
        int m = board.length;
        int n = board[0].length;
        int[][] ret = new int[m][n];
        List<int[]> startArea = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                startArea.add(new int[]{i, 0});
            }
            if (board[i][n-1] == 'O') {
                startArea.add(new int[]{i, n-1});
            }
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                startArea.add(new int[]{0, j});
            }
            if (board[m-1][j] == 'O') {
                startArea.add(new int[]{m-1, j});
            }
        }
        //System.out.println(startArea.size());
        for (int i = 0; i < startArea.size(); i++) {
            System.out.println(i);
            int[] startPoint = startArea.get(i);
            System.out.println(Arrays.toString(startPoint));
            bfs(board,ret,startPoint);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ret[i][j] == 0 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }


    public static void main(String[] args) {
//        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        char[][] board = {{'O','O','O'},{'O','O','O'},{'O','O','O'}};
        leetcode130 leetcode130 = new leetcode130();
        leetcode130.solve(board);
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }

    }
}
