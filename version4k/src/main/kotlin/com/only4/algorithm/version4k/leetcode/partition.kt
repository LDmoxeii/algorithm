package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.ListNode

fun partition(s: String): List<List<String>> {
    val result = mutableListOf<List<String>>()
    val path = mutableListOf<String>()

    fun isPalindrome(start: Int, end: Int): Boolean {
        var left = start
        var right = end
        while (left < right) {
            if (s[left++] != s[right--]) return false
        }
        return true
    }

    fun backtrack(startIndex: Int) {
        if (startIndex == s.length) {
            result.add(path.toList())
            return
        }

        for (endIndex in startIndex until s.length) {
            if (isPalindrome(startIndex, endIndex)) {
                path.add(s.substring(startIndex, endIndex + 1))
                backtrack(endIndex + 1)
                path.removeAt(path.lastIndex)
            }
        }
    }
    backtrack(0)
    return result
}

/**
 * [86. 分隔链表](https://leetcode.com/problems/partition-list/)
 *
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 解题思路：
 * 使用两个哑节点分别作为两个链表的头节点，一个链表存储小于x的节点，另一个链表存储大于等于x的节点。
 * 遍历原链表，根据节点值的大小将其连接到对应的链表中。
 * 最后将小值链表的尾部与大值链表的头部相连。
 *
 * 时间复杂度：O(n)，其中n是链表长度
 * 空间复杂度：O(1)，只使用了常数额外空间
 */
fun partition(head: ListNode?, x: Int): ListNode? {
    // 处理空链表的情况
    head ?: return null

    // 创建两个哑节点作为两个链表的头节点
    val smallerHead = ListNode(-10) // 存储小于x的节点
    val greaterHead = ListNode(-20) // 存储大于等于x的节点

    var current = head
    var smallerTail = smallerHead
    var greaterTail = greaterHead

    // 遍历原链表，根据节点值的大小将其连接到对应的链表中
    while (current != null) {
        val next = current.next

        if (current.`val` < x) {
            // 将当前节点连接到小值链表
            smallerTail.next = current
            smallerTail = current
        } else {
            // 将当前节点连接到大值链表
            greaterTail.next = current
            greaterTail = current
        }

        current = next
    }

    // 将小值链表的尾部与大值链表的头部相连
    smallerTail.next = greaterHead.next
    // 大值链表的尾部指向null，防止出现环
    greaterTail.next = null

    return smallerHead.next
}
