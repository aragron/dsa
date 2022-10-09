package dsa.stack;

import java.util.*;

public class leetcode323 {

    Queue<Integer> queue = new LinkedList<>();
    int[] arrayAll;
    public int countComponents(int n, int[][] edges) {
        arrayAll = new int[n];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            arrayAll[x]++;
            arrayAll[y]++;

            Set<Integer> s1 = map.getOrDefault(x, new HashSet<>());
            s1.add(y);
            map.put(x,s1);
            Set<Integer> s2 = map.getOrDefault(y, new HashSet<>());
            s2.add(x);
            map.put(y,s2);
        }
        int count = 0;
        int countSingle = 0;
        for (int i = 0; i < n; i++) {
            if (arrayAll[i] == 0) {
                countSingle++;
            }
        }
        System.out.println(Arrays.toString(arrayAll));
        for (int i = 0; i < n; i++) {
            if (arrayAll[i] > 0) {
                dfs(map,i);
                count++;
            }
        }
        return count+countSingle;
    }

    public void dfs(Map<Integer, Set<Integer>> map, int startValue){
        arrayAll[startValue] =  0;
        Set<Integer> set = map.get(startValue);
        for (int p : set) {
            if (arrayAll[p] > 0){
                dfs(map,p);
            }
        }
    }

    public void bfs(Map<Integer, Set<Integer>> map, int startValue){
        queue.offer(startValue);
        while (!queue.isEmpty()){
            int pop = queue.poll();
            Set<Integer> ps = map.get(pop);
            arrayAll[pop] = 0;
            for (int p : ps) {
                if (arrayAll[p] > 0) {
                    queue.offer(p);
                }
            }
        }
    }



    public static void main(String[] args) {
        int  n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        leetcode323 leetcode323 = new leetcode323();
        int i = leetcode323.countComponents(n, edges);
        System.out.println(i);
    }
}
