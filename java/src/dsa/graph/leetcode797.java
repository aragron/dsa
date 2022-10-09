package dsa.graph;

import java.util.*;

public class leetcode797 {
    List<List<Integer>> ans = new ArrayList<>();
    List<List<Integer>> ans2 = new ArrayList<>();
    Deque<Integer> stack = new ArrayDeque<>();

    Queue<List<Integer>> queue = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        stack.offerLast(0);
        dfs(graph,0, graph.length-1);

        bfs(graph,0, graph.length-1);
        return ans;
    }

    public void dfs(int[][] graph, int x, int n) {
        if (x == n){
            ans2.add(new ArrayList<>(stack));
            return;
        }
        for (int y : graph[x]) {
            stack.offerLast(y);
            dfs(graph,y,n);
            stack.pollLast();
        }
    }

    public void bfs(int[][] graph, int start , int end) {
        List<Integer> path = new ArrayList<>();
        path.add(start);
        queue.offer(path);
        while (!queue.isEmpty()){
            List<Integer> currPath = queue.poll();
            int node = currPath.get(currPath.size()-1);
            for (int nextNode : graph[node]) {
                List<Integer> tmpPath = new ArrayList<>(currPath);
                tmpPath.add(nextNode);
                if (nextNode == end){
                    ans.add(new ArrayList<>(tmpPath));
                } else {
                    queue.add(new ArrayList<>(tmpPath));
                }
            }
        }
    }
}
