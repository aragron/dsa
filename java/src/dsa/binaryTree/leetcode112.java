package dsa.binaryTree;

public class leetcode112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null ) {
            return false;
        }
        if (root.right == null && root.left == null ) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public static void main(String[] args) {

    }
}
