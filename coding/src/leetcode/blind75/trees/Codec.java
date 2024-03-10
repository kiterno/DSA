package leetcode.blind75.trees;

import java.util.Objects;

public class Codec {

    // Encodes a tree to a single string.
    int i=0;
    public String serialize(TreeNode root) {

        if (root == null) {
            return "null";
        }

        if (root.left == null && root.right == null) {
            return root.val+"";
        }

        String left = serialize(root.left);
        String right = serialize(root.right);

        return root.val + " "+ left+ " "+right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] node = data.split(" ");

        return deserialize(node);
    }

    private TreeNode deserialize(String[] node) {
        if (i<node.length && Objects.equals(node[i], "null")) {
            return null;
        }

        else if (i<node.length) {

            TreeNode root = new TreeNode(Integer.parseInt(node[i]));
            i++;
            root.left = deserialize(node);
            i++;
            root.right = deserialize(node);

            return root;
        }

        return null;
    }
}
