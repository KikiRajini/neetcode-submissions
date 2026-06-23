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

public class Solution {
    int preIdx = 0;
    int inIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, null);
    }

    private TreeNode dfs(int[] preorder, int[] inorder,Integer limit){
        if(preIdx>=preorder.length){return null;}//completed tree
        if(limit!=null && inorder[inIdx]==limit){inIdx++; return null;}//subtree completed
        TreeNode root = new TreeNode(preorder[preIdx]);
        preIdx++;
        root.left = dfs(preorder, inorder,root.val);
        root.right = dfs(preorder, inorder,limit);
        return root;
    }

    
}