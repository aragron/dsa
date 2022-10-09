package dsa.graph;

import java.util.*;

public class leetcode1584 {

    public int minCostConnectPoints_prim(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int size = points.length;
        int[] visited = new int[size];
        Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x.cost));
        int ret = 0;
        int count = size - 1;
        for (int j = 1; j < size; j++) {
            int[] coordinate1 = points[0];
            int[] coordinate2 = points[j];
            int cost = Math.abs(coordinate1[0] - coordinate2[0]) + Math.abs(coordinate1[1] - coordinate2[1]);
            Edge edge = new Edge(0, j, cost);
            queue.add(edge);
        }
        visited[0]++;
        while (!queue.isEmpty() && count > 0) {
            Edge edge = queue.poll();
            //int p1 = edge.point1;
            int p2 = edge.point2;
            int cost = edge.cost;
            if (visited[p2] == 0) {
                ret += cost;
                visited[p2]++;
                for (int j = 0; j < size; j++) {
                    if (visited[j] == 0) {
                        int distance = Math.abs(points[p2][0] - points[j][0])
                                + Math.abs(points[p2][1] - points[j][1]);
                        queue.add(new Edge(p2, j, distance));
                    }
                }
                count--;
            }
        }
        return ret;
    }

    public int minCostConnectPoints_kruskal(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int size = points.length;
        Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x.cost));
        UnionFind unionFind = new UnionFind(size);
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int[] coordinate1 = points[i];
                int[] coordinate2 = points[j];
                int cost = Math.abs(coordinate1[0] - coordinate2[0]) + Math.abs(coordinate1[1] - coordinate2[2]);
                Edge edge = new Edge(i, j, cost);
                queue.add(edge);
            }
        }

        int ret = 0;
        int count = size - 1;
        while (!queue.isEmpty() && count > 0) {
            Edge e = queue.poll();
            if (!unionFind.connected(e.point1, e.point2)) {
                unionFind.union(e.point1, e.point2);
                ret += e.cost;
                count--;
            }
        }
        return ret;
    }

    class Edge {
        int point1;
        int point2;
        int cost;

        Edge(int point1, int point2, int cost) {
            this.point1 = point1;
            this.point2 = point2;
            this.cost = cost;
        }
    }

    public class UnionFind {
        int root[];
        // 添加了 rank 数组来记录每个顶点的高度，也就是每个顶点的「秩」
        int rank[];
        int count;

        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            count = size;
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1; // 一开始每个顶点的初始「秩」为1，因为它们只有自己本身的一个顶点。
            }
        }

        // 此处的 find 函数与路径压优化缩版本的 find 函数一样。
        public int find(int x) {
            if (x == root[x]) {
                return x;
            }
            return root[x] = find(root[x]);
        }

        // 按秩合并优化的 union 函数
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
                count--;
            }
        }

        int getCount() {
            return count;
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        leetcode1584 leetcode1584 = new leetcode1584();
        System.out.println(leetcode1584.minCostConnectPoints_prim(points));
    }
}
