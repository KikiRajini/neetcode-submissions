class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // Swap the children
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }
}
