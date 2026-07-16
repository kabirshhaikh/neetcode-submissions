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
    public TreeNode deleteNode(TreeNode root, int key) {
        // if the key is not found meaning we reached end where root == null
        // so we return null in that case:
        if (root == null) {
            return null;
        }

        // if we found the key and if that key is leaf then delete that key:
        if (root.val == key && root.left == null && root.right == null) {
            return null; // because it detaches the node from parent:
        }

        // two if condtions for cases when node has either left or right child:
        if (root.val == key && root.left == null) {
            return root.right;
        }

        if (root.val == key && root.right == null) {
            return root.left;
        }

        // now third case, if we founf the key and its not leaf then we need to
        // find inorder succssor meaning smallest node in right subtree:
        if (root.val == key) {
            // here i define a temp node:
            TreeNode temp = root.right;

            // i write a for loop until it reaches its right most
            // smallest node:
            while (temp.left != null) {
                temp = temp.left;
            }

            // once while loop is over it points at the inorder successor:
            root.val = temp.val;

            //at this point duplicate node is still there in right subtree:
            //so i call deleteNode again and it will hit either case 1 or 2:
            root.right = deleteNode(root.right, temp.val); //her i delete successor:

            //after deleting i return the root with modified node:
            return root;
        }

        // recurse on both left and right based on BST:
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }

        // here i return current root to calling function:
        // this root will have subtree with performed operation:
        return root;
    }
}