package dsa.binaryTree;

public class leetcode701 {

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        System.out.println(root.val);
        if (val < root.val) {
            helper(root, root.left, val);
        } else if (val > root.val) {
            helper(root, root.right, val);
        }
        return root;
    }
    public static void helper(TreeNode pre, TreeNode node, int val) {
        if (node == null) {
            node = new TreeNode(val);
            if (val < pre.val) {
                pre.left = node;
                return;
            } else if (val > pre.val){
                pre.right = node;
                return;
            }
        }
        if (val < node.val) {
            helper(node, node.left, val);
        } else if (val > node.val){
            helper(node, node.right, val);
        }
    }

    public static void main(String[] args) {
        TreeNode four = new TreeNode(4);
        TreeNode two = new TreeNode(2);
        TreeNode one = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        TreeNode seven = new TreeNode(7);

        four.left = two;
        two.left = one;
        two.right = three;
        four.right = seven;

        TreeNode treeNode = insertIntoBST(four, 5);

    }
}
