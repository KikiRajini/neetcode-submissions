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

    public int maxDepth(TreeNode root) {
    if(root==null){return 0;}
        TreeNode left = root.left;
        TreeNode right = root.right;

       
            int left1= maxDepth(left);
           

           int right1=  maxDepth(right);
      
        
        return Math.max(right1,left1) +1;
    }
}
