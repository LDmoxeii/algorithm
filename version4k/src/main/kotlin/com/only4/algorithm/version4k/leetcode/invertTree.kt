package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.TreeNode

fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) return null

    val leftSubtree = invertTree(root.left)
    val rightSubtree = invertTree(root.right)

    root.left = rightSubtree
    root.right = leftSubtree

    return root
}
