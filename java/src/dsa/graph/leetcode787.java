package dsa.graph;

import java.util.Arrays;

public class leetcode787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if (src == dst){return 0;}
        int[] previous = new int[n];
        int[] current = new int[n];
        for (int i = 0; i < n; i++) {
            previous[i] = Integer.MAX_VALUE;
            current[i] = Integer.MAX_VALUE;
        }
        previous[src] = 0;
        for (int i = 1; i < k+2; i++) {
            current[src] = 0;
            for (int[] flight: flights) {
                int previous_flight = flight[0];
                int current_flight = flight[1];
                int cost = flight[2];

                if (previous[previous_flight] < Integer.MAX_VALUE) {
                    current[current_flight] = Math.min(current[current_flight], previous[previous_flight]+cost);
                }
            }
            previous = current.clone();
            System.out.println(Arrays.toString(previous));
        }
        return current[dst] == Integer.MAX_VALUE ? -1 : current[dst];
    }

    public static void main(String[] args) {
        
//        int[][] edges = {{0,1,100},{1,2,100},{0,2,500}};
//        int n = 3;
//        int src = 0;
//        int dst = 2;
//        int k = 1;

//        int n = 4;
//        int src = 0;
//        int dst =3;
//        int k = 1;
//        int[][] edges = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};

//        int n = 4;
//        int[][] edges = {{0,1,1},{0,2,5},{1,2,1},{2,3,1}};
//        int src = 0;
//        int dst = 3;
//        int k = 1;
        int n = 5;
        //int[][] edges = {{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}};
        int[][] edges = {{0,4,5},{4,2,5},{0,3,2},{3,4,2},{4,1,1},{1,2,1}};
        int src = 0;
        int dst = 2;
        int k = 3;
        leetcode787 leetcode787 = new leetcode787();
        System.out.println(leetcode787.findCheapestPrice(n, edges, src, dst, k));
    }
}
