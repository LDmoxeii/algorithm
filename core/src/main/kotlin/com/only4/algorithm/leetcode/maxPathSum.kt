package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.TreeNode

/**
 * [124. 二叉树中的最大路径和](https://leetcode.com/problems/binary-tree-maximum-path-sum/)
 *
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。
 * 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 * 算法思路：
 * 1. 使用一个可变变量 `result` 来存储和更新全局的最大路径和。
 * 2. 定义一个递归函数 `calculateMaxGain`，用于计算从当前节点出发向下的最大增益（单边路径和）。
 *    - 如果节点为空，增益为 0。
 *    - 递归计算左子树和右子树的最大增益。如果增益为负，则舍弃，记为 0。
 *    - 在当前节点，计算一个新的可能的最大路径和（`leftGain + rightGain + node.val`），
 *      这是一个“拐弯”的路径，并用它来更新全局 `result`。
 *    - 递归函数返回的是从当前节点出发的“直行”路径的最大增益（`node.val + max(leftGain, rightGain)`），
 *      以便上层节点使用。
 * 3. 从根节点开始调用递归函数，最后返回 `result`。
 *
 * 时间复杂度: O(n)，其中 n 是二叉树的节点数，因为我们只遍历每个节点一次。
 * 空间复杂度: O(h)，其中 h 是二叉树的高度，用于存储递归栈。最坏情况下，树是倾斜的，h=n。
 *
 * @param root 二叉树的根节点。
 * @return 二叉树中的最大路径和。
 */
fun maxPathSum(root: TreeNode): Int {
    var result = Int.MIN_VALUE
    fun TreeNode?.calculateMaxGain(): Int = this?.run {
        val leftGain = left.calculateMaxGain().coerceAtLeast(0)
        val rightGain = right.calculateMaxGain().coerceAtLeast(0)

        result = maxOf(result, leftGain + rightGain + `val`)
        `val` + maxOf(leftGain, rightGain)
    } ?: 0
    root.calculateMaxGain()
    return result
}
