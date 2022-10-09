package dsa.stack;

public class leetcode129 {
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }

    public int helper(TreeNode node , int sum){
        int left = 0;
        int right = 0;
        int nextSum = sum * 10 + node.val;
        if (node.left == null && node.right == null) {return nextSum;}

        if (node.left != null){
            left = helper(node.left, nextSum);
        }
        if (node.right != null) {
            right = helper(node.right, nextSum);
        }
        return left+right;
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
