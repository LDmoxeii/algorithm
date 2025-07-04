package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KthSmallestTest {

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
    fun `test example 1`() {
        // 构建树 [3,1,4,null,2]
        val root = createTreeFromArray(arrayOf(3, 1, 4, null, 2))

        // 测试 k = 1
        assertEquals(1, kthSmallest(root, 1))
    }

    @Test
    fun `test example 2`() {
        // 构建树 [5,3,6,2,4,null,null,1]
        val root = createTreeFromArray(arrayOf(5, 3, 6, 2, 4, null, null, 1))

        // 测试 k = 3
        assertEquals(3, kthSmallest(root, 3))
    }

    @Test
    fun `test empty tree`() {
        assertEquals(-1, kthSmallest(null, 1))
    }

    @Test
    fun `test single node tree`() {
        val root = TreeNode(1)
        assertEquals(1, kthSmallest(root, 1))
    }

    @Test
    fun `test balanced BST`() {
        // 构建一个平衡的BST [4,2,6,1,3,5,7]
        val root = createTreeFromArray(arrayOf(4, 2, 6, 1, 3, 5, 7))

        // 测试各个位置
        assertEquals(1, kthSmallest(root, 1))
        assertEquals(2, kthSmallest(root, 2))
        assertEquals(3, kthSmallest(root, 3))
        assertEquals(4, kthSmallest(root, 4))
        assertEquals(5, kthSmallest(root, 5))
        assertEquals(6, kthSmallest(root, 6))
        assertEquals(7, kthSmallest(root, 7))
    }

    @Test
    fun `test left-skewed BST`() {
        // 构建一个左倾斜的BST [5,4,null,3,null,2,null,1]
        val root = TreeNode(5).apply {
            left = TreeNode(4).apply {
                left = TreeNode(3).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(1)
                    }
                }
            }
        }

        assertEquals(1, kthSmallest(root, 1))
        assertEquals(2, kthSmallest(root, 2))
        assertEquals(3, kthSmallest(root, 3))
        assertEquals(4, kthSmallest(root, 4))
        assertEquals(5, kthSmallest(root, 5))
    }

    @Test
    fun `test right-skewed BST`() {
        // 构建一个右倾斜的BST [1,null,2,null,3,null,4,null,5]
        val root = TreeNode(1).apply {
            right = TreeNode(2).apply {
                right = TreeNode(3).apply {
                    right = TreeNode(4).apply {
                        right = TreeNode(5)
                    }
                }
            }
        }

        assertEquals(1, kthSmallest(root, 1))
        assertEquals(2, kthSmallest(root, 2))
        assertEquals(3, kthSmallest(root, 3))
        assertEquals(4, kthSmallest(root, 4))
        assertEquals(5, kthSmallest(root, 5))
    }

    @Test
    fun `test complex BST`() {
        // 构建一个复杂的BST [8,3,10,1,6,null,14,null,null,4,7,13,null]
        val root = createTreeFromArray(arrayOf(8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13, null))

        assertEquals(1, kthSmallest(root, 1))
        assertEquals(3, kthSmallest(root, 2))
        assertEquals(4, kthSmallest(root, 3))
        assertEquals(6, kthSmallest(root, 4))
        assertEquals(7, kthSmallest(root, 5))
        assertEquals(8, kthSmallest(root, 6))
        assertEquals(10, kthSmallest(root, 7))
        assertEquals(13, kthSmallest(root, 8))
        assertEquals(14, kthSmallest(root, 9))
    }
}
