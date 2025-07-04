package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.TreeNode
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class InvertTreeTest {

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

    /**
     * 辅助函数：判断两个树是否相同
     */
    private fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true
        if (p == null || q == null) return false
        if (p.`val` != q.`val`) return false

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    }

    @Test
    fun `test empty tree`() {
        val root = null

        // 测试递归方法
        val recursiveResult = invertTree(root)
        assertNull(recursiveResult)

        // 测试迭代方法
        val iterativeResult = invertTreeIterative(root)
        assertNull(iterativeResult)
    }

    @Test
    fun `test single node tree`() {
        val root = TreeNode(1)
        val expected = TreeNode(1)

        // 测试递归方法
        val recursiveResult = invertTree(root)
        assertTrue(isSameTree(expected, recursiveResult))

        // 重新创建树进行迭代测试
        val root2 = TreeNode(1)
        val iterativeResult = invertTreeIterative(root2)
        assertTrue(isSameTree(expected, iterativeResult))
    }

    @Test
    fun `test example tree`() {
        // 创建树 [4,2,7,1,3,6,9]
        //      4
        //    /   \
        //   2     7
        //  / \   / \
        // 1   3 6   9
        val root = createTreeFromArray(arrayOf(4, 2, 7, 1, 3, 6, 9))

        // 预期结果 [4,7,2,9,6,3,1]
        //      4
        //    /   \
        //   7     2
        //  / \   / \
        // 9   6 3   1
        val expected = createTreeFromArray(arrayOf(4, 7, 2, 9, 6, 3, 1))

        // 测试递归方法
        val recursiveResult = invertTree(root)
        assertTrue(isSameTree(expected, recursiveResult))

        // 重新创建树进行迭代测试
        val root2 = createTreeFromArray(arrayOf(4, 2, 7, 1, 3, 6, 9))
        val iterativeResult = invertTreeIterative(root2)
        assertTrue(isSameTree(expected, iterativeResult))
    }

    @Test
    fun `test left-skewed tree`() {
        // 创建左倾斜树
        //   1
        //  /
        // 2
        ///
        //3
        val root = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(3)
            }
        }

        // 预期结果
        // 1
        //  \
        //   2
        //    \
        //     3
        val expected = TreeNode(1).apply {
            right = TreeNode(2).apply {
                right = TreeNode(3)
            }
        }

        // 测试递归方法
        val recursiveResult = invertTree(root)
        assertTrue(isSameTree(expected, recursiveResult))

        // 重新创建树进行迭代测试
        val root2 = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(3)
            }
        }
        val iterativeResult = invertTreeIterative(root2)
        assertTrue(isSameTree(expected, iterativeResult))
    }

    @Test
    fun `test right-skewed tree`() {
        // 创建右倾斜树
        // 1
        //  \
        //   2
        //    \
        //     3
        val root = TreeNode(1).apply {
            right = TreeNode(2).apply {
                right = TreeNode(3)
            }
        }

        // 预期结果
        //   1
        //  /
        // 2
        ///
        //3
        val expected = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(3)
            }
        }

        // 测试递归方法
        val recursiveResult = invertTree(root)
        assertTrue(isSameTree(expected, recursiveResult))

        // 重新创建树进行迭代测试
        val root2 = TreeNode(1).apply {
            right = TreeNode(2).apply {
                right = TreeNode(3)
            }
        }
        val iterativeResult = invertTreeIterative(root2)
        assertTrue(isSameTree(expected, iterativeResult))
    }

    @Test
    fun `test asymmetric tree`() {
        // 创建非对称树
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

        // 预期结果
        //     1
        //    / \
        //   3   2
        //  /     \
        // 5       4
        val expected = TreeNode(1).apply {
            left = TreeNode(3).apply {
                left = TreeNode(5)
            }
            right = TreeNode(2).apply {
                right = TreeNode(4)
            }
        }

        // 测试递归方法
        val recursiveResult = invertTree(root)
        assertTrue(isSameTree(expected, recursiveResult))

        // 重新创建树进行迭代测试
        val root2 = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(4)
            }
            right = TreeNode(3).apply {
                right = TreeNode(5)
            }
        }
        val iterativeResult = invertTreeIterative(root2)
        assertTrue(isSameTree(expected, iterativeResult))
    }

    @Test
    fun `test complete binary tree`() {
        // 创建完全二叉树
        //      1
        //     / \
        //    2   3
        //   / \ / \
        //  4  5 6  7
        val root = createTreeFromArray(arrayOf(1, 2, 3, 4, 5, 6, 7))

        // 预期结果
        //      1
        //     / \
        //    3   2
        //   / \ / \
        //  7  6 5  4
        val expected = createTreeFromArray(arrayOf(1, 3, 2, 7, 6, 5, 4))

        // 测试递归方法
        val recursiveResult = invertTree(root)
        assertTrue(isSameTree(expected, recursiveResult))

        // 重新创建树进行迭代测试
        val root2 = createTreeFromArray(arrayOf(1, 2, 3, 4, 5, 6, 7))
        val iterativeResult = invertTreeIterative(root2)
        assertTrue(isSameTree(expected, iterativeResult))
    }

    @Test
    fun `test complex tree with null nodes`() {
        // 创建包含空节点的复杂树
        //       1
        //      / \
        //     2   3
        //    /     \
        //   4       5
        //  / \
        // 6   null
        val root = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(4).apply {
                    left = TreeNode(6)
                }
            }
            right = TreeNode(3).apply {
                right = TreeNode(5)
            }
        }

        // 预期结果
        //       1
        //      / \
        //     3   2
        //    /     \
        //   5       4
        //          / \
        //     null   6
        val expected = TreeNode(1).apply {
            left = TreeNode(3).apply {
                left = TreeNode(5)
            }
            right = TreeNode(2).apply {
                right = TreeNode(4).apply {
                    right = TreeNode(6)
                }
            }
        }

        // 测试递归方法
        val recursiveResult = invertTree(root)
        assertTrue(isSameTree(expected, recursiveResult))

        // 重新创建树进行迭代测试
        val root2 = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(4).apply {
                    left = TreeNode(6)
                }
            }
            right = TreeNode(3).apply {
                right = TreeNode(5)
            }
        }
        val iterativeResult = invertTreeIterative(root2)
        assertTrue(isSameTree(expected, iterativeResult))
    }
}
