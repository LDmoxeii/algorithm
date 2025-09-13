package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.TreeNode

fun pathSum(root: TreeNode?, targetSum: Int): Int {
    // 用于存储前缀和及其出现次数
    val prefixSumCount = HashMap<Long, Int>()
    // 初始化前缀和为0的情况，出现1次
    prefixSumCount[0L] = 1

    fun dfs(node: TreeNode?, currentSum: Long, target: Long): Int {
        if (node == null) return 0

        // 当前路径上的前缀和
        val newSum = currentSum + node.`val`
        // 需要查找的前缀和，如果存在则说明有路径和为targetSum
        val complement = newSum - target

        // 获取符合要求的路径数量
        val pathCount = prefixSumCount.getOrDefault(complement, 0)

        // 更新当前前缀和的出现次数
        prefixSumCount[newSum] = prefixSumCount.getOrDefault(newSum, 0) + 1

        // 递归处理左右子树
        val totalPaths = pathCount + dfs(node.left, newSum, target) + dfs(node.right, newSum, target)

        // 回溯，恢复状态，移除当前节点的前缀和记录
        prefixSumCount[newSum] = prefixSumCount.getOrDefault(newSum, 0) - 1

        return totalPaths
    }

    return dfs(root, 0, targetSum.toLong())
}
