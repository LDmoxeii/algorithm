package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.TreeNode

fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    // 创建中序遍历的索引映射，避免重复查找
    val inorderIndexMap = inorder.withIndex().associate { it.value to it.index }

    fun buildTreeHelper(
        preorderStart: Int, preorderEnd: Int,
        inorderStart: Int, inorderEnd: Int,
    ): TreeNode? {
        // 边界条件：前序遍历范围为空
        if (preorderStart > preorderEnd) return null

        // 前序遍历的第一个元素是根节点
        val rootValue = preorder[preorderStart]
        val root = TreeNode(rootValue)

        // 在中序遍历中找到根节点的位置
        val inorderRootIndex = inorderIndexMap[rootValue]!!

        // 计算左子树的大小
        val leftSubtreeSize = inorderRootIndex - inorderStart

        // 递归构建左子树
        val leftSubtree = buildTreeHelper(
            preorderStart + 1,                      // 左子树前序遍历的起始位置
            preorderStart + leftSubtreeSize,        // 左子树前序遍历的结束位置
            inorderStart,                           // 左子树中序遍历的起始位置
            inorderRootIndex - 1                    // 左子树中序遍历的结束位置
        )

        // 递归构建右子树
        val rightSubtree = buildTreeHelper(
            preorderStart + leftSubtreeSize + 1,    // 右子树前序遍历的起始位置
            preorderEnd,                            // 右子树前序遍历的结束位置
            inorderRootIndex + 1,                   // 右子树中序遍历的起始位置
            inorderEnd                              // 右子树中序遍历的结束位置
        )

        // 连接左右子树
        root.left = leftSubtree
        root.right = rightSubtree

        return root
    }

    return buildTreeHelper(0, preorder.lastIndex, 0, inorder.lastIndex)
}
