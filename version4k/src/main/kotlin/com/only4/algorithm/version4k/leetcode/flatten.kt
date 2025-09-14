package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.TreeNode

fun flatten(root: TreeNode?) {
    if (root == null) return

    // 保存原左右子树的引用
    val originalLeft = root.left
    val originalRight = root.right

    // 递归展开左右子树
    flatten(originalLeft)
    flatten(originalRight)

    // 将左子树移到右子树位置，左指针置为null
    root.right = originalLeft
    root.left = null

    // 找到当前链表的最右节点
    var rightmostNode = root
    while (rightmostNode?.right != null) {
        rightmostNode = rightmostNode.right!!
    }

    // 将原右子树接到最右节点后面
    rightmostNode.right = originalRight
}
