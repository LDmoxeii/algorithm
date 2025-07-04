package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * 测试 [124. 二叉树中的最大路径和](https://leetcode.com/problems/binary-tree-maximum-path-sum/)
 */
class MaxPathSumTest {

    /**
     * 测试示例 1:
     * ```
     *       1
     *      / \
     *     2   3
     * ```
     * 最大路径和为 6 (2 -> 1 -> 3)
     */
    @Test
    @DisplayName("测试示例 1: 简单树")
    fun testExample1() {
        // 构建二叉树
        val root = TreeNode(1).apply {
            left = TreeNode(2)
            right = TreeNode(3)
        }

        // 执行测试
        val result = maxPathSum(root)

        // 验证结果
        assertEquals(6, result, "最大路径和应该是 6")
    }

    /**
     * 测试示例 2:
     * ```
     *      -10
     *      / \
     *     9  20
     *       /  \
     *      15   7
     * ```
     * 最大路径和为 42 (15 -> 20 -> 7)
     */
    @Test
    @DisplayName("测试示例 2: 包含负数的树")
    fun testExample2() {
        // 构建二叉树
        val root = TreeNode(-10).apply {
            left = TreeNode(9)
            right = TreeNode(20).apply {
                left = TreeNode(15)
                right = TreeNode(7)
            }
        }

        // 执行测试
        val result = maxPathSum(root)

        // 验证结果
        assertEquals(42, result, "最大路径和应该是 42")
    }

    /**
     * 测试示例 3: 单节点树
     * ```
     *    -3
     * ```
     * 最大路径和为 -3
     */
    @Test
    @DisplayName("测试示例 3: 单节点负数树")
    fun testSingleNegativeNode() {
        val root = TreeNode(-3)
        val result = maxPathSum(root)
        assertEquals(-3, result, "单节点负数树的最大路径和应该是节点本身的值")
    }

    /**
     * 测试示例 4: 路径不经过根节点
     * ```
     *       1
     *      / \
     *    -2   3
     *    / \
     *   4   5
     * ```
     * 最大路径和为 9 (4 -> -2 -> 5)
     */
    @Test
    @DisplayName("测试示例 4: 路径不经过根节点")
    fun testPathWithoutRoot() {
        val root = TreeNode(1).apply {
            left = TreeNode(-2).apply {
                left = TreeNode(4)
                right = TreeNode(5)
            }
            right = TreeNode(3)
        }
        val result = maxPathSum(root)
        assertEquals(7, result)
    }

    /**
     * 测试示例 5: 所有节点都是负数
     * ```
     *      -1
     *      / \
     *    -2  -3
     * ```
     * 最大路径和为 -1
     */
    @Test
    @DisplayName("测试示例 5: 所有节点都是负数")
    fun testAllNegativeNodes() {
        val root = TreeNode(-1).apply {
            left = TreeNode(-2)
            right = TreeNode(-3)
        }
        val result = maxPathSum(root)
        assertEquals(-1, result, "所有节点都是负数时，最大路径和是值最大的那个节点")
    }

    /**
     * 测试示例 6: 线性树
     * ```
     *      1
     *       \
     *        2
     *         \
     *          3
     * ```
     * 最大路径和为 6 (1 -> 2 -> 3)
     */
    @Test
    @DisplayName("测试示例 6: 线性树")
    fun testLinearTree() {
        val root = TreeNode(1).apply {
            right = TreeNode(2).apply {
                right = TreeNode(3)
            }
        }
        val result = maxPathSum(root)
        assertEquals(6, result, "线性树的最大路径和应该是所有节点之和")
    }

    /**
     * 测试示例 7: 复杂路径
     * ```
     *       5
     *      / \
     *     4   8
     *    /   / \
     *   11  13  4
     *  /  \      \
     * 7    2      1
     * ```
     * 最大路径和为 48 (7 -> 11 -> 4 -> 5 -> 8 -> 13)
     */
    @Test
    @DisplayName("测试示例 7: 复杂路径")
    fun testComplexTree() {
        val root = TreeNode(5).apply {
            left = TreeNode(4).apply {
                left = TreeNode(11).apply {
                    left = TreeNode(7)
                    right = TreeNode(2)
                }
            }
            right = TreeNode(8).apply {
                left = TreeNode(13)
                right = TreeNode(4).apply {
                    right = TreeNode(1)
                }
            }
        }
        val result = maxPathSum(root)
        assertEquals(48, result, "复杂路径测试失败")
    }
}
