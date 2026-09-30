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
    //this is my global variable which i will return in the end:
    double output = 0;

    public double maximumAverageSubtree(TreeNode root) {
        //here i call my dfs method which will perform recursion:
        dfs(root);
        return output;
    }

    //here i am gonna write logic of my dfs method:
    //the return type if int[]:
    public int[] dfs (TreeNode root) {
        //first base case:
        if (root == null) {
            //if the root is null return an int[] array with two values 0,0:
            return new int[]{0,0};
        }

        //after that perform recursion on both left and right subtree:
        int[] leftTree = dfs(root.left);
        int[] rightTree = dfs(root.right);

        //now calculate sum:
        int sum = root.val + leftTree[0] + rightTree[0];

        //count the nodes to calculate average:
        int countOfNodes = 1 + leftTree[1] + rightTree[1];

        //now calculate the average:
        double average = (double) sum / countOfNodes;

        //now update the global variable:
        output = Math.max(output, average);

        //now return updated array to the calling fucntion in recursion stack:
        return new int[] {sum, countOfNodes};
    }
}

//so here i am gonna use dfs.
//i will define a global variable (output) for output which will hold the max average subtree.
//dfs recursion -> return type int[where 0th index is sum, 1st index is the number of nodes].
//base case: if a root == null -> return new int[0,0].
//then perform dfs on left and right:
//leftTree[] answer.
//rightTree[] answer.
//int sumOfSubTress = currentNodes.val + leftTree[0] + rightTree[0] / leftTree[1] + rightTree[1];
//output = Math.max(output, sumOfSubTrees);
//return [currentNodes.val + leftTree[0] + rightTree[0], 1 + leftTree[1] + rightTree[1]];