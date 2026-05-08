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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // base case:
        if (p == null && q == null) {
            return true;
        }

        // case when either p has value and q is null or q has value and p is null:
        // so in that case return false:
        if (p == null || q == null) {
            return false;
        }

        // if p.val is not equal to q.val then return false:
        if (p.val != q.val) {
            return false;
        }

        boolean leftSame = isSameTree(p.left, q.left);
        boolean rightSame = isSameTree(p.right, q.right);

        if (leftSame == true && rightSame == true) {
            return true;
        } else {
            return false;
        }
    }
}
