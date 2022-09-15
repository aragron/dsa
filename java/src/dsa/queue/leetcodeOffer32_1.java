package dsa.queue;

import java.util.*;

public class leetcodeOffer32_1 {
    public int[] levelOrder(TreeNode root) {
        if (root == null){
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null){
                    queue.offer(poll.left);
                }
                if (poll.right != null){
                    queue.offer(poll.right);
                }
            }
        }
        int len = list.size();
        int[] ret = new int[len];
        for (int i = 0; i < len; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
    
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
