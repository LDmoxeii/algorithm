package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.TreeNode
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class IsSymmetricTest {

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

        // 空树是对称的
        assertTrue(isSymmetric(root))
        assertTrue(isSymmetricIterative(root))
    }

    @Test
    fun `test single node tree`() {
        val root = TreeNode(1)

        // 单节点树是对称的
        assertTrue(isSymmetric(root))
        assertTrue(isSymmetricIterative(root))
    }

    @Test
    fun `test symmetric tree example`() {
        // 创建对称树 [1,2,2,3,4,4,3]
        //     1
        //    / \
        //   2   2
        //  / \ / \
        // 3  4 4  3
        val root = createTreeFromArray(arrayOf(1, 2, 2, 3, 4, 4, 3))

        // 验证是否对称
        assertTrue(isSymmetric(root))
        assertTrue(isSymmetricIterative(root))
    }

    @Test
    fun `test asymmetric tree example`() {
        // 创建非对称树 [1,2,2,null,3,null,3]
        //     1
        //    / \
        //   2   2
        //    \   \
        //     3   3
        val root = createTreeFromArray(arrayOf(1, 2, 2, null, 3, null, 3))

        // 验证不是对称的
        assertFalse(isSymmetric(root))
        assertFalse(isSymmetricIterative(root))
    }

    @Test
    fun `test asymmetric tree with different values`() {
        // 创建值不同的非对称树
        //     1
        //    / \
        //   2   3
        //  / \ / \
        // 4  5 6  7
        val root = createTreeFromArray(arrayOf(1, 2, 3, 4, 5, 6, 7))

        // 验证不是对称的
        assertFalse(isSymmetric(root))
        assertFalse(isSymmetricIterative(root))
    }

    @Test
    fun `test complex symmetric tree`() {
        // 创建复杂对称树
        //        1
        //      /   \
        //     2     2
        //    / \   / \
        //   3   4 4   3
        //  / \     / \
        // 5   6   6   5
        val root = createTreeFromArray(arrayOf(1, 2, 2, 3, 4, 4, 3, 5, 6, null, null, null, null, 6, 5))

        // 验证是否对称
        assertTrue(isSymmetric(root))
        assertTrue(isSymmetricIterative(root))
    }

    @Test
    fun `test tree with only left subtree`() {
        // 创建只有左子树的树
        //   1
        //  /
        // 2
        val root = TreeNode(1).apply {
            left = TreeNode(2)
        }

        // 验证不是对称的
        assertFalse(isSymmetric(root))
        assertFalse(isSymmetricIterative(root))
    }

    @Test
    fun `test tree with only right subtree`() {
        // 创建只有右子树的树
        // 1
        //  \
        //   2
        val root = TreeNode(1).apply {
            right = TreeNode(2)
        }

        // 验证不是对称的
        assertFalse(isSymmetric(root))
        assertFalse(isSymmetricIterative(root))
    }

    @Test
    fun `test symmetric in shape but different values`() {
        // 创建形状对称但值不同的树
        //     1
        //    / \
        //   2   2
        //  / \ / \
        // 3  4 5  3
        val root = createTreeFromArray(arrayOf(1, 2, 2, 3, 4, 5, 3))

        // 验证不是对称的
        assertFalse(isSymmetric(root))
        assertFalse(isSymmetricIterative(root))
    }

    @Test
    fun `test deeper asymmetric tree`() {
        // 创建更深层次非对称的树
        //       1
        //      / \
        //     2   2
        //    / \ / \
        //   3  4 4  3
        //  /       /
        // 5       6
        val root = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(3).apply {
                    left = TreeNode(5)
                }
                right = TreeNode(4)
            }
            right = TreeNode(2).apply {
                left = TreeNode(4)
                right = TreeNode(3).apply {
                    left = TreeNode(6)
                }
            }
        }

        // 验证不是对称的
        assertFalse(isSymmetric(root))
        assertFalse(isSymmetricIterative(root))
    }

    @Test
    fun `test balanced symmetric tree`() {
        // 创建平衡对称树
        //        1
        //      /   \
        //     2     2
        //    / \   / \
        //   3   3 3   3
        val root = createTreeFromArray(arrayOf(1, 2, 2, 3, 3, 3, 3))

        // 验证是否对称
        assertTrue(isSymmetric(root))
        assertTrue(isSymmetricIterative(root))
    }

    @Test
    fun `test edge case with negative values`() {
        // 创建带有负值的对称树
        //     1
        //    / \
        //  -2  -2
        //  / \ / \
        // 3  4 4  3
        val root = TreeNode(1).apply {
            left = TreeNode(-2).apply {
                left = TreeNode(3)
                right = TreeNode(4)
            }
            right = TreeNode(-2).apply {
                left = TreeNode(4)
                right = TreeNode(3)
            }
        }

        // 验证是否对称
        assertTrue(isSymmetric(root))
        assertTrue(isSymmetricIterative(root))
    }
}
