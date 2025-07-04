package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * 测试 [236. 二叉树的最近公共祖先](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)
 */
class LowestCommonAncestorTest {

    /**
     * 测试示例 1:
     * ```
     *       3
     *      / \
     *     5   1
     *    / \ / \
     *   6  2 0  8
     *     / \
     *    7   4
     * ```
     * p = 5, q = 1, 最近公共祖先是 3
     */
    @Test
    @DisplayName("测试示例 1: p 和 q 分别在不同子树")
    fun testExample1() {
        // 构建二叉树
        val root = TreeNode(3)
        val node5 = TreeNode(5)
        val node1 = TreeNode(1)
        val node6 = TreeNode(6)
        val node2 = TreeNode(2)
        val node0 = TreeNode(0)
        val node8 = TreeNode(8)
        val node7 = TreeNode(7)
        val node4 = TreeNode(4)

        root.left = node5
        root.right = node1
        node5.left = node6
        node5.right = node2
        node2.left = node7
        node2.right = node4
        node1.left = node0
        node1.right = node8

        // 执行测试
        val result = lowestCommonAncestor(root, node5, node1)

        // 验证结果
        assertEquals(root, result, "节点 5 和节点 1 的最近公共祖先应该是节点 3")
    }

    /**
     * 测试示例 2:
     * ```
     *       3
     *      / \
     *     5   1
     *    / \ / \
     *   6  2 0  8
     *     / \
     *    7   4
     * ```
     * p = 5, q = 2, 最近公共祖先是 5
     */
    @Test
    @DisplayName("测试示例 2: p 是 q 的祖先")
    fun testExample2() {
        // 构建二叉树
        val root = TreeNode(3)
        val node5 = TreeNode(5)
        val node1 = TreeNode(1)
        val node6 = TreeNode(6)
        val node2 = TreeNode(2)
        val node0 = TreeNode(0)
        val node8 = TreeNode(8)
        val node7 = TreeNode(7)
        val node4 = TreeNode(4)

        root.left = node5
        root.right = node1
        node5.left = node6
        node5.right = node2
        node2.left = node7
        node2.right = node4
        node1.left = node0
        node1.right = node8

        // 执行测试
        val result = lowestCommonAncestor(root, node5, node2)

        // 验证结果
        assertEquals(node5, result, "节点 5 和节点 2 的最近公共祖先应该是节点 5")
    }

    /**
     * 测试示例 3:
     * ```
     *       3
     *      / \
     *     5   1
     *    / \ / \
     *   6  2 0  8
     *     / \
     *    7   4
     * ```
     * p = 6, q = 4, 最近公共祖先是 5
     */
    @Test
    @DisplayName("测试示例 3: p 和 q 在同一子树的不同分支")
    fun testExample3() {
        // 构建二叉树
        val root = TreeNode(3)
        val node5 = TreeNode(5)
        val node1 = TreeNode(1)
        val node6 = TreeNode(6)
        val node2 = TreeNode(2)
        val node0 = TreeNode(0)
        val node8 = TreeNode(8)
        val node7 = TreeNode(7)
        val node4 = TreeNode(4)

        root.left = node5
        root.right = node1
        node5.left = node6
        node5.right = node2
        node2.left = node7
        node2.right = node4
        node1.left = node0
        node1.right = node8

        // 执行测试
        val result = lowestCommonAncestor(root, node6, node4)

        // 验证结果
        assertEquals(node5, result, "节点 6 和节点 4 的最近公共祖先应该是节点 5")
    }

    /**
     * 测试示例 4: 单节点树
     * ```
     *    1
     * ```
     * p = 1, q = 1, 最近公共祖先是 1
     */
    @Test
    @DisplayName("测试示例 4: p 和 q 是同一个节点")
    fun testSameNodes() {
        val root = TreeNode(1)
        val result = lowestCommonAncestor(root, root, root)
        assertEquals(root, result, "当 p 和 q 是同一个节点时，最近公共祖先应该是该节点本身")
    }

