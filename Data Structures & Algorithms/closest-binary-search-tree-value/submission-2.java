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
    double minDiff = Integer.MAX_VALUE;
    int closestVal = Integer.MAX_VALUE;

    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return 0;
        }

        double diff = Math.abs(target - root.val);
        if (diff < minDiff || (diff == minDiff && root.val < closestVal)) {
            closestVal = root.val;
            minDiff =  diff;
        }

        int leftTree = closestValue(root.left, target);
        int rightTree = closestValue(root.right, target);

        return closestVal;
    }
}
