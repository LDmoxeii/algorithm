package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.ListNode

fun middleNode(head: ListNode?): ListNode? {
    var (slow, fast) = head to head

    while (fast?.next != null) {
        fast = fast.next!!.next
        slow = slow!!.next
    }
    return slow
}
