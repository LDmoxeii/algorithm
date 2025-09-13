package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.ListNode

fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
    if (head == null || k == 1) return head

    val dummy = ListNode(0).apply { next = head }

    // 计算链表长度
    var counter = head
    var count = 0
    while (counter != null) {
        count++
        counter = counter.next
    }

    var prev = dummy

    // 进行count/k次翻转
    repeat(count / k) {
        val first = prev.next

        // 翻转k个节点
        var current = first
        var previous: ListNode? = null

        repeat(k) {
            val next = current!!.next
            current.next = previous
            previous = current
            current = next
        }

        // 连接翻转后的子链表
        first!!.next = current
        prev.next = previous
        prev = first
    }

    return dummy.next
}
