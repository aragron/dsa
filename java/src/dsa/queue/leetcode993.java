package dsa.queue;

import java.util.Deque;
import java.util.LinkedList;

public class leetcode993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root.val == x || root.val == y) {
            return false;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode p1 = null;
        TreeNode p2 = null;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    if (poll.left.val == x ){
                        p1 = poll;
                    } else if (poll.left.val == y){
                        p2 = poll;
                    }
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    if (poll.right.val == x ){
                        p1 = poll;
                    } else if (poll.right.val == y){
                        p2 = poll;
                    }
                    queue.offer(poll.right);
                }
            }
            if (p1 != null || p2 != null){
                if (p1 == null || p2 == null){
                    return false;
                }
                return p1 != p2;
            }
        }
        return false;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
