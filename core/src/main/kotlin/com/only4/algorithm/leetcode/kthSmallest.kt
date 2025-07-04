package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.TreeNode

/**
 * [230. 二叉搜索树中第K小的元素](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)
 *
 * 给定一个二叉搜索树的根节点 root，和一个整数 k，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *
 * 示例 1：
 * ```
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * ```
 *
 * 示例 2：
 * ```
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 * ```
 *
 * 解题思路:
 * 1. 利用二叉搜索树的特性，中序遍历（左-根-右）可以得到一个升序序列
 * 2. 使用中序遍历，当访问到第k个节点时，即为所求结果
 * 3. 采用迭代方式实现中序遍历，可以在找到第k个元素时立即返回
 * 4. 时间复杂度: O(H + k)，其中H是树的高度，最坏情况下为O(N)
 * 5. 空间复杂度: O(H)，栈的空间，最坏情况下为O(N)
 */
fun kthSmallest(root: TreeNode?, k: Int): Int {
    // 特殊情况处理
    if (root == null) return -1

    // 使用栈进行中序遍历
    val stack = ArrayDeque<TreeNode>()
    var current = root
    var count = 0

    // 迭代进行中序遍历
    while (current != null || stack.isNotEmpty()) {
        // 将所有左子节点入栈
        while (current != null) {
            stack.addLast(current)
            current = current.left
        }

        // 弹出栈顶节点并访问
        current = stack.removeLast()
        count++

        // 如果已经找到第k小的元素，返回其值
        if (count == k) {
            return current.`val`
        }

        // 处理右子树
        current = current.right
    }

    return -1 // 如果k大于树中节点数量（这种情况在题目中不会出现）
}
