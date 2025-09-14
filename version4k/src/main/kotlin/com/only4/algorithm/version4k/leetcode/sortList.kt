package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.ListNode

fun sortList(head: ListNode?): ListNode? {
    if (head?.next == null) return head

    fun findMiddleAndSplit(head: ListNode): ListNode {
        var slowPointer = head
        var fastPointer = head.next

        while (fastPointer?.next != null) {
            slowPointer = slowPointer.next!!
            fastPointer = fastPointer.next?.next
        }

        val middleNode = slowPointer.next!!
        slowPointer.next = null // 分割链表
        return middleNode
    }

    fun mergeTwoSortedLists(firstList: ListNode?, secondList: ListNode?): ListNode? {
        val dummyHead = ListNode(0)
        var currentNode = dummyHead
        var leftPointer = firstList
        var rightPointer = secondList

        while (leftPointer != null && rightPointer != null) {
            if (leftPointer.`val` <= rightPointer.`val`) {
                currentNode.next = leftPointer
                leftPointer = leftPointer.next
            } else {
                currentNode.next = rightPointer
                rightPointer = rightPointer.next
            }
            currentNode = currentNode.next!!
        }

        currentNode.next = leftPointer ?: rightPointer
        return dummyHead.next
    }

    val middleNode = findMiddleAndSplit(head)
    val leftSorted = sortList(head)
    val rightSorted = sortList(middleNode)

    return mergeTwoSortedLists(leftSorted, rightSorted)
}
