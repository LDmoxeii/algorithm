package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.TreeNode

/**
 * [94. 二叉树的中序遍历](https://leetcode.com/problems/binary-tree-inorder-traversal/)
 *
 * 给定一个二叉树的根节点，返回其节点值的中序遍历结果。
 *
 * 解题思路：
 * 中序遍历的顺序是 左子树 -> 根节点 -> 右子树。
 * 本题采用递归实现，步骤如下：
 * 1. 递归遍历左子树
 * 2. 访问当前节点
 * 3. 递归遍历右子树
 *
 * 时间复杂度：O(n)，其中n是二叉树节点的数量
 * 空间复杂度：O(h)，其中h是二叉树的高度，最坏情况下为O(n)
 *
 * @param root 二叉树的根节点
 * @return 中序遍历的结果列表
 */
fun inorderTraversal(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()

    // 内部递归函数
    fun traverse(node: TreeNode?) {
        // 基本情况：如果节点为空，直接返回
        node ?: return

        // 步骤1：递归遍历左子树
        traverse(node.left)

        // 步骤2：访问当前节点
        result.add(node.`val`)

        // 步骤3：递归遍历右子树
        traverse(node.right)
    }

    // 从根节点开始递归遍历
    traverse(root)

    return result
}

/**
 * 二叉树中序遍历的迭代实现
 *
 * 使用栈来模拟递归调用的过程，避免使用系统栈
 *
 * 时间复杂度：O(n)，其中n是二叉树节点的数量
 * 空间复杂度：O(h)，其中h是二叉树的高度
 *
 * @param root 二叉树的根节点
 * @return 中序遍历的结果列表
 */
fun inorderTraversalIterative(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    val stack = ArrayDeque<TreeNode>()
    var current = root

    // 当前节点不为空或栈不为空时，继续遍历
    while (current != null || stack.isNotEmpty()) {
        // 遍历左子树，将所有左子节点入栈
        while (current != null) {
            stack.addLast(current)
            current = current.left
        }

        // 从栈中弹出节点并访问
        current = stack.removeLast()
        result.add(current.`val`)

        // 处理右子树
        current = current.right
    }

    return result
}
