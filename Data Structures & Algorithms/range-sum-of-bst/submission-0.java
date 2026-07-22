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
    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return sum;
    }

    public void dfs (TreeNode root, int low, int high) {
        //first base case:
        if (root == null) {
            return;
        }

        //if the current nodes val is between low and high then increment 
        //the sum:
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }

        //otherwise based on BST rule recurse left if nodes val is > low:
        //else recurse right if nodes val is less than high:
        //explore both the sides:
        if (root.val > low) dfs(root.left, low, high);
        if (root.val < high) dfs(root.right, low, high);
    }
}