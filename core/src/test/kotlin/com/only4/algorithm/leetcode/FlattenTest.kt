package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class FlattenTest {

    /**
     * 验证二叉树是否已正确展平为链表
     * 链表应该符合先序遍历的顺序，且所有左子节点为null
     */
    private fun validateFlattenedTree(root: TreeNode?, expectedValues: List<Int>) {
        var current = root
        var index = 0

        while (current != null) {
            // 验证值是否符合预期
            assertEquals(expectedValues[index], current.`val`, "节点值不匹配，位置: $index")

            // 确保左子节点为null
            assertNull(current.left, "节点的左子节点不为null，位置: $index")

            // 移动到下一个节点
            current = current.right
            index++
        }

        // 确保所有预期值都已验证
        assertEquals(expectedValues.size, index, "展平后的树节点数量与预期不符")
    }

    /**
     * 根据数组构建二叉树，null表示空节点
     */
    private fun buildTree(values: List<Int?>): TreeNode? {
        if (values.isEmpty() || values[0] == null) return null

        val root = TreeNode(values[0]!!)
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)

        var i = 1
        while (i < values.size && queue.isNotEmpty()) {
            val node = queue.removeFirst()

            // 左子节点
            if (i < values.size) {
                if (values[i] != null) {
                    node.left = TreeNode(values[i]!!)
                    queue.add(node.left!!)
                }
                i++
            }

            // 右子节点
            if (i < values.size) {
                if (values[i] != null) {
                    node.right = TreeNode(values[i]!!)
                    queue.add(node.right!!)
                }
                i++
            }
        }

        return root
    }

    @Test
    fun `递归方法 - 空树测试`() {
        val root: TreeNode? = null
        flatten(root)
        validateFlattenedTree(root, emptyList())
    }

    @Test
    fun `递归方法 - 单节点树测试`() {
        val root = TreeNode(1)
        flatten(root)
        validateFlattenedTree(root, listOf(1))
    }

    @Test
    fun `递归方法 - 标准示例测试`() {
        // 构建树: [1,2,5,3,4,null,6]
        //      1
        //     / \
        //    2   5
        //   / \   \
        //  3   4   6
        val root = buildTree(listOf(1, 2, 5, 3, 4, null, 6))

        flatten(root)

        // 展平后应该是: 1->2->3->4->5->6
        validateFlattenedTree(root, listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `递归方法 - 左偏树测试`() {
        // 构建树: [1,2,null,3,null,4,null]
        //      1
        //     /
        //    2
        //   /
        //  3
        // /
        //4
        val root = buildTree(listOf(1, 2, null, 3, null, 4, null))

        flatten(root)

        // 展平后应该是: 1->2->3->4
        validateFlattenedTree(root, listOf(1, 2, 3, 4))
    }

    @Test
    fun `递归方法 - 右偏树测试`() {
        // 构建树: [1,null,2,null,3,null,4]
        //      1
        //       \
        //        2
        //         \
        //          3
        //           \
        //            4
        val root = TreeNode(1).also {
            it.right = TreeNode(2).apply {
                right = TreeNode(3).apply {
                    right = TreeNode(4)
                }
            }
        }
        flatten(root)

        // 展平后应该是: 1->2->3->4
        validateFlattenedTree(root, listOf(1, 2, 3, 4))
    }

    @Test
    fun `递归方法 - 复杂树测试`() {
        // 构建树: [5,3,8,1,4,7,9,null,2,null,null,6]
        //        5
        //       / \
        //      3   8
        //     / \  / \
        //    1  4 7   9
        //     \   /
        //      2 6
        val root = buildTree(listOf(5, 3, 8, 1, 4, 7, 9, null, 2, null, null, 6))

        flatten(root)

        // 展平后应该是: 5->3->1->2->4->8->7->6->9
        validateFlattenedTree(root, listOf(5, 3, 1, 2, 4, 8, 7, 6, 9))
    }

    @Test
    fun `迭代方法 - 空树测试`() {
        val root: TreeNode? = null
        flattenIterative(root)
        validateFlattenedTree(root, emptyList())
    }

    @Test
    fun `迭代方法 - 单节点树测试`() {
        val root = TreeNode(1)
        flattenIterative(root)
        validateFlattenedTree(root, listOf(1))
    }

    @Test
    fun `迭代方法 - 标准示例测试`() {
        val root = buildTree(listOf(1, 2, 5, 3, 4, null, 6))
        flattenIterative(root)
        validateFlattenedTree(root, listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `迭代方法 - 左偏树测试`() {
        val root = buildTree(listOf(1, 2, null, 3, null, 4, null))
        flattenIterative(root)
        validateFlattenedTree(root, listOf(1, 2, 3, 4))
    }

    @Test
    fun `迭代方法 - 右偏树测试`() {
        val root = TreeNode(1).also {
            it.right = TreeNode(2).apply {
                right = TreeNode(3).apply {
                    right = TreeNode(4)
                }
            }
        }
        flattenIterative(root)
        validateFlattenedTree(root, listOf(1, 2, 3, 4))
    }

    @Test
    fun `迭代方法 - 复杂树测试`() {
        val root = buildTree(listOf(5, 3, 8, 1, 4, 7, 9, null, 2, null, null, 6))
        flattenIterative(root)
        validateFlattenedTree(root, listOf(5, 3, 1, 2, 4, 8, 7, 6, 9))
    }

    @Test
    fun `Morris方法 - 空树测试`() {
        val root: TreeNode? = null
        flattenMorris(root)
        validateFlattenedTree(root, emptyList())
    }

    @Test
    fun `Morris方法 - 单节点树测试`() {
        val root = TreeNode(1)
        flattenMorris(root)
        validateFlattenedTree(root, listOf(1))
    }

    @Test
    fun `Morris方法 - 标准示例测试`() {
        val root = buildTree(listOf(1, 2, 5, 3, 4, null, 6))
        flattenMorris(root)
        validateFlattenedTree(root, listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `Morris方法 - 左偏树测试`() {
        val root = buildTree(listOf(1, 2, null, 3, null, 4, null))
        flattenMorris(root)
        validateFlattenedTree(root, listOf(1, 2, 3, 4))
    }

    @Test
    fun `Morris方法 - 右偏树测试`() {
        val root = TreeNode(1).also {
            it.right = TreeNode(2).apply {
                right = TreeNode(3).apply {
                    right = TreeNode(4)
                }
            }
        }
        flattenMorris(root)
        validateFlattenedTree(root, listOf(1, 2, 3, 4))
    }

    @Test
    fun `Morris方法 - 复杂树测试`() {
        val root = buildTree(listOf(5, 3, 8, 1, 4, 7, 9, null, 2, null, null, 6))
        flattenMorris(root)
        validateFlattenedTree(root, listOf(5, 3, 1, 2, 4, 8, 7, 6, 9))
    }

    @Test
    fun `比较三种方法结果一致性`() {
        // 构建一个复杂的树进行测试
        val tree1 = buildTree(listOf(5, 3, 8, 1, 4, 7, 9, null, 2, null, null, 6))
        val tree2 = buildTree(listOf(5, 3, 8, 1, 4, 7, 9, null, 2, null, null, 6))
        val tree3 = buildTree(listOf(5, 3, 8, 1, 4, 7, 9, null, 2, null, null, 6))

        // 应用三种不同的方法
        flatten(tree1)
        flattenIterative(tree2)
        flattenMorris(tree3)

        // 验证三种方法的结果是否一致
        val expectedValues = listOf(5, 3, 1, 2, 4, 8, 7, 6, 9)
        validateFlattenedTree(tree1, expectedValues)
        validateFlattenedTree(tree2, expectedValues)
        validateFlattenedTree(tree3, expectedValues)
    }

    @Test
    fun `性能测试 - 大型树`() {
        // 构建一个较大的树
        val values = mutableListOf<Int?>()
        for (i in 1..1000) {
            values.add(i)
        }

        val tree1 = buildTree(values)
        val tree2 = buildTree(values)
        val tree3 = buildTree(values)

        // 测量三种方法的执行时间
        val startTime1 = System.nanoTime()
        flatten(tree1)
        val endTime1 = System.nanoTime()

        val startTime2 = System.nanoTime()
        flattenIterative(tree2)
        val endTime2 = System.nanoTime()

        val startTime3 = System.nanoTime()
        flattenMorris(tree3)
        val endTime3 = System.nanoTime()

        println("递归方法执行时间: ${(endTime1 - startTime1) / 1_000_000} ms")
        println("迭代方法执行时间: ${(endTime2 - startTime2) / 1_000_000} ms")
        println("Morris方法执行时间: ${(endTime3 - startTime3) / 1_000_000} ms")

        // 验证结果是否一致
        var current1 = tree1
        var current2 = tree2
        var current3 = tree3

        while (current1 != null && current2 != null && current3 != null) {
            assertEquals(current1.`val`, current2.`val`)
            assertEquals(current1.`val`, current3.`val`)
            assertNull(current1.left)
            assertNull(current2.left)
            assertNull(current3.left)
            current1 = current1.right
            current2 = current2.right
            current3 = current3.right
        }

        // 确保所有树都已完全遍历
        assertNull(current1)
        assertNull(current2)
        assertNull(current3)
    }
}
