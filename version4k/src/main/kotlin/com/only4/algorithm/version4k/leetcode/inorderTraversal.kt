package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.TreeNode

fun inorderTraversal(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()

    fun inorderHelper(node: TreeNode?) {
        if (node == null) return

        // 递归遍历左子树
        inorderHelper(node.left)
        // 访问当前节点
        result.add(node.`val`)
        // 递归遍历右子树
        inorderHelper(node.right)
    }

    inorderHelper(root)
    return result
}
