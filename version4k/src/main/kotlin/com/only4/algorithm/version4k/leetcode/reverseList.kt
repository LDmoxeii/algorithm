package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.ListNode

fun reverseList(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var current = head

    while (current != null) {
        val next = current.next
        current.next = prev
        prev = current
        current = next
    }

    return prev
}
