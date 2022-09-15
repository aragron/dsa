package dsa.stack;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode112 {
    public boolean hasPathSum_1(TreeNode root, int sum) {
        if (root == null){return false;}
        Queue<TreeNode> qNode = new LinkedList<>();
        Queue<Integer> vNode = new LinkedList<>();
        qNode.offer(root);
        vNode.offer(root.val);

        while (!qNode.isEmpty()){
            TreeNode currNode = qNode.poll();
            Integer currValue = vNode.poll();
            if (currNode.left == null && currNode.right == null) {
                if (currValue == sum){return true;}
                continue;
            }
            if (currNode.left != null) {
                qNode.offer(currNode.left);
                vNode.offer(currNode.left.val + currValue);
            }
            if (currNode.right != null) {
                qNode.offer(currNode.right);
                vNode.offer(currNode.right.val + currValue);
            }
        }
        return false;
    }


    /**
     * DFS
     * @param root
     * @param sum
     * @return
     */
   public boolean hasPathSum(TreeNode root, int sum){
       if(root == null){
           return false;
       }
       if(root.left == null && root.right == null){
           return root.val == sum;
       }
       return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
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
