package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RightSideViewTest {

    /**
     * 辅助函数：创建二叉树
     * 数组格式为层序遍历结果，null表示空节点
     */
    private fun createTreeFromArray(array: Array<Int?>): TreeNode? {
        if (array.isEmpty() || array[0] == null) return null

        val root = TreeNode(array[0]!!)
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)

        var i = 1
        while (queue.isNotEmpty() && i < array.size) {
            val node = queue.removeFirst()

            // 处理左子节点
            if (i < array.size) {
                if (array[i] != null) {
                    node.left = TreeNode(array[i]!!)
                    queue.add(node.left!!)
                }
                i++
            }

            // 处理右子节点
            if (i < array.size) {
                if (array[i] != null) {
                    node.right = TreeNode(array[i]!!)
                    queue.add(node.right!!)
                }
                i++
            }
        }

        return root
    }

    @Test
    fun `test empty tree`() {
        val root = null
        val expected = emptyList<Int>()
        val result = rightSideView(root)
        assertEquals(expected, result)
    }

    @Test
    fun `test single node tree`() {
        val root = TreeNode(1)
        val expected = listOf(1)
        val result = rightSideView(root)
        assertEquals(expected, result)
    }

    @Test
    fun `test example 1`() {
        // 构建树 [1,2,3,null,5,null,4]
        //    1
        //  /   \
        // 2     3
        //  \     \
        //   5     4
        val root = createTreeFromArray(arrayOf(1, 2, 3, null, 5, null, 4))
        val expected = listOf(1, 3, 4)
        val result = rightSideView(root)
        assertEquals(expected, result)
    }

    @Test
    fun `test example 2`() {
        // 构建树 [1,null,3]
        //   1
        //    \
        //     3
        val root = createTreeFromArray(arrayOf(1, null, 3))
        val expected = listOf(1, 3)
        val result = rightSideView(root)
        assertEquals(expected, result)
    }

    @Test
    fun `test left skewed tree`() {
        // 构建左倾斜树
        //    1
        //   /
        //  2
        // /
        //3
        val root = createTreeFromArray(arrayOf(1, 2, null, 3))
        val expected = listOf(1, 2, 3)
        val result = rightSideView(root)
        assertEquals(expected, result)
    }

    @Test
    fun `test right skewed tree`() {
        // 构建右倾斜树
        //  1
        //   \
        //    2
        //     \
        //      3
        // 手动构建右倾斜树，避免层序遍历数组表示的问题
        val root = TreeNode(1).apply {
            right = TreeNode(2).apply {
                right = TreeNode(3)
            }
        }
        val expected = listOf(1, 2, 3)
        val result = rightSideView(root)
        assertEquals(expected, result)
    }

    @Test
    fun `test complete binary tree`() {
        // 构建完全二叉树
        //      1
        //    /   \
        //   2     3
        //  / \   / \
        // 4   5 6   7
        val root = createTreeFromArray(arrayOf(1, 2, 3, 4, 5, 6, 7))
        val expected = listOf(1, 3, 7)
        val result = rightSideView(root)
        assertEquals(expected, result)
    }

    @Test
    fun `test complex tree`() {
        // 构建复杂树
        //        1
        //      /   \
        //     2     3
        //    / \   / \
        //   4   5 6   7
        //  /         /
        // 8         9
        val root = createTreeFromArray(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, null, null, null, null, null, 9))
        val expected = listOf(1, 3, 7, 9)
        val result = rightSideView(root)
        assertEquals(expected, result)
    }

    @Test
    fun `test tree with missing right nodes`() {
        // 构建有缺失右节点的树
        //      1
        //    /   \
        //   2     3
        //  /     /
        // 4     6
        val root = createTreeFromArray(arrayOf(1, 2, 3, 4, null, 6))
        val expected = listOf(1, 3, 6)
        val result = rightSideView(root)
        assertEquals(expected, result)
    }
}
