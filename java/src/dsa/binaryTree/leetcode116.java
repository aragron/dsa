package dsa.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

class leetcode116 {

    Queue<Node> queue = new LinkedList<>();

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        queue.offer(root);
        helper(1);
        return root;
    }

    public void helper(int levelCount) {
        Node start = queue.poll();
        if (start == null) {
            return;
        }
        int nextLevelCount = 0;
        int count = levelCount;
        count--;
        if (start.left != null) {
            queue.offer(start.left);
            nextLevelCount++;
        }
        if (start.right != null) {
            queue.offer(start.right);
            nextLevelCount++;
        }
        while (!queue.isEmpty() && count >= 0) {
            if (count == 0) {
                start.next = null;
                break;
            }
            Node poll = queue.poll();
            if (poll.left != null) {
                queue.offer(poll.left);
                nextLevelCount++;
            }
            if (poll.right != null) {
                queue.offer(poll.right);
                nextLevelCount++;
            }
            start.next = poll;
            start = start.next;
            count--;
        }
        if (!queue.isEmpty()) {
            helper(nextLevelCount);
        }
    }
}
