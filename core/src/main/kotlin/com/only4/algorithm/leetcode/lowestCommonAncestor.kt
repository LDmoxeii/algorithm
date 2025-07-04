package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.TreeNode

/**
 * [236. 二叉树的最近公共祖先](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先（LCA）。
 *
 * 最近公共祖先定义：对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。
 *
 * 算法思路：
 * 1. 如果当前节点为空或等于 p 或 q，则返回当前节点
 * 2. 递归搜索左子树和右子树
 * 3. 如果左右子树分别包含 p 和 q，则当前节点为最近公共祖先
 * 4. 如果只有一个子树包含 p 或 q，则返回该子树的结果
 *
 * 时间复杂度：O(n)，其中 n 是二叉树的节点数
 * 空间复杂度：O(h)，其中 h 是二叉树的高度，最坏情况下为 O(n)
 *
 * @param root 二叉树的根节点
 * @param p 第一个目标节点
 * @param q 第二个目标节点
 * @return 节点 p 和节点 q 的最近公共祖先
 */
fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? = when {
    root == null || root == p || root == q -> root
    else -> {
        val left = lowestCommonAncestor(root.left, p, q)
        val right = lowestCommonAncestor(root.right, p, q)
        when {
            left != null && right != null -> root
            else -> left ?: right
        }
    }
}
