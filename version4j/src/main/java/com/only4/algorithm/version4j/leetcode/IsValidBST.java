package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.TreeNode;

public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return validateBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validateBST(TreeNode node, long minValue, long maxValue) {
        if (node == null) return true;

        if (node.val <= minValue || node.val >= maxValue) return false;

        return validateBST(node.left, minValue, node.val) &&
                validateBST(node.right, node.val, maxValue);
    }
}


