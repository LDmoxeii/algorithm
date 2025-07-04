package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.TreeNode

/**
 * [105. 从前序与中序遍历序列构造二叉树](https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/?envType=study-plan-v2&envId=top-100-liked)
 *
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的前序遍历，
 * inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 * 解题思路：
 * 1. 前序遍历的第一个元素是根节点
 * 2. 在中序遍历中找到根节点的位置，将数组分为左子树和右子树
 * 3. 递归构建左子树和右子树
 *
 * 优化点：
 * - 使用Map缓存中序遍历的索引，避免重复查找
 * - 使用索引范围代替数组复制，减少内存使用
 *
 * @param preorder 前序遍历数组
 * @param inorder 中序遍历数组
 * @return 构造的二叉树根节点
 */
fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    if (preorder.isEmpty()) return null

    // 创建中序遍历值到索引的映射，避免重复查找
    val inorderMap = inorder.withIndex().associate { it.value to it.index }

    // 使用辅助函数递归构建树
    fun buildTreeHelper(preStart: Int, preEnd: Int, inStart: Int, inEnd: Int): TreeNode? {
        if (preStart > preEnd) return null

        // 前序遍历的第一个元素是根节点
        val rootVal = preorder[preStart]
        val root = TreeNode(rootVal)

        // 在中序遍历中找到根节点的位置
        val inorderRootIndex = inorderMap[rootVal]!!

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
