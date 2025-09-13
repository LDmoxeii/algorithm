package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.ListNode

fun swapPairs(head: ListNode?): ListNode? {
    if (head?.next == null) return head

    val first = head
    val second = first.next!!
    val next = second.next

    first.next = swapPairs(next)
    second.next = first

    return second
}
