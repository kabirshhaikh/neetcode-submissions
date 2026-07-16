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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //if root is null create new node and return that node:
        if (root == null) {
            return new TreeNode(val);
        }

        //at each step check if val greater or smaller than current node's val:
        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }
        else {
            root.left = insertIntoBST(root.left, val);
        }

        //in the end we return the root as it has link with subtree that is returned from the function which was called:
        return root;
    }
}