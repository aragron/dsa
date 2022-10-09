package dsa.graph;

import java.util.*;

public class leetcode399 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationsSize = equations.size();
        UnionFind unionFind = new UnionFind(2 * equationsSize);
        // 1 预处理
        Map<String, Integer> map = new HashMap<>(2 * equationsSize);
        int id = 0;
        for (int i = 0; i < equationsSize; i++) {
            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);
            if (!map.containsKey(var1)) {
                map.put(var1, id);
                id++;
            }
            if (!map.containsKey(var2)) {
                map.put(var2, id);
                id++;
            }
            unionFind.union(map.get(var1), map.get(var2), values[i]);
        }
        // 2 查询
        int queriesSize = queries.size();
        double[] res = new double[queriesSize];
        for (int i = 0; i < queriesSize; i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);
            Integer id1 = map.get(var1);
            Integer id2 = map.get(var2);
            if (id1 == null || id2 == null) {
                res[i] = -1.0;
            } else {
                res[i] = unionFind.isConnected(id1, id2);
            }
        }
        return res;
    }


    public class UnionFind {
        int parent[];
        double[] weight;
        // 添加了 rank 数组来记录每个顶点的高度，也就是每个顶点的「秩」

        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d; // 一开始每个顶点的初始「秩」为1，因为它们只有自己本身的一个顶点。
            }
        }

        // 此处的 find 函数与路径压优化缩版本的 find 函数一样。
        public int find(int x) {
            if (x != parent[x]) {
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        // 按秩合并优化的 union 函数
        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
                weight[rootX] = weight[y] * value / weight[x];
            }
        }
        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY){
                return weight[x]/weight[y];
            } else {
                return -1.0d;
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        equations.add(list);
        List<String> list2 = new ArrayList<>();
        list2.add("b");
        list2.add("c");
        equations.add(list2);

        double[] values = {2.0,3.0};
        //String[][] queries = {{"a","c"},{"b","a"},{"a","e"},{"a","a"},{"x","x"}};
        List<List<String>> queries = new ArrayList<>();
        List<String> q1 = new ArrayList<>();
        q1.add("a");
        q1.add("c");
        queries.add(q1);
        List<String> q2 = new ArrayList<>();
        q2.add("b");
        q2.add("a");
        queries.add(q2);

        leetcode399 leetcode399 = new leetcode399();
        double[] doubles = leetcode399.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(doubles));
    }
}
