public class Codec {
    StringBuilder sb = new StringBuilder();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            sb.append("N,");
            return "";
        }
        sb.append(root.val).append(",");
        serialize(root.left);
        serialize(root.right);
        return sb.toString();
    }

    int i = 0;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        return build(tokens);
    }

    private TreeNode build(String[] tokens) {
        String current = tokens[i++];
        if (current.equals("N") || current.equals("")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(current));
        root.left = build(tokens);
        root.right = build(tokens);
        return root;
    }
}