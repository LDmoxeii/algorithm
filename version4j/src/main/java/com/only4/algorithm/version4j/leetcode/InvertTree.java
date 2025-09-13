package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.TreeNode;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode leftSubtree = invertTree(root.left);
        TreeNode rightSubtree = invertTree(root.right);

        root.left = rightSubtree;
        root.right = leftSubtree;

        return root;
    }
}
