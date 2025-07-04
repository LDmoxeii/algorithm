package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LevelOrderTest {

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
        val expected = emptyList<List<Int>>()
        assertEquals(expected, levelOrder(root))
    }

    @Test
    fun `test single node tree`() {
        val root = TreeNode(1)
        val expected = listOf(listOf(1))
        assertEquals(expected, levelOrder(root))
    }

    @Test
    fun `test example tree`() {
        // 创建示例树
        //     3
        //    / \
        //   9  20
        //     /  \
        //    15   7
        val root = createTreeFromArray(arrayOf(3, 9, 20, null, null, 15, 7))
        val expected = listOf(
            listOf(3),
            listOf(9, 20),
            listOf(15, 7)
        )
        assertEquals(expected, levelOrder(root))
    }

    @Test
    fun `test complete binary tree`() {
        // 创建完全二叉树
        //      1
        //     / \
        //    2   3
        //   / \ / \
        //  4  5 6  7
        val root = createTreeFromArray(arrayOf(1, 2, 3, 4, 5, 6, 7))
        val expected = listOf(
            listOf(1),
            listOf(2, 3),
            listOf(4, 5, 6, 7)
        )
        assertEquals(expected, levelOrder(root))
    }

    @Test
    fun `test left-skewed tree`() {
        // 创建左倾斜树
        //   1
        //  /
        // 2
        ///
        //3
        val root = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(3)
            }
        }
        val expected = listOf(
            listOf(1),
            listOf(2),
            listOf(3)
        )
        assertEquals(expected, levelOrder(root))
    }

    @Test
    fun `test right-skewed tree`() {
        // 创建右倾斜树
        // 1
        //  \
        //   2
        //    \
        //     3
        val root = TreeNode(1).apply {
            right = TreeNode(2).apply {
                right = TreeNode(3)
            }
        }
        val expected = listOf(
            listOf(1),
            listOf(2),
            listOf(3)
        )
        assertEquals(expected, levelOrder(root))
    }

    @Test
    fun `test asymmetric tree`() {
        // 创建非对称树
        //     1
        //    / \
        //   2   3
        //  /     \
        // 4       5
        val root = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(4)
            }
            right = TreeNode(3).apply {
                right = TreeNode(5)
            }
        }
        val expected = listOf(
            listOf(1),
            listOf(2, 3),
            listOf(4, 5)
        )
        assertEquals(expected, levelOrder(root))
    }

    @Test
    fun `test tree with missing nodes`() {
        // 创建有缺失节点的树
        //     1
        //    / \
        //   2   3
        //    \   \
        //     4   5
        val root = createTreeFromArray(arrayOf(1, 2, 3, null, 4, null, 5))
        val expected = listOf(
            listOf(1),
            listOf(2, 3),
            listOf(4, 5)
        )
        assertEquals(expected, levelOrder(root))
    }

    @Test
    fun `test deep tree`() {
        // 创建深度树
        //        1
        //       / \
        //      2   3
        //     /   / \
        //    4   5   6
        //   /       /
        //  7       8
        val root = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(4).apply {
                    left = TreeNode(7)
                }
            }
            right = TreeNode(3).apply {
                left = TreeNode(5)
                right = TreeNode(6).apply {
                    left = TreeNode(8)
                }
            }
        }
        val expected = listOf(
            listOf(1),
            listOf(2, 3),
            listOf(4, 5, 6),
            listOf(7, 8)
        )
        assertEquals(expected, levelOrder(root))
    }
}
