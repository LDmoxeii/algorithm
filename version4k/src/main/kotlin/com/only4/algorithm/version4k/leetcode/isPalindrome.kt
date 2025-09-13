package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.ListNode

fun isPalindrome(head: ListNode?): Boolean {
    if (head?.next == null) return true

    // 找到链表的中点
    fun findMiddle(head: ListNode): ListNode {
        var slow = head
        var fast = head
        while (fast.next?.next != null) {
            slow = slow.next!!
            fast = fast.next!!.next!!
        }
        return slow
    }

    // 反转链表
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

    // 找到中点
    val middle = findMiddle(head)
    // 反转后半部分
    val secondHalfHead = reverseList(middle.next)

    // 比较前半部分和反转后的后半部分
    var firstHalfPtr = head
    var secondHalfPtr = secondHalfHead
    var result = true

    while (secondHalfPtr != null) {
        if (firstHalfPtr?.`val` != secondHalfPtr.`val`) {
            result = false
            break
        }
        firstHalfPtr = firstHalfPtr.next
        secondHalfPtr = secondHalfPtr.next
    }

    // 可选：恢复链表原始结构
    middle.next = reverseList(secondHalfHead)

    return result
}

