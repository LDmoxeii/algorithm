package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.ListNode

fun hasCycle(head: ListNode?): Boolean {
    if (head?.next == null) return false

    var slow = head
    var fast = head

    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next

        if (slow === fast) return true
    }

    return false
}
