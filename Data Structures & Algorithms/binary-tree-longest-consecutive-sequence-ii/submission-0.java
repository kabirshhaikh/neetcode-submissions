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
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        dfs(root);

        return max;
    }

    public int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[] {0,0};
        }

        int inc = 1;
        int dec = 1;

        int[] leftResult = dfs(root.left);
        int[] rightResult = dfs(root.right);

        if (root.left != null && root.left.val == root.val + 1) {
            //meaning left extends increasing:
            inc = leftResult[0] + 1;
        }

        if (root.left != null && root.left.val == root.val - 1) {
            //left extends decreasing:
            dec = leftResult[1] + 1;
        }

        if (root.right != null && root.right.val == root.val + 1) {
            //right extends increasing:
            inc = Math.max(inc, rightResult[0] + 1);
        }

        if (root.right != null && root.right.val == root.val - 1) {
            //right extends decreasing:
            dec = Math.max(dec, rightResult[1] + 1);
        }

        max = Math.max(max, inc + dec - 1);

        return new int[]{inc, dec};
    }
}
