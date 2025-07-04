package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.TreeNode

/**
 * [226. 翻转二叉树](https://leetcode.com/problems/invert-binary-tree/)
 *
 * 翻转一棵二叉树，将所有节点的左右子树交换。
 *
 * 示例:
 * 输入:
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * 输出:
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * 解题思路:
 * 采用递归方法，对每个节点执行以下操作：
 * 1. 交换当前节点的左右子树
 * 2. 递归处理左子树
 * 3. 递归处理右子树
 *
 * 时间复杂度: O(n)，其中n是树中节点的个数
 * 空间复杂度: O(h)，其中h是树的高度，最坏情况下为O(n)
 */
fun invertTree(root: TreeNode?): TreeNode? {
    // 如果节点为空，直接返回null
    root ?: return null

    // 递归处理左右子树
    val left = invertTree(root.left)
    val right = invertTree(root.right)

    // 交换左右子树
    root.apply {
        this.left = right
        this.right = left
    }

    return root
}

/**
 * 迭代方式实现二叉树的翻转
 * 使用栈进行深度优先遍历
 *
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */
fun invertTreeIterative(root: TreeNode?): TreeNode? {
    // 如果根节点为空，直接返回
    if (root == null) return null

    // 使用栈进行DFS遍历
    val stack = ArrayDeque<TreeNode>()
    stack.addLast(root)

    while (stack.isNotEmpty()) {
        val node = stack.removeLast()

        // 交换当前节点的左右子树
        val temp = node.left
        node.left = node.right
        node.right = temp

        // 将非空的子节点加入栈中
        node.left?.let { stack.addLast(it) }
        node.right?.let { stack.addLast(it) }
    }

    return root
}
