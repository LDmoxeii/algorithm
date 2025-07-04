package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.TreeNode
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class IsValidBSTTest {

    @Test
    fun `test empty tree`() {
        // 空树被视为有效的BST
        val root = null
        assertTrue(isValidBST(TreeNode(0).apply { left = root }))
    }

    @Test
    fun `test single node tree`() {
        // 单节点树总是有效的BST
        val root = TreeNode(1)
        assertTrue(isValidBST(root))
    }

    @Test
    fun `test valid BST - example 1`() {
        // 构建树 [2,1,3]
        val root = TreeNode(2).apply {
            left = TreeNode(1)
            right = TreeNode(3)
        }
        assertTrue(isValidBST(root))
    }

    @Test
    fun `test invalid BST - example 2`() {
        // 构建树 [5,1,4,null,null,3,6]
        val root = TreeNode(5).apply {
            left = TreeNode(1)
            right = TreeNode(4).apply {
                left = TreeNode(3)
                right = TreeNode(6)
            }
        }
        // 根节点的值是5，但是右子节点的值是4，不满足BST定义
        assertFalse(isValidBST(root))
    }

    @Test
    fun `test valid balanced BST`() {
        // 构建一个平衡的BST [4,2,6,1,3,5,7]
        val root = TreeNode(4).apply {
            left = TreeNode(2).apply {
                left = TreeNode(1)
                right = TreeNode(3)
            }
            right = TreeNode(6).apply {
                left = TreeNode(5)
                right = TreeNode(7)
            }
        }
        assertTrue(isValidBST(root))
    }

    @Test
    fun `test invalid BST - right subtree contains smaller value`() {
        // 构建树 [10,5,15,null,null,6,20]
        val root = TreeNode(10).apply {
            left = TreeNode(5)
            right = TreeNode(15).apply {
                left = TreeNode(6)  // 违反BST规则：右子树中的节点值6小于根节点值10
                right = TreeNode(20)
            }
        }
        assertFalse(isValidBST(root))
    }

    @Test
    fun `test invalid BST - left subtree contains larger value`() {
        // 构建树 [10,5,15,null,12,null,null]
        val root = TreeNode(10).apply {
            left = TreeNode(5).apply {
                right = TreeNode(12)  // 违反BST规则：左子树中的节点值12大于根节点值10
            }
            right = TreeNode(15)
        }
        assertFalse(isValidBST(root))
    }

    @Test
    fun `test BST with duplicate values`() {
        // 构建树 [2,1,2]
        val root = TreeNode(2).apply {
            left = TreeNode(1)
            right = TreeNode(2)  // 重复值不满足BST定义（右子树应该严格大于根节点）
        }
        assertFalse(isValidBST(root))
    }

    @Test
    fun `test BST with integer limits`() {
        // 测试整数边界情况
        val root = TreeNode(Int.MAX_VALUE).apply {
            left = TreeNode(0)
        }
        assertTrue(isValidBST(root))
    }
} 