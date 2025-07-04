package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.TreeNode

/**
 * [199. 二叉树的右视图](https://leetcode.com/problems/binary-tree-right-side-view/)
 *
 * 给定一个二叉树的根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例 1:
 * ```
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 * 解释:
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 * ```
 *
 * 示例 2:
 * ```
 * 输入: [1,null,3]
 * 输出: [1,3]
 * ```
 *
 * 示例 3:
 * ```
 * 输入: []
 * 输出: []
 * ```
 *
 * 解题思路:
 * 1. 本题使用层序遍历的变体，关键是获取每层最右侧的节点
 * 2. 可以使用广度优先搜索(BFS)，在遍历每一层时，记录最右侧节点的值
 * 3. 使用队列实现层序遍历，每次将当前层的所有节点出队，并将下一层的节点入队
 * 4. 为了保持每层的顺序从左到右，子节点的入队顺序是先左后右
 * 5. 由于我们需要的是每层最右侧的节点，所以我们在每层遍历时取第一个节点(最右侧的节点)
 *
 * 时间复杂度: O(n)，其中n是树中的节点数
 * 空间复杂度: O(n)，队列中最多同时存在n/2个节点（最后一层的最大节点数）
 */
fun rightSideView(root: TreeNode?): List<Int> {
    // 处理空树情况
    root ?: return emptyList()

    // 使用双端队列存储当前层的节点，初始时添加根节点
    val queue = ArrayDeque<TreeNode>().apply { addFirst(root) }
    val result = mutableListOf<Int>()

    // 逐层遍历二叉树
    while (queue.isNotEmpty()) {
        // 记录当前层最右侧节点的值（从右侧看到的节点）
        result.add(queue.first().`val`)

        // 遍历当前层的所有节点
        repeat(queue.size) {
            // 当前节点出队
            val node = queue.removeLast()

            // 按照从左到右的顺序将子节点入队
            // 注意我们使用addFirst，这样队首就是最右侧的节点
            node.left?.let { queue.addFirst(it) }
            node.right?.let { queue.addFirst(it) }
        }
    }

    return result
}
