package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.TreeNode

fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    if (preorder.isEmpty()) return null

    // 创建中序遍历值到索引的映射，避免重复查找
    val inorderMap = inorder.withIndex().associate { it.value to it.index }

    fun buildTreeHelper(preStart: Int, preEnd: Int, inStart: Int, inEnd: Int): TreeNode? {
        if (preStart > preEnd) return null

        // 前序遍历的第一个元素是根节点
        val rootValue = preorder[preStart]
        val root = TreeNode(rootValue)

        // 在中序遍历中找到根节点的位置
        val inorderRootIndex = inorderMap[rootValue]!!

        // 计算左子树的大小
        val leftSubtreeSize = inorderRootIndex - inStart

        // 递归构建左子树和右子树
        root.left = buildTreeHelper(
            preStart + 1,                // 左子树前序遍历的起始位置
            preStart + leftSubtreeSize,  // 左子树前序遍历的结束位置
            inStart,                     // 左子树中序遍历的起始位置
            inorderRootIndex - 1         // 左子树中序遍历的结束位置
        )

        root.right = buildTreeHelper(
            preStart + leftSubtreeSize + 1,  // 右子树前序遍历的起始位置
            preEnd,                          // 右子树前序遍历的结束位置
            inorderRootIndex + 1,            // 右子树中序遍历的起始位置
            inEnd                            // 右子树中序遍历的结束位置
        )

        return root
    }

    return buildTreeHelper(0, preorder.lastIndex, 0, inorder.lastIndex)
}
