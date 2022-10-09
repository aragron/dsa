package dsa.graph;

public class leetcode1319 {
    int count;
    public int makeConnected(int n, int[][] connections) {
        int len = connections.length;
        if (len+1<n){return -1;}
        count = n;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i]=i;
        }
        for (int[] connection : connections) {
            union(parent,connection[0],connection[1]);
        }
        return count-1;
    }

    public int find(int[] parent, int index){
        while (parent[index] != index){
            index = parent[index];
        }
        return index;
    }
    public void union(int[] parent, int index1, int index2){
        int p1 = find(parent,index1);
        int p2 = find(parent,index2);
        if (p1 == p2){return;}
        parent[find(parent,index1)] = find(parent,index2);
        count--;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] connections = {{0,1},{0,2},{0,3},{1,2},{1,3}};
        leetcode1319 leetcode1319 = new leetcode1319();
        int i = leetcode1319.makeConnected(n, connections);
        System.out.println(i);
    }
}
