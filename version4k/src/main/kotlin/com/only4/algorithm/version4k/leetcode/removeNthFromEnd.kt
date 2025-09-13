package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.ListNode

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    // 创建哑节点，避免删除头节点的特殊处理
    val dummy = ListNode(-1).apply { next = head }

    fun findFromEnd(head: ListNode, k: Int): ListNode {
        var fast = head as ListNode?
        var slow = head

        // 快指针先前进k步
        repeat(k) {
            fast = fast!!.next
        }

        // 快慢指针同时前进，当快指针到达末尾时，慢指针指向倒数第k个节点
        while (fast != null) {
            slow = slow.next!!
            fast = fast.next
        }

        return slow
    }

    // 找到倒数第n+1个节点（要删除节点的前驱）
    val prev = findFromEnd(dummy, n + 1)

    // 删除倒数第n个节点
    prev.next = prev.next?.next

    return dummy.next
}
