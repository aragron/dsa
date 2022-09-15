package dsa.stack;

import java.util.*;

public class leetcode133 {
    Map<Integer,Node> map;

    public Node cloneGraph(Node node) {
        if (node == null){
            return null;
        }
        map = new HashMap<>();
        Node ret = new Node(node.val, new ArrayList<>());
        dfs(node, ret);
        return ret;
    }

    public void dfs(Node src, Node target) {
        List<Node> neighbors = src.neighbors;
        for (Node neighbor : neighbors) {
            List<Node> targetNeighbors = target.neighbors;
            Node nx;
            if (map.containsKey(neighbor.val)) {
                nx = map.get(neighbor.val);
            } else {
                nx = new Node(neighbor.val, new ArrayList<>());
            }
            targetNeighbors.add(nx);
            target.neighbors = targetNeighbors;
            map.put(target.val, target);
            if (!map.containsKey(neighbor.val)){
                dfs(neighbor, nx);
            }
        }
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
