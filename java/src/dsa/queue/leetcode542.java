package dsa.queue;

import java.util.*;

public class leetcode542 {

    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[]{1, 0},
            new int[]{-1, 0},
            new int[]{0, 1},
            new int[]{0, -1}
    );

    public int[][] updateMatrix(int[][] mat) {
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int row = mat.length;
        int column = mat[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (mat[i][j] == 0) {
                    String pos = i + ":" + j;
                    queue.offer(pos);
                    break;
                }
            }
            if (queue.size() > 0) {
                break;
            }
        }
        while (!queue.isEmpty()) {
            String pos = queue.poll();
            if (set.contains(pos)) {
                continue;
            }
            set.add(pos);
            String[] posArr = pos.split(":");
            int pr = Integer.parseInt(posArr[0]);
            int pc = Integer.parseInt(posArr[1]);
            int num = mat[pr][pc];
            for (int[] direction : DIRECTIONS) {
                int nextPr = pr + direction[0];
                int nextPc = pc + direction[1];
                String nextPox = nextPr + ":" + nextPc;

                if (nextPc < 0 || nextPr < 0 || nextPr >= row || nextPc >= column) {
                    continue;
                }
                if ("9:0".equals(nextPox)){
                    System.out.println(nextPox);
                }
                System.out.println(nextPox);
                if (mat[nextPr][nextPc] != 0) {
                    if (neighborIsZero(mat, nextPr, nextPc)) {
                        mat[nextPr][nextPc] = 1;
                    } else {
                         if (num + 1 < mat[nextPr][nextPc] || mat[nextPr][nextPc] == 1) {
                            mat[nextPr][nextPc] = num + 1;
                        }
                    }
                }
                queue.offer(nextPox);
            }
        }
        return mat;
    }

    public boolean neighborIsZero(int[][] mat, int pr, int pc) {
        int row = mat.length;
        int column = mat[0].length;
        for (int[] direction : DIRECTIONS) {
            int nextPr = pr + direction[0];
            int nextPc = pc + direction[1];
            if (nextPc < 0 || nextPr < 0 || nextPr >= row || nextPc >= column) {
                continue;
            }
            if (mat[nextPr][nextPc] == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //int{}{} mat = {{0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}};
        //int{}{} mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] mat = {{1, 0, 1, 1, 0, 0, 1, 0, 0, 1},{0, 1, 1, 0, 1, 0, 1, 0, 1, 1},{0, 0, 1, 0, 1, 0, 0, 1, 0, 0},{
        1, 0, 1, 0, 1, 1, 1, 1, 1, 1},{0, 1, 0, 1, 1, 0, 0, 0, 0, 1},{0, 0, 1, 0, 1, 1, 1, 0, 1, 0},{
        0, 1, 0, 1, 0, 1, 0, 0, 1, 1},{1, 0, 0, 0, 1, 1, 1, 1, 0, 1},{1, 1, 1, 1, 1, 1, 1, 0, 1, 0},{
        1, 1, 1, 1, 0, 1, 0, 0, 1, 1}};
        leetcode542 leetcode542 = new leetcode542();
        int[][] ints = leetcode542.updateMatrix(mat);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }
}
