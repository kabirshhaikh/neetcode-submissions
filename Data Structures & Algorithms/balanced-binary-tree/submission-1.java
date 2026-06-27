/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        int balancedAnswer = balanced(root);
        if (balancedAnswer == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    public static int balanced (TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftTree = balanced(root.left);
        int rightTree = balanced(root.right);

        if (leftTree == -1 || rightTree == -1) {
            return -1;
        }

        if (Math.abs(leftTree - rightTree) > 1) {
            return -1;
        }

        return 1 + Math.max(leftTree, rightTree);
    }
}
