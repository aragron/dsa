package dsa.binaryTree;

import java.util.HashMap;
import java.util.Map;

public class leetcode105 {

    int[] p;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = inorder.length;
        for (int i = 0; i < length; i++) {
            map.put(inorder[i], i);
        }
        p = preorder;
        return helper(0, length - 1, 0, length - 1);
    }

    public TreeNode helper(int inorderStart, int inorderEnd, int preorderStart, int preorderEnd) {
        if (inorderStart > inorderEnd || preorderStart > preorderEnd) {
            return null;
        }
        int rootVal = p[preorderStart];
        TreeNode node = new TreeNode(rootVal);
        Integer indexOfRootOnInorder = map.get(rootVal);
        // indexOfRootOnInorder-1-inorderStart+1 [start,end]
        node.left = helper(inorderStart, indexOfRootOnInorder - 1,
                preorderStart + 1, preorderStart + 1 + indexOfRootOnInorder - inorderStart -1);

        node.right = helper(indexOfRootOnInorder + 1, inorderEnd,
                preorderStart + 1 + indexOfRootOnInorder - inorderStart -1 + 1, preorderEnd);
        return node;
    }
}
