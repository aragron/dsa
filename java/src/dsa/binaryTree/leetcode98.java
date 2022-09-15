package dsa.binaryTree;

import java.util.Deque;
import java.util.LinkedList;

public class leetcode98 {
    public boolean isValidBST(TreeNode root) {
        TreeNode node = root;
        Deque<TreeNode> stack = new LinkedList<>();
        long inorder = Long.MIN_VALUE;

        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (node.val <= inorder) {return false;}
            inorder = node.val;
            node = node.right;
        }
        return true;
    }


}
