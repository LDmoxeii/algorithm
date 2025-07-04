package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.TreeNode

/**
 * [437. 路径总和 III](https://leetcode.com/problems/path-sum-iii/)
 *
 * 给定一个二叉树的根节点 root 和一个整数 targetSum，找出路径和等于给定数值的路径总数。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 */
fun pathSum(root: TreeNode?, targetSum: Int): Int {
    // 用于存储前缀和及其出现次数
    val prefixSumCount = HashMap<Long, Int>()
    // 初始化前缀和为0的情况，出现1次
    prefixSumCount[0L] = 1

    // 递归函数，计算路径和等于targetSum的路径数量
    fun dfs(node: TreeNode?, currSum: Long, target: Long): Int {
        if (node == null) return 0

        // 当前路径上的前缀和
        val newSum = currSum + node.`val`
        // 需要查找的前缀和，如果存在则说明有路径和为targetSum
        val complement = newSum - target

        // 获取符合要求的路径数量
        val count = prefixSumCount.getOrDefault(complement, 0)

        // 更新当前前缀和的出现次数
        prefixSumCount[newSum] = prefixSumCount.getOrDefault(newSum, 0) + 1

        // 递归处理左右子树
        val totalPaths = count + dfs(node.left, newSum, target) + dfs(node.right, newSum, target)

        // 回溯，恢复状态，移除当前节点的前缀和记录
        prefixSumCount[newSum] = prefixSumCount.getOrDefault(newSum, 0) - 1

        return totalPaths
    }

    return dfs(root, 0, targetSum.toLong())
}

private fun Boolean.toInt() = if (this) 1 else 0
