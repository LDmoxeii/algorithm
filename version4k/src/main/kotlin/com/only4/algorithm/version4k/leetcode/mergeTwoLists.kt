package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.ListNode

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    // 处理边界情况
    if (list1 == null) return list2
    if (list2 == null) return list1

    // 创建哑节点作为新链表的起点
    val dummy = ListNode(0)
    var current = dummy
    var p1 = list1
    var p2 = list2

    // 比较两个链表的节点值，将较小的节点添加到新链表
    while (p1 != null && p2 != null) {
        if (p1.`val` <= p2.`val`) {
            current.next = p1
            p1 = p1.next
        } else {
            current.next = p2
            p2 = p2.next
        }
        current = current.next!!
    }

    // 连接剩余部分
    current.next = p1 ?: p2

    return dummy.next
}

