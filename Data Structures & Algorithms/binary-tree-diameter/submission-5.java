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
    int maxD =0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){return 0;}
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        maxD = Math.max(left+right,maxD);
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return maxD;
    }

    public int maxDepth(TreeNode root){
      if(root==null){ return 0;}
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
      
    }
} 

