package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.TreeNode

fun isSymmetric(root: TreeNode?): Boolean {
    if (root == null) return true
    return isMirror(root.left, root.right)
}

private fun isMirror(leftNode: TreeNode?, rightNode: TreeNode?): Boolean {
    if (leftNode == null && rightNode == null) return true
    if (leftNode == null || rightNode == null) return false

    return leftNode.`val` == rightNode.`val`
            && isMirror(leftNode.left, rightNode.right)
            && isMirror(leftNode.right, rightNode.left)
}
