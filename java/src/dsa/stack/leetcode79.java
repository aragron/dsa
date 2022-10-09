package dsa.stack;

import java.util.ArrayList;
import java.util.List;

public class leetcode79 {
    final static int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] visited;
    int rowLen ;
    int columnLen ;
    char[][] board;
    char[] wordArray;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.rowLen = board.length;
        this.columnLen = board[0].length;
        int wordLen = word.length();
        if (rowLen * columnLen < wordLen) {return false;}
        this.visited = new boolean[rowLen][columnLen];
        this.wordArray = word.toCharArray();
        char startC = wordArray[0];

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < columnLen; j++) {
                if (board[i][j] == startC){
                    visited[i][j]=true;
                    boolean dfs = dfs(i,j,1);
                    if (dfs){return true;}
                    visited[i][j]=false;
                }
            }
        }
        return false;
    }

    public boolean dfs(int rowIndex, int colIndex, int count){
        int wordLen = wordArray.length;
        if (count == wordLen){return true;}
        char c = wordArray[count];
        List<int[]> neighbors = neighbors(rowIndex, colIndex);
        if (neighbors.size()==0){return false;}
        for (int[] neighbor : neighbors) {
            int newRow = neighbor[0];
            int newCol = neighbor[1];
            if (visited[newRow][newCol]){continue;}
            if (board[newRow][newCol] == c){
                visited[newRow][newCol]=true;
                boolean dfs = dfs(newRow, newCol, count + 1);
                if (!dfs){
                    visited[newRow][newCol]=false;
                }else {return true;}
            }
        }
        return false;
    }

    public List<int[]> neighbors( int rowIndex, int colIndex) {
        List<int[]> neighbors = new ArrayList<>();
        for (int[] direction : DIRECTIONS) {
            int row = rowIndex + direction[0];
            int col = colIndex + direction[1];
            if (row < 0 || col < 0 || row >= rowLen || col >= columnLen) {
                continue;
            }
            int[] pos = new int[2];
            pos[0] = row;
            pos[1] = col;
            neighbors.add(pos);
        }
        return neighbors;
    }

    public static void main(String[] args) {
        leetcode79 leetcode79 = new leetcode79();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCB";
        System.out.println(leetcode79.exist(board, word));
    }
}
