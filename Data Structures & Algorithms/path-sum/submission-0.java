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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //if reached root then that means this path for the node is does not sums up to target:
        if (root == null) {
            return false;
        }

        //if the root itself is leaf:
        if (root.left == null  && root.right == null && root.val == targetSum) {
            return true;
        }
        
        targetSum = targetSum - root.val;

        boolean leftTree = hasPathSum(root.left, targetSum);
        boolean rightTree = hasPathSum(root.right, targetSum);
       
       return leftTree || rightTree;
    }
}