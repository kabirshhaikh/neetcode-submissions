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
        if (root == null) {
            return true;
        }


        int leftTree = balanced(root.left);
        int rightTree = balanced(root.right);

        int diff = leftTree - rightTree; 

        if (Math.abs(diff) > 1) {
            return false;
        }

        boolean leftSubTree = isBalanced(root.left);
        boolean rightSubTree = isBalanced(root.right);

        if (leftSubTree == true && rightSubTree == true) {
            return true;
        }
        else {
            return false;
        }
    }

    public int balanced (TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = balanced(root.left);
        int right = balanced(root.right);

        return 1 + Math.max(left, right);
    }
}
