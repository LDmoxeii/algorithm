package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.TreeNode

fun levelOrder(root: TreeNode?): List<List<Int>> {
    if (root == null) return emptyList()

    val queue = ArrayDeque<TreeNode>().apply { addLast(root) }
    val result = mutableListOf<List<Int>>()

    while (queue.isNotEmpty()) {
        val currentLevel = mutableListOf<Int>()
        val currentLevelSize = queue.size

        repeat(currentLevelSize) {
            val currentNode = queue.removeFirst()
            currentLevel.add(currentNode.`val`)

            currentNode.left?.let { queue.addLast(it) }
            currentNode.right?.let { queue.addLast(it) }
        }
        result.add(currentLevel)
    }

    return result
}
