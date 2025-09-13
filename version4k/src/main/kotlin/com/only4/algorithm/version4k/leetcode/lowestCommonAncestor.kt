package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.TreeNode

fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? = when {
    root == null || root == p || root == q -> root
    else -> {
        val leftResult = lowestCommonAncestor(root.left, p, q)
        val rightResult = lowestCommonAncestor(root.right, p, q)
        when {
            leftResult != null && rightResult != null -> root
            else -> leftResult ?: rightResult
        }
    }
}
