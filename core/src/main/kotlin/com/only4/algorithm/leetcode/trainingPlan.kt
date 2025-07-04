package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.ListNode

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
