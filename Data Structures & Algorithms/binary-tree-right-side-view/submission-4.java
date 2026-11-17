class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if (i == 0) {
                    result.add(currentNode.val);
                }
                if (currentNode.right != null) queue.offer(currentNode.right);
                if (currentNode.left != null) queue.offer(currentNode.left);
               
            }
        }
        return result;
    }
}