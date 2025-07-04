package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * 测试 [437. 路径总和 III](https://leetcode.com/problems/path-sum-iii/)
 */
class PathSumTest {

    /**
     * 测试示例 1:
     * ```
     *       10
     *      /  \
     *     5   -3
     *    / \    \
     *   3   2   11
     *  / \   \
     * 3  -2   1
     * ```
     * 目标和为 8，应该返回 3 条路径
     * 1. 5 -> 3
     * 2. 5 -> 2 -> 1
     * 3. -3 -> 11
     */
    @Test
    @DisplayName("测试示例 1: 标准二叉树，目标和为 8")
    fun testExample1() {
        // 构建二叉树
        val root = TreeNode(10).apply {
            left = TreeNode(5).apply {
                left = TreeNode(3).apply {
                    left = TreeNode(3)
                    right = TreeNode(-2)
                }
                right = TreeNode(2).apply {
                    right = TreeNode(1)
                }
            }
            right = TreeNode(-3).apply {
                right = TreeNode(11)
            }
        }

        // 执行测试
        val result = pathSum(root, 8)

        // 验证结果
        assertEquals(3, result, "应该找到 3 条路径和为 8")
    }

    /**
     * 测试示例 2:
     * ```
     *    1
     *   / \
     *  2   3
     * ```
     * 目标和为 3，应该返回 2 条路径
     * 1. 1 -> 2
     * 2. 3
     */
    @Test
    @DisplayName("测试示例 2: 简单二叉树，目标和为 3")
    fun testExample2() {
        // 构建二叉树
        val root = TreeNode(1).apply {
            left = TreeNode(2)
            right = TreeNode(3)
        }

        // 执行测试
        val result = pathSum(root, 3)

        // 验证结果
        assertEquals(2, result, "应该找到 2 条路径和为 3")
    }

    /**
     * 测试示例 3: 空树
     * 任何目标和都应该返回 0 条路径
     */
    @Test
    @DisplayName("测试示例 3: 空树")
    fun testEmptyTree() {
        val result = pathSum(null, 1)
        assertEquals(0, result, "空树应该返回 0 条路径")
    }

    /**
     * 测试示例 4: 单节点树
     * ```
     *    5
     * ```
     * 目标和为 5，应该返回 1 条路径
     */
    @Test
    @DisplayName("测试示例 4: 单节点树，目标和等于节点值")
    fun testSingleNodeTree() {
        val root = TreeNode(5)
        val result = pathSum(root, 5)
        assertEquals(1, result, "单节点树，目标和等于节点值，应该返回 1 条路径")
    }

    /**
     * 测试示例 5: 包含负数的复杂路径
     * ```
     *       1
     *      / \
     *     2  -1
     *    /    \
     *   3     -2
     *  /
     * -3
     * ```
     * 目标和为 0，应该返回 2 条路径
     * 1. 1 -> 2 -> 3 -> -3 (1+2+3-3=3)
     * 2. 1 -> -1 (1-1=0)
     */
    @Test
    @DisplayName("测试示例 5: 包含负数的复杂路径，目标和为 0")
    fun testNegativeValues() {
        // 构建二叉树
        val root = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(3).apply {
                    left = TreeNode(-3)
                }
            }
            right = TreeNode(-1).apply {
                right = TreeNode(-2)
            }
        }

        // 执行测试
        val result = pathSum(root, 0)

        // 验证结果
        assertEquals(2, result)
    }

    /**
     * 测试示例 6: 多条重叠路径
     * ```
     *      10
     *     /
     *    5
     *   /
     *  -3
     *   \
     *    3
     *   /
     *  -8
     * ```
     * 目标和为 7，应该返回 2 条路径
     * 1. 10 -> 5 -> -3 -> 3 -> -8 (10+5-3+3-8=7)
     */
    @Test
    @DisplayName("测试示例 6: 多条重叠路径，目标和为 7")
    fun testOverlappingPaths() {
        // 构建二叉树
        val root = TreeNode(10).apply {
            left = TreeNode(5).apply {
                left = TreeNode(-3).apply {
                    right = TreeNode(3).apply {
                        left = TreeNode(-8)
                    }
                }
            }
        }

        // 执行测试
        val result = pathSum(root, 7)

        // 验证结果
        assertEquals(1, result)
    }

    /**
     * 测试示例 7: 大数值测试
     * ```
     *     1000000000
     *    /          \
     *   1000000000   1000000000
     * ```
     * 目标和为 2000000000，应该返回 1 条路径
     */
    @Test
    @DisplayName("测试示例 7: 大数值测试，目标和为 2000000000")
    fun testLargeValues() {
        // 构建二叉树
        val root = TreeNode(1000000000).apply {
            left = TreeNode(1000000000)
            right = TreeNode(1000000000)
        }

        // 执行测试
        val result = pathSum(root, 2000000000)

        // 验证结果
        assertEquals(2, result)
    }

    /**
     * 测试示例 8: 多条相同值路径
     * ```
     *      5
     *     / \
     *    5   5
     *   / \   \
     *  5   5   5
     * ```
     * 目标和为 15，应该返回 3 条路径
     */
    @Test
    @DisplayName("测试示例 8: 多条相同值路径，目标和为 15")
    fun testMultipleSameValuePaths() {
        // 构建二叉树
        val root = TreeNode(5).apply {
            left = TreeNode(5).apply {
                left = TreeNode(5)
                right = TreeNode(5)
            }
            right = TreeNode(5).apply {
                right = TreeNode(5)
            }
        }

        // 执行测试
        val result = pathSum(root, 15)

        // 验证结果
        assertEquals(3, result, "应该找到 3 条路径和为 15")
    }

    /**
     * 测试示例 9: 零值路径
     * ```
     *      0
     *     / \
     *    0   0
     *   / \   \
     *  0   0   0
     * ```
     * 目标和为 0，应该返回多条路径
     */
    @Test
    @DisplayName("测试示例 9: 零值路径，目标和为 0")
    fun testZeroValuePaths() {
        // 构建二叉树
        val root = TreeNode(0).apply {
            left = TreeNode(0).apply {
                left = TreeNode(0)
                right = TreeNode(0)
            }
            right = TreeNode(0).apply {
                right = TreeNode(0)
            }
        }

        // 执行测试
        val result = pathSum(root, 0)

        // 验证结果
        // 每个节点自身为一条路径，加上各种组合路径
        assertEquals(14, result)
    }
}
