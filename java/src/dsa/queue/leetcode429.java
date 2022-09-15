package dsa.queue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class leetcode429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null){return ret;}
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                list.add(poll.val);
                List<Node> children = poll.children;
                if (children.size() > 0){
                    queue.addAll(children);
                }
            }
            ret.add(list);
        }
        return ret;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
