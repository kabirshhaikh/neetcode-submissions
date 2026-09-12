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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        boolean output = dfs(root1, target, root2);
        return output;
    }

    public boolean dfs (TreeNode root, int target, TreeNode root2) {
        //base case1: if root is null then return false:
        if (root == null) {
            return false;
        }

        //perform binary search tree in root2 for this node:
        int valToFind = target - root.val;

        boolean ans = bst(root2, valToFind);

        if (ans) {
            return true;
        }

        //otherwise recursion on left and right:
        boolean leftTree = dfs(root.left, target, root2);
        boolean rightTree = dfs(root.right, target, root2);

        //return true if either leftTree is true or rightTree is true:
        return leftTree || rightTree;
    }

    public boolean bst (TreeNode root, int val) {
        //base case 1: if root is null then return false:
        if (root == null) {
            return false;
        }

        //if current nodes val == val then return true:
        if (root.val == val) {
            return true;
        }

        if (root.val < val) {
            return bst(root.right, val);
        }
        else {
            return bst(root.left, val);
        }
    }
}
