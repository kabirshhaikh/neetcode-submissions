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
    int count = 0;

    public int goodNodes(TreeNode root) {
        int maxSoFar = Integer.MIN_VALUE;
        dfs(root, maxSoFar); 
        return count;   
    }

    public void dfs (TreeNode root, int maxSoFar) {
        //first base case:
        if (root == null) {
            return;
        }

        //at each step we check if current nodes val >= maxSoFar
        // then increment the count:
        if (root.val >= maxSoFar) {
            count++;
        }

        //next step is the update the maxSoFar:
        maxSoFar = Math.max(maxSoFar, root.val);

        //then recurse left and right:
        dfs(root.left, maxSoFar);
        dfs(root.right, maxSoFar);
    }
}
