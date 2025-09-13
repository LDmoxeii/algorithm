package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.ListNode

fun sortList(head: ListNode?): ListNode? {
    head?.next ?: return head

    fun findMiddle(head: ListNode): ListNode {
        var slow = head
        var fast = head.next

        while (fast?.next != null) {
            slow = slow.next!!
            fast = fast.next?.next
        }

        val mid = slow.next!!
        slow.next = null
        return mid
    }

    fun merge(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var current = dummy
        var left = l1
        var right = l2

        while (left != null && right != null) {
            if (left.`val` <= right.`val`) {
                current.next = left
                left = left.next
            } else {
                current.next = right
                right = right.next
            }
            current = current.next!!
        }

        current.next = left ?: right
        return dummy.next
    }

    val mid = findMiddle(head)
    val left = sortList(head)
    val right = sortList(mid)

    return merge(left, right)
}
