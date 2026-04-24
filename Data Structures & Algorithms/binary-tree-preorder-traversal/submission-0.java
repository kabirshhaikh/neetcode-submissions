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
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        //first visit yourself:
        List<Integer> output = new ArrayList<>();
        output.add(root.val);

        //then traverse left:
        List<Integer> left = preorderTraversal(root.left);

        //then traverse right:
        List<Integer> right = preorderTraversal(root.right);

        output.addAll(left);
        output.addAll(right);

        return output;
    }
}