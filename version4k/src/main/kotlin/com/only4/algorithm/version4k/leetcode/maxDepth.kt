package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.TreeNode

fun maxDepth(root: TreeNode?): Int {
    if (root == null) return 0

    val leftDepth = maxDepth(root.left)
    val rightDepth = maxDepth(root.right)

    return maxOf(leftDepth, rightDepth) + 1
}
