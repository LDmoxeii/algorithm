package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxDepthTest {

    @Test
    fun testEmptyTree() {
        val root = null
        assertEquals(0, maxDepth(root))
        assertEquals(0, maxDepthIterative(root))
    }

    @Test
    fun testSingleNodeTree() {
        val root = TreeNode(1)
        assertEquals(1, maxDepth(root))
        assertEquals(1, maxDepthIterative(root))
    }

    @Test
    fun testExample1() {
        // 创建树 [3,9,20,null,null,15,7]
        //     3
        //    / \
        //   9  20
        //     /  \
        //    15   7
        val root = TreeNode(3).apply {
            left = TreeNode(9)
            right = TreeNode(20).apply {
                left = TreeNode(15)
                right = TreeNode(7)
            }
        }
        assertEquals(3, maxDepth(root))
        assertEquals(3, maxDepthIterative(root))
    }

    @Test
    fun testBalancedTree() {
        // 创建平衡树
        //      1
        //     / \
        //    2   3
        //   / \ / \
        //  4  5 6  7
        val root = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(4)
                right = TreeNode(5)
            }
            right = TreeNode(3).apply {
                left = TreeNode(6)
                right = TreeNode(7)
            }
        }
        assertEquals(3, maxDepth(root))
        assertEquals(3, maxDepthIterative(root))
    }

    @Test
    fun testLeftSkewedTree() {
        // 创建左倾斜树
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
        assertEquals(4, maxDepth(root))
        assertEquals(4, maxDepthIterative(root))
    }

    @Test
    fun testRightSkewedTree() {
        // 创建右倾斜树
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
        assertEquals(4, maxDepth(root))
        assertEquals(4, maxDepthIterative(root))
    }

    @Test
    fun testComplexTree() {
        // 创建一个复杂的树
        //       1
        //      / \
        //     2   3
        //    /     \
        //   4       5
        //  / \     /
        // 6   7   8
        //    /
        //   9
        val tree = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(4).apply {
                    left = TreeNode(6)
                    right = TreeNode(7).apply {
                        left = TreeNode(9)
                    }
                }
            }
            right = TreeNode(3).apply {
                right = TreeNode(5).apply {
                    left = TreeNode(8)
                }
            }
        }
        assertEquals(5, maxDepth(tree))
        assertEquals(5, maxDepthIterative(tree))
    }
}
