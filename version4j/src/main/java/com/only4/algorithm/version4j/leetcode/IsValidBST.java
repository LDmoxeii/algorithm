package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.TreeNode;

public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long left, long right) {
        if (root == null) return true;
        return isValidBST(root.left, left, root.val) && isValidBST(root.right, root.val, right) &&
                root.val > left && root.val < right;
    }

    public static void main(String[] args) {
        new IsValidBST().isValidBST(new TreeNode(2147483647));
    }
}


