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
    int res=0;

    public int diameterOfBinaryTree(TreeNode root) {
    maxHeight(root);
    return res;
    }

    public int maxHeight(TreeNode root){
        if(root==null){return 0;}
        TreeNode left = root.left;
        int l = maxHeight(left);
        if(l==-1){return -1;}
        TreeNode right = root.right;
        int r = maxHeight(right);
        if(r==-1){return -1;}
        res = Math.max(res, l+r);
        return Math.max(l,r)+1;

    }

    
}
