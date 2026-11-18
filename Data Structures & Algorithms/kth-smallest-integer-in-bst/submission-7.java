class Solution {
    private int count = 0;
    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null || count >= k) {
            return result;
        }

        kthSmallest(root.left, k);

        count++;
        if (count == k) {
            result = root.val;
            return result;
        }

        kthSmallest(root.right, k);
        return result;
    }
}