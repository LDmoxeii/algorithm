package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.TreeNode

/**
 * [102. 二叉树的层序遍历](https://leetcode.com/problems/binary-tree-level-order-traversal/)
 *
 * 给你一个二叉树，请你返回其按层序遍历得到的节点值。（即逐层地，从左到右访问所有节点）。
 *
 * 示例：
 * ```
 * 二叉树：[3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * ```
 * 返回其层序遍历结果：
 * ```
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * ```
 *
 * 解题思路:
 * 1. 使用广度优先搜索(BFS)，通过队列实现层序遍历
 * 2. 初始时将根节点加入队列
 * 3. 每次处理当前队列中的所有节点（即当前层的所有节点）
 * 4. 对于每个节点，将其左右子节点加入队列，用于下一层的遍历
 * 5. 直到队列为空，表示所有层都已遍历完成
 *
 * 时间复杂度: O(n)，其中n是树中的节点数
 * 空间复杂度: O(n)，队列中最多存储n个节点
 */
fun levelOrder(root: TreeNode?): List<List<Int>> {
    // 如果根节点为空，返回空列表
    root ?: return emptyList()

    // 使用双端队列存储每层的节点，初始时加入根节点
    val queue = ArrayDeque<TreeNode>().apply { addLast(root) }
    // 存储最终结果的列表
    val result = mutableListOf<List<Int>>()

    // 当队列不为空时，继续遍历
    while (queue.isNotEmpty()) {
        // 创建当前层节点值的列表
        val currentLevel = mutableListOf<Int>()
        // 获取当前层的节点数量
        val levelSize = queue.size

        // 处理当前层的所有节点
        repeat(levelSize) {
            // 取出队首节点
            val node = queue.removeFirst()
            // 将当前节点的值加入当前层列表
            currentLevel.add(node.`val`)
            // 如果有左子节点，将其加入队列
            node.left?.let { queue.addLast(it) }
            // 如果有右子节点，将其加入队列
            node.right?.let { queue.addLast(it) }
        }

        // 将当前层的节点值列表添加到结果中
        result.add(currentLevel)
    }

    return result
}
