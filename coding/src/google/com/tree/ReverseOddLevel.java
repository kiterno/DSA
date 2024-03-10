package google.com.tree;

public class ReverseOddLevel {
    public TreeNode reverseOddLevels(TreeNode root) {
        traverse(root, root, 0);
        return root;
    }

    private void traverse(TreeNode root1, TreeNode root2, int level) {
        if (root1 == null || root2 == null)
            return;

        if (level % 2 == 1) {
            int t = root1.val;
            root1.val = root2.val;
            root2.val = t;
        }

        traverse(root1.left, root2.right, level+1);
        traverse(root1.right, root2.left, level+1);
    }
}
