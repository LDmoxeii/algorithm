package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.TreeNode

fun isValidBST(root: TreeNode?): Boolean {
    fun validateBST(node: TreeNode?, minValue: Long, maxValue: Long): Boolean {
        if (node == null) return true

        if (node.`val` <= minValue || node.`val` >= maxValue) return false

        return validateBST(node.left, minValue, node.`val`.toLong()) &&
                validateBST(node.right, node.`val`.toLong(), maxValue)
    }

    return validateBST(root, Long.MIN_VALUE, Long.MAX_VALUE)
}
