package dsa.stack;

import java.util.Arrays;

public class leetcode1008 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        int len = preorder.length;

        return helper(preorder,0,len-1);
    }

    public TreeNode helper(int[] preorder, int startIndex, int endIndex){

        if (startIndex > endIndex){return null;}

        int rootVal = preorder[startIndex];
        TreeNode root = new TreeNode(rootVal);
        if (startIndex == endIndex){return root;}
        if (rootVal>= preorder[endIndex]){
            root.right = null;
            root.left = helper(preorder,startIndex+1,endIndex);
        } else if (rootVal <= preorder[startIndex + 1]) {
            root.left = null;
            root.right = helper(preorder, startIndex+1, endIndex);
        } else {
            int rightStartIndex = -1-Arrays.binarySearch(preorder, startIndex + 1, endIndex, preorder[startIndex]);
            root.left = helper(preorder, startIndex+1,rightStartIndex-1);
            root.right = helper(preorder, rightStartIndex,endIndex);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3,1,2};
        leetcode1008 leetcode1008 = new leetcode1008();
        TreeNode treeNode = leetcode1008.bstFromPreorder(preorder);

        System.out.println(treeNode.left.right.val);
    }
}
