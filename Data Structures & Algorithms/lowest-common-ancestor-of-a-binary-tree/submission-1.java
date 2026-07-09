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

        //if ans from both null then return null:
        if (leftSubTreeResult == null && rightSubTreeResult == null) {
            return null;
        }
        //if left !=null and right is null then return left:
        else if (leftSubTreeResult != null && rightSubTreeResult == null) {
            return leftSubTreeResult;
        }
        //if left is null and right is not then reutrn right:
        else if (leftSubTreeResult == null && rightSubTreeResult != null) {
            return rightSubTreeResult;
        }
        //if both returned ans then current node is LCA so just return root:
        else {
            return root;
        }
    }
}