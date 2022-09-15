package dsa.hash;

import java.util.Arrays;
import java.util.HashSet;

public class leetcode36 {

    public static boolean isValidSudoku(char[][] board) {


        // (row/3)*3 + column/3, (row%3)*3 + column%3
        char[][] reversalBoard = new char[9][9];
        char[][] sudokuBoard = new char[9][9];
        for (int i = 0; i < 9; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char aChar = board[i][j];
                reversalBoard[j][i] = aChar;
                sudokuBoard[(i / 3) * 3 + j / 3][(i % 3) * 3 + j % 3] = aChar;
                if (aChar != '.') {
                    if (set.contains(aChar)) {
                        return false;
                    } else {
                        set.add(aChar);
                    }
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char aChar = reversalBoard[i][j];
                if (aChar != '.') {
                    if (set.contains(aChar)) {
                        return false;
                    } else {
                        set.add(aChar);
                    }
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char aChar = sudokuBoard[i][j];
                if (aChar != '.') {
                    if (set.contains(aChar)) {
                        return false;
                    } else {
                        set.add(aChar);
                    }
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        char[][] board =
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        char[][] board2 =
                 {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

//        char num = board[0][2];
//        System.out.println(num);
//        int value = Integer.parseInt(String.valueOf(num));
//        System.out.println(value);
        //System.out.println(isValidSudoku(board));
        boolean validSudoku = isValidSudoku(board);
        System.out.println(validSudoku);

        boolean validSudoku2 = isValidSudoku(board2);
        System.out.println(validSudoku2);

    }
}
