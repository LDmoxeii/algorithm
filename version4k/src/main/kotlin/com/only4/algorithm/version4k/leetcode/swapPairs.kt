package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.ListNode

fun swapPairs(head: ListNode?): ListNode? {
    // 递归终止条件：没有节点或只有一个节点
    if (head?.next == null) return head

    val firstNode = head
    val secondNode = firstNode.next!!
    val remainingNodes = secondNode.next

    // 递归处理后续节点
    firstNode.next = swapPairs(remainingNodes)

    // 交换当前两个节点
    secondNode.next = firstNode

    return secondNode
}
