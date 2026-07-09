/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case:
        // meaning if we reach null that means we didnt find either p or q:
        if (root == null) {
            return null;
        }

        // if root is not null then check for either p or q at current node:
        if (root.val == p.val || root.val == q.val) {
            return root; // meaning either p or q is found so return its val:
        }

        // dfs on left and right from current level:
        TreeNode leftSubTreeResult = lowestCommonAncestor(root.left, p, q);
        TreeNode rightSubTreeResult = lowestCommonAncestor(root.right, p, q);

        if (leftSubTreeResult == null && rightSubTreeResult == null) {
            return null;
        } else if (leftSubTreeResult != null && rightSubTreeResult == null) {
            return leftSubTreeResult;
        } else if (leftSubTreeResult == null && rightSubTreeResult != null) {
            return rightSubTreeResult;
        } else {
            return root;
        }
    }
}