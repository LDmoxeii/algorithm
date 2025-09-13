package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.TreeNode

fun sortedArrayToBST(nums: IntArray): TreeNode? {
    if (nums.isEmpty()) return null

    fun buildTree(startIndex: Int, endIndex: Int): TreeNode? {
        if (startIndex > endIndex) return null

        val midIndex = startIndex + (endIndex - startIndex) / 2

        return TreeNode(nums[midIndex]).apply {
            left = buildTree(startIndex, midIndex - 1)
            right = buildTree(midIndex + 1, endIndex)
        }
    }

    return buildTree(0, nums.lastIndex)
}
