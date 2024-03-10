package leetcode.blind75.trees;

public class BinaryTreeMaximumPathSum {
    static int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int max_sum = min(root);

        return Math.max(max_sum, max);
    }

    private int min(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = min(root.left);
        int right = min(root.right);

        if(root.left!=null) max=Math.max(max, left);
        if(root.right!=null) max=Math.max(max, right);

        if (left<0) left = 0;
        if (right<0) right = 0;

        max = Math.max(root.val, max);
        max = Math.max(root.val+left+right, max);

        return root.val + Math.max(left, right);
    }
}
