package dsa.binaryTree;

public class leetcode235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val|| root.val == q.val) {
            return root;
        }
        while (root != null) {
            if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else {
                break;
            }
        }
        return root;
    }

}
