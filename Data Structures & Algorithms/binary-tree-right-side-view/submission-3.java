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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null){return result;}
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);
        while(!bfs.isEmpty()){
            int size = bfs.size();
            for(int i =0 ; i<size; i++){
            TreeNode current = bfs.poll();
            if(i==size-1){result.add(current.val);}
            if(current.left!=null)bfs.add(current.left);
            if(current.right!=null)bfs.add(current.right);
            }
        }
        return result;
    }
}