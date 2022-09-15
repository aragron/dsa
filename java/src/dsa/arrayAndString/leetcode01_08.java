package dsa.arrayAndString;

import java.util.HashSet;

public class leetcode01_08 {

    public void setZeroes(int[][] matrix) {
        int len_m = matrix.length;
        int len_n = matrix[0].length;
        boolean[] rows_bool = new boolean[len_m];
        boolean[] columns_bool = new boolean[len_n];
        for (int i = 0; i < len_m; i++) {
            for (int j = 0; j < len_n; j++) {
                if (matrix[i][j] == 0) {
                    rows_bool[i] = true;
                    columns_bool[j] = true;
                }
            }
        }
        for (int i = 0; i < len_m; i++) {
            for (int j = 0; j < len_n; j++) {
                if (rows_bool[i] || columns_bool[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
