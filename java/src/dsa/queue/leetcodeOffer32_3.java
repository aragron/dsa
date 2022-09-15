package dsa.queue;

import java.util.*;

public class leetcodeOffer32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null){
            return ret;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()){
            ++level;
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.right != null){
                    queue.offer(poll.right);
                }
                if (poll.left != null){
                    queue.offer(poll.left);
                }
            }
            if (level%2==1){
                Collections.reverse(list);
            }
            ret.add(list);
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
