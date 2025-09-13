package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.TreeNode

fun flatten(root: TreeNode?): Unit {
    if (root == null) return

    // 递归展平左子树和右子树
    flatten(root.left)
    flatten(root.right)

    // 保存原右子树
    val originalRight = root.right

    // 将左子树移到右子树位置
    root.right = root.left
    root.left = null

    // 找到新右子树的最右节点
    var current = root
    while (current?.right != null) {
        current = current.right
    }

    // 将原右子树接到新右子树的末尾
    current?.right = originalRight
}
