package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.ListNode

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val dummy = ListNode(0)
    var current = dummy
    var carry = 0

    var node1 = l1
    var node2 = l2

    while (node1 != null || node2 != null || carry > 0) {
        // 计算当前位的和
        val sum = (node1?.`val` ?: 0) + (node2?.`val` ?: 0) + carry

        // 更新进位值
        carry = sum / 10

        // 创建新节点并移动指针
        current.next = ListNode(sum % 10)
        current = current.next!!

        // 移动输入链表指针
        node1 = node1?.next
        node2 = node2?.next
    }

    return dummy.next
}
