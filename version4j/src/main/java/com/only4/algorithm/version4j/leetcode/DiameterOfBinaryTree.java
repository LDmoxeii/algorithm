package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.TreeNode;

public class DiameterOfBinaryTree {
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calculateDepth(root);
        return maxDiameter;
    }

    private int calculateDepth(TreeNode node) {
        if (node == null) return 0;

        int leftDepth = calculateDepth(node.left);
        int rightDepth = calculateDepth(node.right);

        // 更新最大直径
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);

        // 返回当前节点的最大深度
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
