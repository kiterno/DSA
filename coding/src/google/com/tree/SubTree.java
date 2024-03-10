package google.com.tree;

public class SubTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return root!=null && (equals(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
    }

    private boolean equals(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;

        return (root.val == subRoot.val) && equals(root.left, subRoot.left) && equals(root.right, subRoot.right);
    }
}
