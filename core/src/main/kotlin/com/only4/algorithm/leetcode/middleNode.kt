package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.ListNode

fun middleNode(head: ListNode?): ListNode? {
    var (slow, fast) = head to head

    while (fast?.next != null) {
        fast = fast.next!!.next
        slow = slow!!.next
    }
    return slow
}
