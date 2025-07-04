package com.only4.algorithm.leetcode

/**
 * 链表节点定义，包含值、指向下一个节点的指针和随机指针
 */
class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}

/**
 * [138. 复制带随机指针的链表](https://leetcode.com/problems/copy-list-with-random-pointer/)
 *
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 *
 * 构造这个链表的深拷贝。深拷贝应该正好由 n 个全新节点组成，其中每个新节点的值都设为其对应的原节点的值。
 * 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。
 * 复制链表中的指针都不应指向原链表中的节点。
 *
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 *
 * 返回复制链表的头节点。
 *
 * 示例 1：
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * 示例 2：
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 *
 * 示例 3：
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 *
 * 解题思路：使用 O(1) 空间复杂度的算法，分三步完成：
 * 1. 在原链表的每个节点后创建一个新节点（值相同，但指针暂时不同）
 * 2. 为新节点的随机指针赋值，利用 original.random.next 找到对应的新节点
 * 3. 将交错的链表分离成原链表和复制链表
 *
 * 时间复杂度：O(n)，其中n是链表长度，需要遍历链表三次
 * 空间复杂度：O(1)，不使用额外空间（除了创建新节点）
 */
fun copyRandomList(head: Node?): Node? {
    // 边界情况：空链表
    head ?: return null

    // 步骤1：在每个原节点后创建一个新节点
    var current = head
    while (current != null) {
        // 创建新节点，值与原节点相同
        val copyNode = Node(current.`val`).apply {
            // 新节点的next指向原节点的next
            next = current.next
        }

        // 将原节点的next指向新节点，形成交错链表
        val next = current.next
        current.next = copyNode
        current = next
    }

    // 步骤2：处理随机指针
    current = head
    while (current != null) {
        // 设置新节点的random指针
        // 如果原节点的random不为空，新节点的random指向原节点random的下一个节点（即复制节点）
        current.next!!.random = current.random?.next
        // 移动到下一个原节点
        current = current.next!!.next
    }

    // 步骤3：分离原链表和复制链表
    val dummyHead = Node(0).apply { next = head.next }
    current = head

    while (current != null) {
        // 当前节点对应的复制节点
        val copyNode = current.next

        // 恢复原链表的连接
        current.next = copyNode?.next

        // 保持复制链表的连接
        copyNode?.next = copyNode?.next?.next

        // 移动到原链表的下一个节点
        current = current.next
    }

    // 返回复制链表的头节点
    return dummyHead.next
}
