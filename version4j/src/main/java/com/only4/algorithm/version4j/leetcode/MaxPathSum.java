package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.TreeNode;

/**
 * [124. 二叉树中的最大路径和](https://leetcode.com/problems/binary-tree-maximum-path-sum/)
 * <p>
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。
 * 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 *
 * @author zhenyu.jiang
 * <p>
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 */
public class MaxPathSum {

    int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return result;
    }

    public int maxPath(TreeNode root) {
        if (root == null) return 0;

        int left = maxPath(root.left);
        int right = maxPath(root.right);

        result = Math.max(result, root.val + Math.max(0, left) + Math.max(0, right));

        return root.val + Math.max(Math.max(left, right), 0);
    }
}
