package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.TreeNode

/**
 * [98. 验证二叉搜索树](https://leetcode.com/problems/validate-binary-search-tree/)
 *
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效二叉搜索树定义如下：
 * - 节点的左子树只包含 小于 当前节点的数。
 * - 节点的右子树只包含 大于 当前节点的数。
 * - 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 示例 1：
 * ```
 * 输入：root = [2,1,3]
 * 输出：true
 * ```
 *
 * 示例 2：
 * ```
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是5，但是右子节点的值是4。
 * ```
 *
 * 解题思路：
 * 1. 使用递归+范围检查的方法验证二叉搜索树
 * 2. 对于每个节点，维护一个有效值的范围（下限和上限）
 * 3. 左子树中的所有节点值必须小于当前节点值（上限），右子树中的所有节点值必须大于当前节点值（下限）
 * 4. 递归地验证左右子树，同时更新它们的有效值范围
 * 5. 使用Long类型的范围值来处理整数边界情况
 *
 * 时间复杂度: O(n)，其中n是树中的节点数，每个节点最多被访问一次
 * 空间复杂度: O(h)，其中h是树的高度，最坏情况下为O(n)
 */
fun isValidBST(root: TreeNode): Boolean {
    // 使用辅助函数递归检查，传入有效值范围
    fun validate(node: TreeNode?, range: LongRange): Boolean {
        // 空节点符合BST定义
        node ?: return true

        // 检查左子节点值是否在有效范围内（小于当前节点值）
        val leftValid = node.left?.let { it.`val` in range.first..node.`val` - 1L } != false
        // 检查右子节点值是否在有效范围内（大于当前节点值）
        val rightValid = node.right?.let { it.`val` in node.`val` + 1L..range.last } != false

        // 当前子树有效的条件：当前节点有效 && 左子树有效 && 右子树有效
        return leftValid && rightValid &&
                validate(node.left, range.first..node.`val` - 1L) &&
                validate(node.right, node.`val` + 1L..range.last)
    }

    // 初始调用，使用Long的最小值和最大值作为范围，避免整数溢出问题
    return validate(root, Long.MIN_VALUE + 1L..Long.MAX_VALUE - 1L)
}
