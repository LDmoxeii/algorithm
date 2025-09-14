package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.TreeNode

fun maxPathSum(root: TreeNode): Int {
    var globalMaxPathSum = Int.MIN_VALUE

    /**
     * 计算以当前节点为起点向下延伸的最大路径贡献值
     * 同时更新全局最大路径和（可能以当前节点为"桥梁"的路径）
     */
    fun TreeNode?.calculateMaxContribution(): Int = this?.run {
        // 递归计算左右子树的最大贡献值（负值时取0）
        val leftMaxContribution = left.calculateMaxContribution().coerceAtLeast(0)
        val rightMaxContribution = right.calculateMaxContribution().coerceAtLeast(0)

        // 计算以当前节点为"桥梁"的路径和
        val currentBridgePathSum = `val` + leftMaxContribution + rightMaxContribution

        // 更新全局最大路径和
        globalMaxPathSum = maxOf(globalMaxPathSum, currentBridgePathSum)

        // 返回当前节点向上的最大贡献值
        `val` + maxOf(leftMaxContribution, rightMaxContribution)
    } ?: 0  // 空节点返回0贡献

    root.calculateMaxContribution()
    return globalMaxPathSum
}
