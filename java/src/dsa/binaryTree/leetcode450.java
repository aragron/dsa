package dsa.binaryTree;

public class leetcode450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            if (root.val == key) {
                return null;
            } else {
                return root;
            }
        }
        TreeNode prev = new TreeNode(0);
        prev.left = root;
        helper(prev,0,root,key);
        return prev.left;
    }

    public void helper(TreeNode prev, int direction, TreeNode node, int key) {// direction 0表示左，1表示右
        if (node == null) {return;}
        if (node.val == key) {
            if (node.left == null && node.right == null) {
                // 目标节点没有后继节点
                if (direction == 0) {
                    prev.left = null;
                } else {
                    prev.right = null;
                }
            } else if (node.left == null) {
                // 目标只有右子节点
                if (direction == 0) {
                    prev.left = node.right;
                } else {
                    prev.right = node.right;
                }
            } else if (node.right == null) {
                // 目标只有左子节点
                if (direction == 0) {
                    prev.left = node.left;
                } else {
                    prev.right = node.left;
                }
            }else {
                //目标既有左子节点，也有右子节点
                //返回目标节点的右子树的最左边节点
                TreeNode findLastLeftNode = node.right;
                while (findLastLeftNode.left != null) {
                    findLastLeftNode = findLastLeftNode.left;
                }
                findLastLeftNode.left = node.left;
                if (direction == 0) {
                    prev.left = node.right;
                } else {
                    prev.right = node.right;
                }
            }
        }
        if (key < node.val) {
            helper(node,0,node.left,key);
        }else {
            helper(node,1,node.right,key);
        }
    }


    public static void main(String[] args) {

    }
}
