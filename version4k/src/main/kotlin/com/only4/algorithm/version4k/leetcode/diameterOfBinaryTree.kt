package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.TreeNode

fun diameterOfBinaryTree(root: TreeNode?): Int {
    if (root == null) return 0

    var maxDiameter = 0

    fun calculateDepth(node: TreeNode?): Int {
        if (node == null) return 0

        val leftDepth = calculateDepth(node.left)
        val rightDepth = calculateDepth(node.right)

        // 更新最大直径
        maxDiameter = maxOf(maxDiameter, leftDepth + rightDepth)

        // 返回当前节点的最大深度
        return maxOf(leftDepth, rightDepth) + 1
    }

    calculateDepth(root)
    return maxDiameter
}
