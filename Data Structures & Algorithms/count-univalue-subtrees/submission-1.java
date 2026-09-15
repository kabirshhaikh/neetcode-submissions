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

//  so this problem requires dfs.
//  i will define a global variable count.
//  i will run a dfs method in countUnivalSubtrees
//  and after dfs is done i will return the count variable.


class Solution {
    int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        dfs(root);
        return count;    
    }

    public boolean dfs (TreeNode root) {
        //first base case: if root is null return true:
        if (root == null) {
            return true;
        }

        //recursion left and right:
        boolean left = dfs(root.left);
        boolean right = dfs(root.right);

        //checks to make sure current value matches left and right children value:
        if (root.left != null && root.val != root.left.val) {
            return false;
        }

        if (root.right != null && root.val != root.right.val) {
            return false;
        }

        if (left && right) {
            count++;
        }

        return left && right;
    }
}
