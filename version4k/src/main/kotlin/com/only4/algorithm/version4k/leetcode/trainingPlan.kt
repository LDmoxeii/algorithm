package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.ListNode

fun trainingPlan(head: ListNode?, cnt: Int): ListNode? {
    ListNode(-1).apply { next = head }.let { dummy ->
        var (slow, fast) = dummy as ListNode? to dummy as ListNode?

        repeat(cnt) { fast = fast!!.next }
        while (fast != null) {
            fast = fast.next
            slow = slow!!.next
        }
        return slow
    }
}
