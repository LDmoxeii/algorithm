package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DiameterOfBinaryTreeTest {

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
        assertEquals(0, diameterOfBinaryTree(root))
    }

    @Test
    fun `test single node tree`() {
        val root = TreeNode(1)
        assertEquals(0, diameterOfBinaryTree(root))
    }

    @Test
    fun `test example tree`() {
        // 创建示例树
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5
        val root = createTreeFromArray(arrayOf(1, 2, 3, 4, 5))
        assertEquals(3, diameterOfBinaryTree(root))
    }

    @Test
    fun `test left-skewed tree`() {
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
        assertEquals(3, diameterOfBinaryTree(root))
    }

    @Test
    fun `test right-skewed tree`() {
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
        assertEquals(3, diameterOfBinaryTree(root))
    }

    @Test
    fun `test balanced tree`() {
        // 创建平衡树
        //      1
        //     / \
        //    2   3
        //   / \ / \
        //  4  5 6  7
        val root = createTreeFromArray(arrayOf(1, 2, 3, 4, 5, 6, 7))
        assertEquals(4, diameterOfBinaryTree(root))
    }

    @Test
    fun `test asymmetric tree`() {
        // 创建非对称树
        //        1
        //       / \
        //      2   3
        //     /     \
        //    4       5
        //   /         \
        //  6           7
        val root = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(4).apply {
                    left = TreeNode(6)
                }
            }
            right = TreeNode(3).apply {
                right = TreeNode(5).apply {
                    right = TreeNode(7)
                }
            }
        }
        assertEquals(6, diameterOfBinaryTree(root))
    }

    @Test
    fun `test complex tree`() {
        // 创建复杂树
        //         1
        //        / \
        //       2   3
        //      / \   \
        //     4   5   6
        //    /       / \
        //   7       8   9
        //  / \         /
        // 10 11       12
        val root = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(4).apply {
                    left = TreeNode(7).apply {
                        left = TreeNode(10)
                        right = TreeNode(11)
                    }
                }
                right = TreeNode(5)
            }
            right = TreeNode(3).apply {
                right = TreeNode(6).apply {
                    left = TreeNode(8)
                    right = TreeNode(9).apply {
                        left = TreeNode(12)
                    }
                }
            }
        }
        assertEquals(8, diameterOfBinaryTree(root))
    }

    @Test
    fun `test diameter passes through root`() {
        // 创建一棵直径通过根节点的树
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
        assertEquals(4, diameterOfBinaryTree(root))
    }

    @Test
    fun `test diameter does not pass through root`() {
        // 创建一棵直径不通过根节点的树
        //      1
        //     / \
        //    2   3
        //   / \
        //  4   5
        //     / \
        //    6   7
        val root = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(4)
                right = TreeNode(5).apply {
                    left = TreeNode(6)
                    right = TreeNode(7)
                }
            }
            right = TreeNode(3)
        }
        assertEquals(4, diameterOfBinaryTree(root))
    }

    @Test
    fun `test tree with zigzag path`() {
        // 创建一棵有之字形路径的树
        //        1
        //       / \
        //      2   3
        //     /   / \
        //    4   5   6
        //   / \     /
        //  7   8   9
        val root = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(4).apply {
                    left = TreeNode(7)
                    right = TreeNode(8)
                }
            }
            right = TreeNode(3).apply {
                left = TreeNode(5)
                right = TreeNode(6).apply {
                    left = TreeNode(9)
                }
            }
        }
        assertEquals(6, diameterOfBinaryTree(root))
    }
}
