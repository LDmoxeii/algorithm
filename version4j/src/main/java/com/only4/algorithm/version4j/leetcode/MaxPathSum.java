package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.TreeNode;

public class MaxPathSum {
    private int globalMaxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        calculateMaxContribution(root);
        return globalMaxPathSum;
    }

    /**
     * 计算以当前节点为起点向下延伸的最大路径贡献值
     * 同时更新全局最大路径和（可能以当前节点为"桥梁"的路径）
     */
    private int calculateMaxContribution(TreeNode currentNode) {
        // 基础情况：空节点无贡献
        if (currentNode == null) return 0;

        // 递归计算左右子树的最大贡献值（负值时取0，表示不选择该路径）
        int leftMaxContribution = Math.max(calculateMaxContribution(currentNode.left), 0);
        int rightMaxContribution = Math.max(calculateMaxContribution(currentNode.right), 0);

        // 计算以当前节点为"桥梁"的路径和：左子树 + 当前节点 + 右子树
        int currentBridgePathSum = currentNode.val + leftMaxContribution + rightMaxContribution;

        // 更新全局最大路径和
        globalMaxPathSum = Math.max(globalMaxPathSum, currentBridgePathSum);

        // 返回当前节点向上的最大贡献值：当前节点 + 左右子树中贡献更大的一边
        return currentNode.val + Math.max(leftMaxContribution, rightMaxContribution);
    }
}
