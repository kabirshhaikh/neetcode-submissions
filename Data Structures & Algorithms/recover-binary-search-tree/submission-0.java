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
    TreeNode first = null;
    TreeNode second = null;
    TreeNode previous = null;
    
    public void recoverTree(TreeNode root) {
        dfs(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void dfs (TreeNode root) {
        //base case: if root is null then just return from there:
        if (root == null) {
            return;
        }

        //to follow inorder traversal: left root right:
        //first explore left:
        dfs(root.left);

        //now root:
        //if the previous is greater than current then thats the occurrence of swap:
        if (previous != null && previous.val > root.val) {
           if (first == null) {
            first = previous;
           }

           second = root;
        }

        //now set previous to root:
        previous = root;

        //now explore right:
        dfs(root.right);
    }
}