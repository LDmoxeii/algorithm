package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.ListNode

fun detectCycle(head: ListNode?): ListNode? {
    if (head?.next == null) return null

    var slow = head
    var fast = head

    // 第一阶段：检测是否有环
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next

        if (slow === fast) break
    }

    // 如果fast为空或fast.next为空，说明没有环
    if (fast?.next == null) return null

    // 第二阶段：找环的入口
    slow = head
    while (slow !== fast) {
        slow = slow?.next
        fast = fast?.next
    }

    return slow
}
