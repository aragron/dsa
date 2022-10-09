package dsa.stack;

import java.util.Arrays;

public class leetcode684 {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] array = new int[n+1];
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
            if (array[edge[1]] >0){
                return edge;
            }
            array[edge[1]]++;
        }
        return new int[2];
    }

    public static void main(String[] args) {
        int[][] edges = {{1,4},{3,4},{1,3},{1,2},{4,5}};

        leetcode684 leetcode684 = new leetcode684();
        int[] redundantConnection = leetcode684.findRedundantConnection(edges);
        System.out.println(Arrays.toString(redundantConnection));
    }
}