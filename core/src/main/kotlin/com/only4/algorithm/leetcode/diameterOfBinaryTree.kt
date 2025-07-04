package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.TreeNode

/**
 * [543. 二叉树的直径](https://leetcode.com/problems/diameter-of-binary-tree/)
 *
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个节点路径长度中的最大值。
 * 这条路径可能穿过也可能不穿过根节点。
 *
 * 示例:
 * ```
 * 给定二叉树
 *       1
 *      / \
 *     2   3
 *    / \
 *   4   5
 * ```
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 * 解题思路:
 * 1. 二叉树的直径是指任意两个节点之间的最长路径长度，这条路径可能穿过根节点，也可能不穿过根节点
 * 2. 对于任意一个节点，它的直径 = 左子树的最大深度 + 右子树的最大深度
 * 3. 通过递归计算每个节点的最大深度，同时更新全局最大直径
 * 4. 时间复杂度: O(n)，每个节点只访问一次
 * 5. 空间复杂度: O(h)，h是树的高度，最坏情况下为O(n)
 */
fun diameterOfBinaryTree(root: TreeNode?): Int {
    // 如果根节点为空，则直径为0
    root ?: return 0

    // 使用一个可变变量来存储最大直径
    var maxDiameter = 0

    // 递归计算树的最大深度，同时更新最大直径
    fun maxDepth(node: TreeNode?): Int {
        // 空节点的深度为0
        if (node == null) return 0

        // 计算左子树的最大深度
        val leftDepth = maxDepth(node.left)
        // 计算右子树的最大深度
        val rightDepth = maxDepth(node.right)

        // 更新最大直径
        maxDiameter = maxOf(maxDiameter, leftDepth + rightDepth)

        // 返回当前节点的最大深度
        return maxOf(leftDepth, rightDepth) + 1
    }

    // 开始递归计算
    maxDepth(root)

    return maxDiameter
}
