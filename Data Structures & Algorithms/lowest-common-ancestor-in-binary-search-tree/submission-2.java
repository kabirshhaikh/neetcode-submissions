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
        //base case:
        //if we reached null then that means p or q was not found:
        if (root == null) {
            return null;
        }

        //if curr node is p or q then return that root node:
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        //both p and q smaller than current node then go left:
        if (p.val < root.val && q.val < root.val) {
            //dfs go deep left:
            return lowestCommonAncestor(root.left, p, q);
        }
        //if both p and q greater than current node go right:
        else if (p.val > root.val && q.val > root.val) {
            //dfs go deep right:
            return lowestCommonAncestor(root.right, p, q);
        }
        //if p and q are on different sides then that mean 
        //current node is the LCA, return root:
        else {
            return root;
        }
    }
}
