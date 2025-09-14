package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.TreeNode

fun pathSum(root: TreeNode?, targetSum: Int): Int {
    // 初始化前缀和哈希表，前缀和为0的出现次数为1
    val prefixSumFrequency = mutableMapOf<Long, Int>()
    prefixSumFrequency[0L] = 1

    fun countPathsWithTargetSum(currentNode: TreeNode?, currentPrefixSum: Long): Int {
        // 边界条件：节点为空
        if (currentNode == null) return 0

        // 计算当前路径的前缀和
        val newPrefixSum = currentPrefixSum + currentNode.`val`

        // 查找符合要求的路径数量：当前前缀和 - 目标值 = 需要查找的前缀和
        val targetPrefixSum = newPrefixSum - targetSum
        val validPathCount = prefixSumFrequency.getOrDefault(targetPrefixSum, 0)

        // 将当前前缀和加入哈希表
        prefixSumFrequency[newPrefixSum] = prefixSumFrequency.getOrDefault(newPrefixSum, 0) + 1

        // 递归处理左右子树
        val leftSubtreePaths = countPathsWithTargetSum(currentNode.left, newPrefixSum)
        val rightSubtreePaths = countPathsWithTargetSum(currentNode.right, newPrefixSum)

        // 回溯：移除当前节点的前缀和记录（恢复状态）
        prefixSumFrequency[newPrefixSum] = prefixSumFrequency.getOrDefault(newPrefixSum, 0) - 1

        return validPathCount + leftSubtreePaths + rightSubtreePaths
    }

    return countPathsWithTargetSum(root, 0L)
}
