package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.TreeNode

fun rightSideView(root: TreeNode?): List<Int> {
    // 处理空树情况
    root ?: return emptyList()

    // 使用双端队列进行层序遍历
    val levelQueue = ArrayDeque<TreeNode>().apply { add(root) }
    val rightViewResult = mutableListOf<Int>()

    // 逐层遍历二叉树
    while (levelQueue.isNotEmpty()) {
        val currentLevelSize = levelQueue.size

        // 遍历当前层的所有节点
        for (nodeIndex in 0 until currentLevelSize) {
            val currentNode = levelQueue.removeFirst()

            // 记录每层最右侧节点的值（第一个处理的节点）
            if (nodeIndex == 0) {
                rightViewResult.add(currentNode.`val`)
            }

            // 先添加右子节点，再添加左子节点（确保右节点优先处理）
            currentNode.right?.let { levelQueue.add(it) }
            currentNode.left?.let { levelQueue.add(it) }
        }
    }

    return rightViewResult
}
