class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left= right;
        root.right=left;
        if(root.left!=null){
        invertTree(root.left);
        }
        if(root.right!=null){
        invertTree(root.right);
        }
        return root;
    }
}
