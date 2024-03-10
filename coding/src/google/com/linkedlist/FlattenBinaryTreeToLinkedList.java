package google.com.linkedlist;

import java.util.LinkedList;
import java.util.Queue;

public class FlattenBinaryTreeToLinkedList {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public void flatten(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        TreeNode temp = new TreeNode(0);


        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            temp.right = node;
            temp.left = null;
            temp = temp.right;


            if (node!=null && node.left!=null)
                queue.add(node.left);

            if (node!=null && node.right!=null)
                queue.add(node.right);
        }
        if (temp!=null)
            root = temp.right;
    }
}
