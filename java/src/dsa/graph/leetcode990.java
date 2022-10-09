package dsa.graph;

public class leetcode990 {
    int[] parent = new int[26];
    int[] rank = new int[26];
    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '='){
                int index1 = equation.charAt(0)-'a';
                int index2 = equation.charAt(3)-'a';
                union(index1,index2);
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1)=='!'){
                int index1 = equation.charAt(0)-'a';
                int index2 = equation.charAt(3)-'a';
                if (find(index1) == find(index2)){return false;}
            }
        }
        return true;
    }

    public int find( int index) {
        if (index == parent[index]) {
            return index;
        }
        return parent[index] = find(parent[index]);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }

}
