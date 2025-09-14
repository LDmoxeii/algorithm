package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.ListNode

fun isPalindrome(head: ListNode?): Boolean {
    if (head?.next == null) return true

    fun findMiddle(head: ListNode): ListNode {
        var slow = head
        var fast = head

        while (fast.next?.next != null) {
            slow = slow.next!!
            fast = fast.next!!.next!!
        }

        return slow
    }

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

    // 找到链表的中点
    val middle = findMiddle(head)

    // 反转后半部分链表
    val secondHalf = reverseList(middle.next)
    val secondHalfHead = secondHalf // 保存用于恢复

    // 比较前半部分和反转后的后半部分
    var isPalindrome = true
    var firstHalf = head
    var secondHalfPtr = secondHalf

    while (secondHalfPtr != null) {
        if (firstHalf?.`val` != secondHalfPtr.`val`) {
            isPalindrome = false
            break
        }
        firstHalf = firstHalf.next
        secondHalfPtr = secondHalfPtr.next
    }

    // 可选：恢复链表原始结构
    // middle.next = reverseList(secondHalfHead)

    return isPalindrome
}

