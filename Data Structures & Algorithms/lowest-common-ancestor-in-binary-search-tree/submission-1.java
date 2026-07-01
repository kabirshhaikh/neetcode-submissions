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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //bsae case: if root is null then we ran out of all nodes so just return null.
        if (root == null) {
            return null;
        }

        //if either p or q is found return root.
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode leftTree = lowestCommonAncestor(root.left, p, q);
        TreeNode rightTree = lowestCommonAncestor(root.right, p, q);

        if (leftTree == null && rightTree == null) {
            return null;
        }
        else if (leftTree != null && rightTree == null) {
            return leftTree;
        }
        else if (leftTree == null && rightTree != null) {
            return rightTree;
        }
        else {
            return root;
        }
    }

}
