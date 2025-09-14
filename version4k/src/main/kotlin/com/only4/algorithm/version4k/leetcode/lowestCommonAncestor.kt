package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.TreeNode

fun lowestCommonAncestor(currentNode: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    // 判断点1：基础情况 - 发现LCA候选
    if (currentNode == null || currentNode == p || currentNode == q) {
        return currentNode  // 生成LCA候选并向上传递
    }

    // 递归搜索左右子树
    val leftCandidate = lowestCommonAncestor(currentNode.left, p, q)
    val rightCandidate = lowestCommonAncestor(currentNode.right, p, q)

    return when {
        // 判断点2：分岔点 - p和q分别在左右子树 直接发现LCA
        leftCandidate != null && rightCandidate != null -> {
            currentNode
        }
        // 判断点3：传递点 - 将找到的LCA候选向上传递
        // 只有一个子树找到了LCA，继续向上传递
        else -> {
            leftCandidate ?: rightCandidate
        }
    }
}
