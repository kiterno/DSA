package google.com.tree;

public class MaxPathSum {

    private int max_sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        int max = maxSum(root);

        return Math.max(max_sum, max);
    }

    private int maxSum(TreeNode root) {
        if(root.left == null && root.right == null) {
            return root.val;
        }
        int left = Integer.MIN_VALUE;
        if (root.left != null) {
            left = maxSum(root.left);
        }

        int right = Integer.MIN_VALUE;
        if (root.right != null) {
            right = maxSum(root.right);
        }
        max_sum = Math.max(max_sum, root.val+left+right);
        max_sum = Math.max(max_sum, Math.max(left, right));
        if (left != Integer.MIN_VALUE)
            max_sum = Math.max(max_sum, left+root.val);
        if (right != Integer.MIN_VALUE)
            max_sum = Math.max(max_sum, right+root.val);
        max_sum = Math.max(max_sum, root.val);
        return Math.max(root.val+right, root.val+left);
    }
}
