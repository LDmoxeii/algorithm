package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.ListNode

fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
    if (head == null || k == 1) return head

    fun getLength(): Int {
        var length = 0
        var current = head
        while (current != null) {
            current = current.next
            length++
        }
        return length
    }

    fun getKthNode(head: ListNode, k: Int): ListNode {
        var current = head
        repeat(k - 1) {
            current = current.next!!
        }
        return current
    }

    fun reverseKNodes(head: ListNode, k: Int): ListNode {
        var prev: ListNode? = null
        var current: ListNode? = head

        repeat(k) {
            val next = current!!.next
            current.next = prev
            prev = current
            current = next
        }

        return prev!! // 返回反转后的头节点
    }

    val dummy = ListNode(0)
    dummy.next = head

    val totalLength = getLength()
    val groupCount = totalLength / k

    var prevGroupTail = dummy
    var currentGroupHead = head

    // 进行groupCount次反转
    repeat(groupCount) {
        val nextGroupHead = getKthNode(currentGroupHead!!, k).next

        val reversedGroupHead = reverseKNodes(currentGroupHead, k)

        // 连接反转后的组
        prevGroupTail.next = reversedGroupHead
        currentGroupHead.next = nextGroupHead

        // 更新指针，准备处理下一组
        prevGroupTail = currentGroupHead
        currentGroupHead = nextGroupHead
    }

    return dummy.next
}
