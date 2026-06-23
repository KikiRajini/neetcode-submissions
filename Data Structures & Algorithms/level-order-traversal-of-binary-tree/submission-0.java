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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;  // handle empty tree
        q.offer(root);
      
        while (!q.isEmpty()){
              int size = q.size();
             List<Integer> subresult = new ArrayList<>();
            for(int i =0; i<size; i++){
               
                TreeNode inContext = q.poll();
                subresult.add(inContext.val);
                if (inContext.left != null) q.offer(inContext.left);
                if (inContext.right != null) q.offer(inContext.right);

                
            }
   result.add(subresult);
        }
        return result;
        
    }

}
