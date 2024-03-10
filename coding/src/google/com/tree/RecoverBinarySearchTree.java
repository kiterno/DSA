package google.com.tree;

public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        recover(root, null, null);
    }

    private void recover(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return;

        if (min != null && root.val < min.val) {
            int t = root.val;
            root.val = min.val;
            min.val = t;
        }

        if (max != null && root.val > max.val) {
            int t = root.val;
            root.val = max.val;
            max.val = t;
        }

        recover(root.left, min, root);
        recover(root.right, root, max);
    }
}
