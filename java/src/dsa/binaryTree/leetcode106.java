package dsa.binaryTree;

import java.util.HashMap;

public class leetcode106 {

    HashMap<Integer,Integer> inorderArrayMap = new HashMap<>();
    int[] post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0;i < inorder.length; i++) {
            inorderArrayMap.put(inorder[i], i);
        }

        post = postorder;
        TreeNode root = helper(0, inorder.length - 1, 0, post.length - 1);
        return root;
    }
    public TreeNode helper(int inorderStart, int inorderEnd, int postorderStart, int postorderEnd) {
        if(inorderEnd < inorderStart || postorderEnd < postorderStart) {return null;}

        int root = post[postorderEnd];
        int rootIndexInInorderArray = inorderArrayMap.get(root);

        TreeNode node = new TreeNode(root);
        node.left = helper(inorderStart, rootIndexInInorderArray - 1, postorderStart, postorderStart + rootIndexInInorderArray - inorderStart - 1);
        node.right = helper(rootIndexInInorderArray + 1, inorderEnd, postorderStart + rootIndexInInorderArray - inorderStart, postorderEnd - 1);
        return node;
    }


}
