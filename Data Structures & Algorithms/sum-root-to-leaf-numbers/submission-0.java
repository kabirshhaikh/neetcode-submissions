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
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, "");
        return sum;
    }

    public void dfs (TreeNode root, String path) {
        //if a root before was not leaf and now upon reching down is null:
        //then return:
        if (root == null) {
            return;
        }
        
        //base case: if current node is leaf then record ans and return:
        if (root.left == null && root.right == null) {
            String currentPath = path + root.val;
            sum += Integer.parseInt(currentPath);
            return;
        }

        //String constructed path:
        String currentPath = path + root.val;

        //pass the state down:
        dfs(root.left, currentPath);
        dfs(root.right, currentPath);
    }
}