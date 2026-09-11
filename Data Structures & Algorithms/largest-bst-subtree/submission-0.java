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
    int max = 0;

    public int largestBSTSubtree(TreeNode root) {
        dfs(root);
        return max;    
    }

    public int[] dfs (TreeNode root) {
        //base case if root is null then return int[] of size 4, where 0th is 1 for true and -1 for false, size as 0 and min as Integer.MAX_VALUE, and max as Integer.MIN_VALUE:
        if (root == null) {
            int[] output = {1, 0, Integer.MAX_VALUE, Integer.MIN_VALUE};
            return output;
        }

        //otherwise i perform recursion first on both left and right:
        int[] leftTree = dfs(root.left);
        int[] rightTree = dfs(root.right);

        //now i extract values from leftTree and rightTree for comparision:
        int leftTreeIsValid = leftTree[0];
        int leftTreeSize = leftTree[1];
        int leftTreeMin = leftTree[2];
        int leftTreeMax = leftTree[3];

        int rightTreeIsValid = rightTree[0];
        int rightTreeSize = rightTree[1];
        int rightTreeMin = rightTree[2];
        int rightTreeMax = rightTree[3];

        //is leftTree or rightTree is -1 then return -1, size, min, max:
        if (leftTreeIsValid == -1 || rightTreeIsValid == -1) {
            int[] out = {-1, 0, 0,0};
            return out;
        }

        //now check if root.val > leftTReeMax and root.val < rightTree min:
        if (root.val <= leftTreeMax || root.val >= rightTreeMin) {
            return new int[] {-1, 0, 0, 0};
        }

        //else update:
        int size = leftTreeSize + rightTreeSize + 1;

        //now update the size of global max variable with max height of subtree:
        max = Math.max(max, size);

        //now return 1 as true and new size, also compare current nodes value and leftTreeMin for min and current nodes value and rightTreeMax for max:
        return new int[] {1, size, Math.min(leftTreeMin, root.val), Math.max(rightTreeMax, root.val)};
    }
}


// 8 -> [true, 1, min = 8, max = 8]
// 1 -> [true, 1, min = 1, max = 1] 

// both returned to 5:
// left [true, 1,1, 1]
// right [true, 1,8,8]

// is left valid yes and right valid yes 
// is max from left 1 < 5 yes min from right is > 5 yes 8 > 5
// update global subtree max size = leftsize + rightsize + 1

// so 5 returns [true, 3, 1, 8] to 10.

// 10 gets true from left and false from right so its not subtree,



