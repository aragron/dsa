package dsa.stack;

import java.util.*;

public class leetcode107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<List<Integer>> stack = new LinkedList<>();
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null){return ret;}
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            stack.push(list);
        }
        while (!stack.isEmpty()){
            ret.add(stack.pop());
        }
        return ret;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
