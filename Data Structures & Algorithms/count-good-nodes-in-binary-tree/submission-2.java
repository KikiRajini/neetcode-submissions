class Solution {
    int result =0;

    public int goodNodes(TreeNode root) {
        if(root==null){return 0;}
        dfs(root,Integer.MIN_VALUE);
        return result;
    }

    public void dfs(TreeNode root, int max){
       if(root!=null) {
       if(root.val>=max){ result++;}
       max = Math.max(max,root.val);
       dfs(root.left,max);
       dfs(root.right,max);
       }
    }

    
}
