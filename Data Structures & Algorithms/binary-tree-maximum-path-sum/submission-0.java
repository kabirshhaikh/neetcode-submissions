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
    int maxPath = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);

        return maxPath;    
    }

    public int dfs (TreeNode root) {
        //if the root is null we return 0:
        if (root == null) {
            return 0;
        }

        //then we recurse left and right:
        int leftTree = dfs(root.left);
        int rightTree = dfs(root.right);

        //since the answer returned from leftTree and rightTree can be
        //negative, I do max of leftTree and rightTree with 0:
        leftTree = Math.max(0, leftTree);
        rightTree = Math.max(0, rightTree);

        //now with whatever ans we got from left and right we use that
        //to measure maxPath so far:
        maxPath = Math.max(maxPath, (root.val + leftTree + rightTree));

        return root.val + Math.max(leftTree, rightTree);
        // 1
        //  2 (l)
        //  3 (r)

        //  2 0 and 0 
        //    null(l)
        //    null(r)
    }
}
