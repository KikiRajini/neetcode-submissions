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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if root is null, we've gone too far (though BST LCA usually assumes p and q exist)
        if (root == null) return null;

        // If both nodes are smaller than root, LCA must be in the left subtree
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        
        // If both nodes are larger than root, LCA must be in the right subtree
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        
        // If one is smaller (or equal) and the other is larger (or equal), 
        // OR we found p or q themselves, this current node is the LCA.
        return root;
    }
}
