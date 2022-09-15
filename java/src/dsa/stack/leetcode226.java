package dsa.stack;

public class leetcode226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null ){return root;}
        if (root.left== null && root.right == null){return root;}

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);
        return root;
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
