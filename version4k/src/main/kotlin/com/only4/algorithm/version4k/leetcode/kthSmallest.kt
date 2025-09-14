package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.TreeNode

fun kthSmallest(root: TreeNode?, k: Int): Int {
    var remainingRank = k

    fun inorderTraversal(currentNode: TreeNode?): Int {
        if (currentNode == null) {
            return -1 // 题目保证节点值非负，用 -1 表示没有找到
        }

        // 先搜索左子树
        val leftResult = inorderTraversal(currentNode.left)
        if (leftResult != -1) { // 如果在左子树中找到了答案
            return leftResult
        }

        // 处理当前节点
        if (--remainingRank == 0) { // 当前节点就是第k小的元素
            return currentNode.`val`
        }

        // 搜索右子树
        return inorderTraversal(currentNode.right) // 右子树会返回答案或者 -1
    }

    return inorderTraversal(root)
}
