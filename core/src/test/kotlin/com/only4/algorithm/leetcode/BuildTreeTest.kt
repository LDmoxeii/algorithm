package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.TreeNode
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BuildTreeTest {

    // 辅助函数：将二叉树转换为层序遍历的列表表示（包含null节点）
    private fun treeToLevelOrderList(root: TreeNode?): List<Int?> {
        if (root == null) return emptyList()

        val result = mutableListOf<Int?>()
        val queue = ArrayDeque<TreeNode?>()
        queue.add(root)

        // 标记是否所有节点都是null（用于剪枝）
        var allNull = false

        while (queue.isNotEmpty() && !allNull) {
            val levelSize = queue.size
            allNull = true

            for (i in 0 until levelSize) {
                val node = queue.removeFirst()

                if (node == null) {
                    result.add(null)
                    queue.add(null)
                    queue.add(null)
                } else {
                    result.add(node.`val`)
                    queue.add(node.left)
                    queue.add(node.right)

                    // 如果有任何非null子节点，继续处理
                    if (node.left != null || node.right != null) {
                        allNull = false
                    }
                }
            }
        }

        // 移除末尾的null值
        while (result.isNotEmpty() && result.last() == null) {
            result.removeAt(result.lastIndex)
        }

        return result
    }

    // 辅助函数：比较两个树是否相同
    private fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true
        if (p == null || q == null) return false
        if (p.`val` != q.`val`) return false

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    }

    // 辅助函数：创建预期的树结构
    private fun createExpectedTree(values: List<Int?>): TreeNode? {
        if (values.isEmpty() || values[0] == null) return null

        val root = TreeNode(values[0]!!)
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)

        var i = 1
        while (queue.isNotEmpty() && i < values.size) {
            val node = queue.removeFirst()

            // 左子节点
            if (i < values.size) {
                val leftVal = values[i++]
                if (leftVal != null) {
                    node.left = TreeNode(leftVal)
                    queue.add(node.left!!)
                }
            }

            // 右子节点
            if (i < values.size) {
                val rightVal = values[i++]
                if (rightVal != null) {
                    node.right = TreeNode(rightVal)
                    queue.add(node.right!!)
                }
            }
        }

        return root
    }

    @Test
    fun `test normal binary tree`() {
        // 前序遍历：[3,9,20,15,7]
        // 中序遍历：[9,3,15,20,7]
        // 预期树：[3,9,20,null,null,15,7]
        val preorder = intArrayOf(3, 9, 20, 15, 7)
        val inorder = intArrayOf(9, 3, 15, 20, 7)

        val result = buildTree(preorder, inorder)
        val expected = createExpectedTree(listOf(3, 9, 20, null, null, 15, 7))

        assertTrue(isSameTree(expected, result))
    }

    @Test
    fun `test single node tree`() {
        val preorder = intArrayOf(1)
        val inorder = intArrayOf(1)

        val result = buildTree(preorder, inorder)
        val expected = TreeNode(1)

        assertTrue(isSameTree(expected, result))
    }

    @Test
    fun `test empty tree`() {
        val preorder = intArrayOf()
        val inorder = intArrayOf()

        val result = buildTree(preorder, inorder)

        assertNull(result)
    }

    @Test
    fun `test left-skewed tree`() {
        // 前序遍历：[1,2,3,4]
        // 中序遍历：[4,3,2,1]
        // 预期树：[1,2,null,3,null,4]
        val preorder = intArrayOf(1, 2, 3, 4)
        val inorder = intArrayOf(4, 3, 2, 1)

        val result = buildTree(preorder, inorder)

        val expected = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(3).apply {
                    left = TreeNode(4)
                }
            }
        }

        assertTrue(isSameTree(expected, result))
    }

    @Test
    fun `test right-skewed tree`() {
        // 前序遍历：[1,2,3,4]
        // 中序遍历：[1,2,3,4]
        // 预期树：[1,null,2,null,3,null,4]
        val preorder = intArrayOf(1, 2, 3, 4)
        val inorder = intArrayOf(1, 2, 3, 4)

        val result = buildTree(preorder, inorder)

        val expected = TreeNode(1).apply {
            right = TreeNode(2).apply {
                right = TreeNode(3).apply {
                    right = TreeNode(4)
                }
            }
        }

        assertTrue(isSameTree(expected, result))
    }

    @Test
    fun `test complete binary tree`() {
        // 前序遍历：[1,2,4,5,3,6,7]
        // 中序遍历：[4,2,5,1,6,3,7]
        // 预期树：[1,2,3,4,5,6,7]
        val preorder = intArrayOf(1, 2, 4, 5, 3, 6, 7)
        val inorder = intArrayOf(4, 2, 5, 1, 6, 3, 7)

        val result = buildTree(preorder, inorder)
        val expected = createExpectedTree(listOf(1, 2, 3, 4, 5, 6, 7))

        assertTrue(isSameTree(expected, result))
    }

    @Test
    fun `test complex tree with unbalanced structure`() {
        // 前序遍历：[3,1,2,5,4]
        // 中序遍历：[1,2,5,3,4]
        val preorder = intArrayOf(3, 1, 2, 5, 4)
        val inorder = intArrayOf(1, 2, 5, 3, 4)

        val result = buildTree(preorder, inorder)

        val expected = TreeNode(3).apply {
            left = TreeNode(1).apply {
                right = TreeNode(2).apply {
                    right = TreeNode(5)
                }
            }
            right = TreeNode(4)
        }

        assertTrue(isSameTree(expected, result))
    }

    @Test
    fun `test tree with duplicate values`() {
        // 注意：此测试可能不适用于当前实现，因为当前实现假设树中没有重复值
        // 如果需要支持重复值，需要修改算法
        // 这个测试用例仅作为参考
        val preorder = intArrayOf(1, 2, 1)
        val inorder = intArrayOf(2, 1, 1)

        // 由于当前实现使用Map存储值到索引的映射，重复值会导致问题
        assertThrows(Exception::class.java) {
            buildTree(preorder, inorder)
        }
    }
}
