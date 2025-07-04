package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class SortedArrayToBSTTest {

    /**
     * 判断二叉树是否是高度平衡的
     */
    private fun isBalanced(root: TreeNode?): Boolean {
        if (root == null) return true

        // 计算树的高度
        fun height(node: TreeNode?): Int {
            if (node == null) return 0
            return maxOf(height(node.left), height(node.right)) + 1
        }

        // 获取左右子树高度
        val leftHeight = height(root.left)
        val rightHeight = height(root.right)

        // 判断当前节点是否平衡（高度差不超过1）且左右子树也是平衡的
        return Math.abs(leftHeight - rightHeight) <= 1 &&
                isBalanced(root.left) &&
                isBalanced(root.right)
    }

    /**
     * 判断是否是二叉搜索树
     */
    private fun isValidBST(root: TreeNode?): Boolean {
        fun validate(node: TreeNode?, min: Int?, max: Int?): Boolean {
            if (node == null) return true

            // 判断当前节点值是否在合法范围内
            if ((min != null && node.`val` <= min) || (max != null && node.`val` >= max)) {
                return false
            }

            // 递归验证左子树（所有节点值必须小于当前节点）和右子树（所有节点值必须大于当前节点）
            return validate(node.left, min, node.`val`) &&
                    validate(node.right, node.`val`, max)
        }

        return validate(root, null, null)
    }

    /**
     * 判断树中是否包含数组中的所有元素
     */
    private fun containsAllElements(root: TreeNode?, nums: IntArray): Boolean {
        // 将树中节点转为列表
        val treeNodes = mutableListOf<Int>()

        fun inorderTraversal(node: TreeNode?) {
            if (node == null) return
            inorderTraversal(node.left)
            treeNodes.add(node.`val`)
            inorderTraversal(node.right)
        }

        inorderTraversal(root)

        // 比较树中的元素和原数组是否匹配
        if (treeNodes.size != nums.size) return false
        return treeNodes.sorted() == nums.sorted()
    }

    @Test
    fun `test empty array`() {
        val nums = intArrayOf()
        val root = sortedArrayToBST(nums)
        assertNull(root)
    }

    @Test
    fun `test single element array`() {
        val nums = intArrayOf(5)
        val root = sortedArrayToBST(nums)

        assertEquals(5, root?.`val`)
        assertNull(root?.left)
        assertNull(root?.right)

        // 确认是有效的BST
        assert(isValidBST(root))
    }

    @Test
    fun `test leetcode example 1`() {
        val nums = intArrayOf(-10, -3, 0, 5, 9)
        val root = sortedArrayToBST(nums)

        // 验证树是高度平衡的
        assert(isBalanced(root))

        // 验证是有效的BST
        assert(isValidBST(root))

        // 验证包含所有原始元素
        assert(containsAllElements(root, nums))
    }

    @Test
    fun `test leetcode example 2`() {
        val nums = intArrayOf(1, 3)
        val root = sortedArrayToBST(nums)

        // 验证树是高度平衡的
        assert(isBalanced(root))

        // 验证是有效的BST
        assert(isValidBST(root))

        // 验证包含所有原始元素
        assert(containsAllElements(root, nums))
    }

    @Test
    fun `test larger sorted array`() {
        val nums = intArrayOf(-100, -50, -20, 0, 20, 50, 100, 200, 300)
        val root = sortedArrayToBST(nums)

        // 验证树是高度平衡的
        assert(isBalanced(root))

        // 验证是有效的BST
        assert(isValidBST(root))

        // 验证包含所有原始元素
        assert(containsAllElements(root, nums))
    }

    @Test
    fun `test consecutive integers`() {
        val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val root = sortedArrayToBST(nums)

        // 验证树是高度平衡的
        assert(isBalanced(root))

        // 验证是有效的BST
        assert(isValidBST(root))

        // 验证包含所有原始元素
        assert(containsAllElements(root, nums))
    }

    @Test
    fun `test negative numbers only`() {
        val nums = intArrayOf(-10, -9, -8, -7, -6, -5, -4)
        val root = sortedArrayToBST(nums)

        // 验证树是高度平衡的
        assert(isBalanced(root))

        // 验证是有效的BST
        assert(isValidBST(root))

        // 验证包含所有原始元素
        assert(containsAllElements(root, nums))
    }
}
