package dsa.binaryTree;

public class leetcode700 {
    public static TreeNode searchBST(TreeNode root, int val) {
        TreeNode node = root;
        if (node == null) {
            return null;
        }
        if (node.val == val) {
            return node;
        } else if (val < node.val) {
            node = searchBST(node.left, val);
        } else {
            node = searchBST(node.right, val);
        }
        return node;
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

        TreeNode bst = searchBST(four, 2);
        System.out.println(bst.val);
    }
}
