package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.TreeNode

/**
 * [114. Flatten Binary Tree to Linked List](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/)
 *
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 1. 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 2. 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 * 解题思路：
 * 这道题可以通过递归、迭代或Morris遍历来解决。以下是递归解法：
 * 1. 递归地将左子树和右子树展平
 * 2. 将原右子树接到左子树的最右节点
 * 3. 将左子树移到右子树的位置
 * 4. 将左子树置为null
 *
 * 时间复杂度：O(n)，其中n是二叉树节点的数量
 * 空间复杂度：O(h)，其中h是二叉树的高度，最坏情况下为O(n)
 *
 * @param root 二叉树的根节点
 */
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

/**
 * 二叉树展平的迭代实现
 *
 * 时间复杂度：O(n)，其中n是二叉树节点的数量
 * 空间复杂度：O(1)，不使用额外的递归栈空间
 *
 * @param root 二叉树的根节点
 */
fun flattenIterative(root: TreeNode?): Unit {
    var current = root

    while (current != null) {
        // 如果当前节点有左子树
        if (current.left != null) {
            // 找到左子树的最右节点
            var rightmost = current.left
            while (rightmost?.right != null) {
                rightmost = rightmost.right
            }

            // 将原右子树接到左子树的最右节点
            rightmost?.right = current.right

            // 将左子树移到右子树位置
            current.right = current.left
            current.left = null
        }

        // 继续处理下一个节点
        current = current.right
    }
}

/**
 * 二叉树展平的Morris遍历实现
 *
 * 时间复杂度：O(n)，其中n是二叉树节点的数量
 * 空间复杂度：O(1)，不使用额外空间
 *
 * @param root 二叉树的根节点
 */
fun flattenMorris(root: TreeNode?): Unit {
    var current = root

    while (current != null) {
        if (current.left != null) {
            // 找到左子树的最右节点
            var predecessor = current.left
            while (predecessor?.right != null) {
                predecessor = predecessor.right
            }

            // 将原右子树接到左子树的最右节点
            predecessor?.right = current.right

            // 将左子树移到右子树位置
            current.right = current.left
            current.left = null
        }

        // 继续处理下一个节点
        current = current.right
    }
}
