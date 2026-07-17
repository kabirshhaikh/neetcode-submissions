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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        //base case:
        //if the root itself is null or after doing dfs we have reach null
        //then just return null:
        if (root == null) {
            return null;
        }

        //then we recurse left and right:
        //the root.left becomes whatever is returned from funtion down:
        root.left = removeLeafNodes(root.left, target);

        //the root.right becomes whatever is returned from function down:
        root.right = removeLeafNodes(root.right, target);

        //second base case:
        //if current node is leaf and matches target we delete and return null:
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }

        //if the current node is leaf and not target then return the root meaning current node:
        return root;
    }
}