    /**
     * 测试示例 5: 空树
     */
    @Test
    @DisplayName("测试示例 5: 空树")
    fun testEmptyTree() {
        val p = TreeNode(1)
        val q = TreeNode(2)
        val result = lowestCommonAncestor(null, p, q)
        assertNull(result, "空树应该返回 null")
    }

    /**
     * 测试示例 6: 线性树
     * ```
     *    1
     *     \
     *      2
     *       \
     *        3
     *         \
     *          4
     *           \
     *            5
     * ```
     * p = 2, q = 5, 最近公共祖先是 2
     */
    @Test
    @DisplayName("测试示例 6: 线性树")
    fun testLinearTree() {
        // 构建线性树
        val node1 = TreeNode(1)
        val node2 = TreeNode(2)
        val node3 = TreeNode(3)
        val node4 = TreeNode(4)
        val node5 = TreeNode(5)

        node1.right = node2
        node2.right = node3
        node3.right = node4
        node4.right = node5

        // 执行测试
        val result = lowestCommonAncestor(node1, node2, node5)

        // 验证结果
        assertEquals(node2, result, "节点 2 和节点 5 的最近公共祖先应该是节点 2")
    }

    /**
     * 测试示例 7: 完全二叉树
     * ```
     *        1
     *       / \
     *      2   3
     *     / \ / \
     *    4  5 6  7
     * ```
     * p = 4, q = 7, 最近公共祖先是 1
     */
    @Test
    @DisplayName("测试示例 7: 完全二叉树")
    fun testCompleteBinaryTree() {
        // 构建完全二叉树
        val node1 = TreeNode(1)
        val node2 = TreeNode(2)
        val node3 = TreeNode(3)
        val node4 = TreeNode(4)
        val node5 = TreeNode(5)
        val node6 = TreeNode(6)
        val node7 = TreeNode(7)

        node1.left = node2
        node1.right = node3
        node2.left = node4
        node2.right = node5
        node3.left = node6
        node3.right = node7

        // 执行测试
        val result = lowestCommonAncestor(node1, node4, node7)

        // 验证结果
        assertEquals(node1, result, "节点 4 和节点 7 的最近公共祖先应该是节点 1")
    }

    /**
     * 测试示例 8: 不平衡二叉树
     * ```
     *        1
     *       / \
     *      2   3
     *     /
     *    4
     *   /
     *  5
     * ```
     * p = 5, q = 3, 最近公共祖先是 1
     */
    @Test
    @DisplayName("测试示例 8: 不平衡二叉树")
    fun testUnbalancedTree() {
        // 构建不平衡二叉树
        val node1 = TreeNode(1)
        val node2 = TreeNode(2)
        val node3 = TreeNode(3)
        val node4 = TreeNode(4)
        val node5 = TreeNode(5)

        node1.left = node2
        node1.right = node3
        node2.left = node4
        node4.left = node5

        // 执行测试
        val result = lowestCommonAncestor(node1, node5, node3)

        // 验证结果
        assertEquals(node1, result, "节点 5 和节点 3 的最近公共祖先应该是节点 1")
    }

    /**
     * 测试示例 9: 节点不在树中的情况
     * ```
     *       3
     *      / \
     *     5   1
     * ```
     * p = 5, q = 不在树中的节点, 最近公共祖先是 5
     *
     * 注意：LeetCode 题目假设所有节点都在树中，但我们仍然测试这种情况以确保代码健壮性
     */
    @Test
    @DisplayName("测试示例 9: 一个节点不在树中")
    fun testNodeNotInTree() {
        // 构建二叉树
        val root = TreeNode(3)
        val node5 = TreeNode(5)
        val node1 = TreeNode(1)

        root.left = node5
        root.right = node1

        val nodeNotInTree = TreeNode(999)

        // 执行测试
        val result = lowestCommonAncestor(root, node5, nodeNotInTree)

        // 验证结果
        // 注意：由于我们的实现方式，如果节点不在树中，结果可能不准确
        // 这个测试主要是确保函数不会抛出异常
        assertEquals(node5, result, "当一个节点不在树中时，应返回另一个节点")
    }
}
