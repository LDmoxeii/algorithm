package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.TreeNode

/**
 * [104. 二叉树的最大深度](https://leetcode.com/problems/maximum-depth-of-binary-tree/)
 *
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 解题思路：
 * 采用递归（深度优先搜索DFS）的方式求解：
 * 1. 如果节点为空（null），则深度为0
 * 2. 否则，当前节点的最大深度 = max(左子树的最大深度, 右子树的最大深度) + 1
 *
 * 时间复杂度：O(n)，其中n是二叉树中的节点数，每个节点只会被访问一次
 * 空间复杂度：O(h)，其中h是树的高度，最坏情况下为O(n)
 *
 * @param root 二叉树的根节点
 * @return 二叉树的最大深度
 */
fun maxDepth(root: TreeNode?): Int {
    // 基本情况：如果节点为空，则深度为0
    root ?: return 0

    // 递归计算左右子树的最大深度，取较大值，再加上当前节点（即+1）
    return maxOf(maxDepth(root.left), maxDepth(root.right)) + 1
}

/**
 * 二叉树最大深度的迭代实现（层序遍历/BFS）
 *
 * 使用队列进行层序遍历，记录遍历的层数
 *
 * 时间复杂度：O(n)，其中n是二叉树中的节点数
 * 空间复杂度：O(w)，其中w是树的最大宽度，最坏情况下为O(n/2)，约为O(n)
 *
 * @param root 二叉树的根节点
 * @return 二叉树的最大深度
 */
fun maxDepthIterative(root: TreeNode?): Int {
    // 如果根节点为空，返回0
    if (root == null) return 0

    // 初始化队列，用于层序遍历
    val queue = ArrayDeque<TreeNode>()
    queue.add(root)

    // 深度计数器
    var depth = 0

    // 开始层序遍历
    while (queue.isNotEmpty()) {
        // 每一层增加一次深度
        depth++

        // 当前层的节点数
        val levelSize = queue.size

        // 处理当前层的所有节点
        repeat(levelSize) {
            val node = queue.removeFirst()

            // 将下一层的节点加入队列
            node.left?.let { queue.add(it) }
            node.right?.let { queue.add(it) }
        }
    }

    return depth
}
