package leetcode.practice.tree;

import leetcode.blind75.trees.TreeNode;

import java.util.List;

public class HouseRobberIII {
    public int rob(TreeNode root) {
        List<Integer> res = findSolution(root);


        if(res == null) return -1;
        return Math.max(res.get(0), res.get(1));
    }


    public List<Integer> findSolution(TreeNode root) {
        if(root == null) {
            return List.of(0, 0);
        }
        List<Integer> left = findSolution(root.left);
        List<Integer> right = findSolution(root.right);

        return List.of(left.get(1)+right.get(1)+root.val, left.get(0)+right.get(0));
    }

}
