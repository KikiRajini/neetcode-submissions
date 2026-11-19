class Solution {
    int preIdx = 0;
    int inIdx = 0;

    //concept - keep limit for each subtree..which is root value.

    public TreeNode buildTree(int[] preorder, int[] inorder) {
       return build(preorder,inorder,Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, int[] inorder, int limit){
        if(preIdx==preorder.length) return null;
        if(inorder[inIdx]==limit){ inIdx++; return null;}
        TreeNode node = new TreeNode(preorder[preIdx]);
        preIdx++;
        node.left = build(preorder,inorder,node.val);
        node.right = build(preorder,inorder,limit);
        return node;
    }
}