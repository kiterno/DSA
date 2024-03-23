package leetcode.practice.zepto;

public class BinarySearchTree {

    static int max_sum = 0;

    static class Path {
        int sum;
        boolean isBst;

        public Path(int sum, boolean isBst) {
            this.sum = sum;
            this.isBst = isBst;
        }
    }

     static class Node {
        Node left, right;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(4);
        root.right = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.left.right.left = new Node(3);
        root.left.right.right = new Node(5);
        root.left.right.left.left = new Node(2);
        root.left.right.left.left.left = new Node(1);
        root.left.right.right.right = new Node(6);
        root.left.right.right.right.right = new Node(7);


        root.right.left = new Node(2);
        root.right.right = new Node(5);
        root.right.right.left = new Node(4);
        root.right.right.right = new Node(6);

        getMaxSum(root);

        System.out.println(max_sum);
    }

    private static Path getMaxSum(Node root) {
        if (root == null) return new Path(0, true);

        Path path = getMaxSum(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

        return path;
    }

    private static Path getMaxSum(Node root, int leftMin, int rightMax) {
        if (root == null) return new Path(0, true);

        if (root != null) {
            Path left = getMaxSum(root.left, leftMin, root.val);
            Path right = getMaxSum(root.right, root.val, rightMax);

            if (left.isBst && right.isBst && root.val > leftMin && root.val < rightMax) {
                if (root.left != null && root.val < root.left.val) {
                    return new Path(0, false);
                }

                if (root.right != null && root.val > root.right.val) {
                    return new Path(0, false);
                }

                int sum = left.sum + right.sum + root.val;

                max_sum = Math.max(max_sum, sum);
                return new Path(sum, true);

            } else {
                if (left.isBst) max_sum = Math.max(max_sum, left.sum);
                if (right.isBst) max_sum = Math.max(max_sum, right.sum);

                return left;
            }

        } else {
            return new Path(0, false);
        }
    }
}

