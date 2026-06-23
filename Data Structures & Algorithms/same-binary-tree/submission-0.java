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
    public boolean isSameTree(TreeNode p, TreeNode q) {
       if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        if(p.val==q.val){
           
            TreeNode pl = p.left;
            TreeNode ql = q.left;
            boolean left = isSameTree(pl,ql);
            if(left==false){return false;}
            TreeNode pr = p.right;
            TreeNode qr = q.right;
            boolean right = isSameTree(pr,qr);
             if(right==false){return false;}
        }else{
            return false;
        }
        return true;
    }
}
