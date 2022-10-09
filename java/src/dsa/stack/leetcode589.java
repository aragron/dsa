package dsa.stack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class leetcode589 {

    public List<Integer> preorder(Node root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null){return ret;}
        Deque<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node pop = stack.pop();
            ret.add(pop.val);
            List<Node> children = pop.children;
            int size = children.size();
            for (int i = size-1; i >= 0; i--) {
                stack.push(children.get(i));
            }
        }
        return ret;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
