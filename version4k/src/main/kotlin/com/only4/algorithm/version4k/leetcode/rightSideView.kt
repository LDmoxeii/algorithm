package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.TreeNode

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
