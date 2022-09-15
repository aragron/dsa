package dsa.queue;

import java.util.Arrays;

public class leetcode733 {


    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if (oldColor == color) {
            return image;
        }

        bfs(image, sr, sc, color, oldColor);
        return image;
    }

    public void bfs(int[][] image, int i, int j, int color, int oldColor) {

        int row = image.length;
        int column = image[0].length;
        if (i < 0 || j < 0 || j >= column || i >= row) {
            return;
        }
        if (image[i][j] != oldColor) {
            return;
        }
        if (image[i][j] == oldColor) {
            image[i][j] = color;
        }
        bfs(image, i - 1, j, color, oldColor);
        bfs(image, i + 1, j, color, oldColor);
        bfs(image, i, j - 1, color, oldColor);
        bfs(image, i, j + 1, color, oldColor);
    }

    public static void main(String[] args) {
        leetcode733 fun = new leetcode733();
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int newColor = 2;
        int[][] ints = fun.floodFill(image, sr, sc, newColor);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }
}
