package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.ListNode

fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
    if (headA == null || headB == null) return null

    var pointerA = headA
    var pointerB = headB

    while (pointerA !== pointerB) {
        // 当pointerA到达链表末尾时，重定向到链表B的头部
        pointerA = if (pointerA == null) headB else pointerA.next

        // 当pointerB到达链表末尾时，重定向到链表A的头部
        pointerB = if (pointerB == null) headA else pointerB.next
    }

    // 返回相交节点（如果不存在则为null）
    return pointerA
}
