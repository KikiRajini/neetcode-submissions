class Solution {
    int result = 0;

    public int goodNodes(TreeNode root) {
        if(root==null){return 0;}
        dfs(root,root.val);
        return result;
    }

    private void dfs(TreeNode root, int max) {
        if(root==null){return;}
        if(root.val>=max){result++;} 
        max = Math.max(max, root.val); 
        dfs(root.left,max);
        dfs(root.right,max);
   

    }
}
