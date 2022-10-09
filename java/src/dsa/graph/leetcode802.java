package dsa.graph;

import java.util.*;

public class leetcode802 {
    Boolean[] visited;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int len = graph.length;
        visited = new Boolean[len];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (dfs(graph,i)){
                continue;
            }
            list.add(i);
        }
        return list;
    }

    // 判断是否有环
    public boolean dfs(int[][] graph, int start){
        if (visited[start] != null){
            return visited[start];
        }
        visited[start] = true;
        for (int next : graph[start]) {
            if (dfs(graph,next)){
                return true;
            }
        }
        visited[start]=false;
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        leetcode802 leetcode802 = new leetcode802();
        int[][] graph = {{},{0,2,3,4},{3},{4},{}};
        List<Integer> list = leetcode802.eventualSafeNodes(graph);
        System.out.println(list);
    }
}
