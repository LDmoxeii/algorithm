package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class InorderTraversalTest {

    /**
     * 辅助函数：根据数组创建二叉树
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
            if (i < array.size && array[i] != null) {
                node.left = TreeNode(array[i]!!)
                queue.add(node.left!!)
            }
            i++

            // 处理右子节点
            if (i < array.size && array[i] != null) {
                node.right = TreeNode(array[i]!!)
                queue.add(node.right!!)
            }
            i++
        }

        return root
    }

    @Test
    fun testEmptyTree() {
        val root = null
        val expected = emptyList<Int>()

        // 测试递归实现
        assertEquals(expected, inorderTraversal(root))

        // 测试迭代实现
        assertEquals(expected, inorderTraversalIterative(root))
    }

    @Test
    fun testSingleNodeTree() {
        val root = TreeNode(1)
        val expected = listOf(1)

        // 测试递归实现
        assertEquals(expected, inorderTraversal(root))

        // 测试迭代实现
        assertEquals(expected, inorderTraversalIterative(root))
    }

    @Test
    fun testExample1() {
        // 创建树 [1,null,2,3]
        //   1
        //    \
        //     2
        //    /
        //   3
        val root = TreeNode(1).apply {
            right = TreeNode(2).apply {
                left = TreeNode(3)
            }
        }
        val expected = listOf(1, 3, 2)

        // 测试递归实现
        assertEquals(expected, inorderTraversal(root))

        // 测试迭代实现
        assertEquals(expected, inorderTraversalIterative(root))
    }

    @Test
    fun testBalancedTree() {
        // 创建树 [1,2,3,4,5,6,7]
        //      1
        //     / \
        //    2   3
        //   / \ / \
        //  4  5 6  7
        val tree = createTreeFromArray(arrayOf(1, 2, 3, 4, 5, 6, 7))
        val expected = listOf(4, 2, 5, 1, 6, 3, 7)

        // 测试递归实现
        assertEquals(expected, inorderTraversal(tree))

        // 测试迭代实现
        assertEquals(expected, inorderTraversalIterative(tree))
    }

    @Test
    fun testLeftSkewedTree() {
        // 创建左倾斜树 [1,2,null,3,null,4]
        //   1
        //  /
        // 2
        ///
        //3
        ///
        //4
        val root = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(3).apply {
                    left = TreeNode(4)
                }
            }
        }
        val expected = listOf(4, 3, 2, 1)

        // 测试递归实现
        assertEquals(expected, inorderTraversal(root))

        // 测试迭代实现
        assertEquals(expected, inorderTraversalIterative(root))
    }

    @Test
    fun testRightSkewedTree() {
        // 创建右倾斜树 [1,null,2,null,3,null,4]
        // 1
        //  \
        //   2
        //    \
        //     3
        //      \
        //       4
        val root = TreeNode(1).apply {
            right = TreeNode(2).apply {
                right = TreeNode(3).apply {
                    right = TreeNode(4)
                }
            }
        }
        val expected = listOf(1, 2, 3, 4)

        // 测试递归实现
        assertEquals(expected, inorderTraversal(root))

        // 测试迭代实现
        assertEquals(expected, inorderTraversalIterative(root))
    }
}
