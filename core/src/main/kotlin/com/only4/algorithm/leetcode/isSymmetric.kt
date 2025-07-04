package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.TreeNode

/**
 * [101. 对称二叉树](https://leetcode.com/problems/symmetric-tree/)
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 示例:
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 解题思路:
 * 采用递归方法，对左右子树进行对称比较：
 * 1. 如果两个节点都为空，返回true
 * 2. 如果两个节点值相等，则递归比较：
 *    - 左子树的左节点与右子树的右节点
 *    - 左子树的右节点与右子树的左节点
 * 3. 如果以上条件不满足，返回false
 *
 * 时间复杂度: O(n)，其中n是树中节点的个数
 * 空间复杂度: O(h)，其中h是树的高度，最坏情况下为O(n)
 */
fun isSymmetric(root: TreeNode?): Boolean {
    // 空树是对称的
    root ?: return true

    // 内部递归函数，用于比较左右子树是否镜像对称
    fun isMirror(left: TreeNode?, right: TreeNode?): Boolean {
        // 两个节点都为空，对称
        if (left == null && right == null) return true

        // 一个为空另一个不为空，或者值不相等，不对称
        if (left == null || right == null || left.`val` != right.`val`) return false

        // 递归检查外侧节点和内侧节点是否对称
        return isMirror(left.left, right.right) && isMirror(left.right, right.left)
    }

    // 从根节点的左右子树开始检查
    return isMirror(root.left, root.right)
}

/**
 * 迭代方式实现对称二叉树的检查
 * 使用队列进行层序遍历，每次从队列中取出两个节点进行比较
 *
 * 时间复杂度: O(n)，其中n是树中节点的个数
 * 空间复杂度: O(n)，队列中最多存储n个节点
 */
fun isSymmetricIterative(root: TreeNode?): Boolean {
    // 空树是对称的
    root ?: return true

    // 使用队列存储需要比较的节点对
    val queue = ArrayDeque<TreeNode?>()

    // 将根节点的左右子树入队
    queue.addLast(root.left)
    queue.addLast(root.right)

    // 队列不为空时，继续比较
    while (queue.isNotEmpty()) {
        // 每次取出两个节点进行比较
        val left = queue.removeFirst()
        val right = queue.removeFirst()

        // 两个节点都为空，继续比较下一对
        if (left == null && right == null) continue

        // 一个为空另一个不为空，或者值不相等，不对称
        if (left == null || right == null || left.`val` != right.`val`) return false

        // 将左节点的左子节点和右节点的右子节点入队（外侧比较）
        queue.addLast(left?.left)
        queue.addLast(right?.right)

        // 将左节点的右子节点和右节点的左子节点入队（内侧比较）
        queue.addLast(left?.right)
        queue.addLast(right?.left)
    }

    // 所有节点对都比较完毕且对称
    return true
}
