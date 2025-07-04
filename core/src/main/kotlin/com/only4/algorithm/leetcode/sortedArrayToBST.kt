package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.TreeNode

/**
 * [108. 将有序数组转换为二叉搜索树](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/)
 *
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 * 示例 1：
 * ```
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也是符合题目要求的答案
 * ```
 *
 * 示例 2：
 * ```
 * 输入：nums = [1,3]
 * 输出：[3,1]
 * ```
 *
 * 解题思路：
 * 1. 由于数组已经排序，要构建平衡的BST，我们应选择数组中间的元素作为根节点
 * 2. 数组中间元素左侧的所有元素构建左子树，右侧的所有元素构建右子树
 * 3. 使用递归方法，对左、右子数组分别应用相同的逻辑
 * 4. 每次选择子数组的中间元素作为当前子树的根节点
 * 5. 时间复杂度: O(n)，每个数组元素只访问一次
 * 6. 空间复杂度: O(log n)，递归调用的栈空间
 */
fun sortedArrayToBST(nums: IntArray): TreeNode? {
    // 如果数组为空，返回null
    if (nums.isEmpty()) return null

    // 辅助函数，创建子树
    fun buildTree(start: Int, end: Int): TreeNode? {
        // 如果起始索引大于结束索引，表示无有效元素，返回null
        if (start > end) return null

        // 计算中间位置，避免整数溢出
        val mid = start + (end - start) / 2

        // 创建根节点，使用中间元素值
        return TreeNode(nums[mid]).apply {
            // 递归构建左子树（使用左半部分数组）
            left = buildTree(start, mid - 1)
            // 递归构建右子树（使用右半部分数组）
            right = buildTree(mid + 1, end)
        }
    }

    // 从整个数组开始构建树
    return buildTree(0, nums.lastIndex)
}
