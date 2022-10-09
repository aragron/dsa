package dsa.graph;

import java.util.*;

public class leetcode210 {

    // 存储有向图
    List<List<Integer>> edges;
    // 存储每个节点的入度
    int[] indeg;
    // 存储答案
    int[] result;
    // 答案下标
    int index;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 节点i的入度节点
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        indeg = new int[numCourses];
        result = new int[numCourses];
        index = 0;
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            ++indeg[info[0]];
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i]==0){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            // 从队首取出一个节点
            int u = queue.poll();
            // 放入答案中
            result[index++] = u;
            for (int v: edges.get(u)) {
                --indeg[v];
                // 如果相邻节点 v 的入度为 0，就可以选 v 对应的课程了
                if (indeg[v] == 0) {
                    queue.offer(v);}}}

        if (index != numCourses) {
            return new int[0];
        }
        return result;
    }



    public static void main(String[] args) {
        leetcode210 leetcode210 = new leetcode210();
        int numCourses = 2;
        int[][] prerequisites = {{1,0},{0,1}};
        int[] ints = leetcode210.findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(ints));
    }
}
