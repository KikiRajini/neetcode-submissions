class Solution {
    int preIdx = 0;
    int inIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Use an impossible value (like Integer.MAX_VALUE) as the ultimate stop limit
        return dfs(preorder, inorder, Integer.MAX_VALUE);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int limit) {
        if (preIdx >= preorder.length) return null;
        
        // Stop building this subtree if we hit our parent's boundary line
        if (inorder[inIdx] == limit) {
            inIdx++; 
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIdx++]);
        
        // Left subtree cannot cross the current root's value
        root.left = dfs(preorder, inorder, root.val);
        
        // Right subtree inherits whatever limit the current room was restricted by
        root.right = dfs(preorder, inorder, limit);
        
        return root;
    }
}