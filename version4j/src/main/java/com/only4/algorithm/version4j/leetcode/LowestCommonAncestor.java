package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.TreeNode;

/**
 * @author zhenyu.jiang
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;

        TreeNode leftResult = lowestCommonAncestor(root.left, p, q);
        TreeNode rightResult = lowestCommonAncestor(root.right, p, q);

        if (leftResult != null && rightResult != null) return root;
        if (leftResult != null) return leftResult;
        if (rightResult != null) return rightResult;
        return null;
    }
}
