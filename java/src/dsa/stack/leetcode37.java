package dsa.stack;

import java.util.Arrays;

public class leetcode37 {

    char[] chars;
    public void solveSudoku(char[][] board) {
        this.chars = new char[9];
        for (int i = 0; i < this.chars.length; i++) {
            this.chars[i] = (char) ('1' + i);
        }
        dfs(board,0);
    }

    public boolean dfs(char[][] board, int index) {
        if (index >= 81) {return true;}
        int row = index / 9;
        int column = index % 9;
        if (board[row][column] != '.'){
            return dfs(board, index + 1);
        }else {
            for (char c : chars) {
                boolean verifyNum = verifyNum(board, c, row, column);
                if (verifyNum){
                    board[row][column]=c;
                    boolean dfs = dfs(board, index + 1);
                    if (!dfs){board[row][column]='.';}
                    if (dfs){return true;}
                }
            }
            return false;
        }
    }

    public boolean rowVerify(char[][] board, char value, int row) {
        for (char c : board[row]) {
            if (c == value) {
                return false;
            }
        }
        return true;
    }

    public boolean columnVerify(char[][] board, char value, int column) {
        int length = board.length;
        for (int i = 0; i < length; i++) {
            if (board[i][column] == value) {
                return false;
            }
        }
        return true;
    }

    public boolean boxVerify(char[][] board, char value, int row, int column) {
        int r = row / 3;
        int c = column / 3;
        for (int i = r * 3; i < (r + 1) * 3; i++) {
            for (int j = c * 3; j < (c + 1) * 3; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean verifyNum(char[][] board, char value, int row, int column) {
        boolean rowVerify = rowVerify(board, value, row);
        boolean columnVerify = columnVerify(board, value, column);
        boolean boxVerify = boxVerify(board, value, row, column);
        return rowVerify && columnVerify && boxVerify;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        leetcode37 leetcode37 = new leetcode37();
        leetcode37.solveSudoku(board);
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }

    }
}
