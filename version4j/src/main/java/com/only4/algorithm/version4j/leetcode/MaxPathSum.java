package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.TreeNode;

public class MaxPathSum {
    private int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        calculateMaxGain(root);
        return maxPathSum;
    }

    private int calculateMaxGain(TreeNode node) {
        if (node == null) return 0;

        int leftGain = Math.max(calculateMaxGain(node.left), 0);
        int rightGain = Math.max(calculateMaxGain(node.right), 0);

        // 更新全局最大路径和
        maxPathSum = Math.max(maxPathSum, node.val + leftGain + rightGain);

        // 返回当前节点能提供的最大增益
        return node.val + Math.max(leftGain, rightGain);
    }
}
