package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.ListNode

/**
 * [234. 回文链表](https://leetcode.com/problems/palindrome-linked-list/)
 *
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 * 输入：head = [1,2,2,1]
 * 输出：true
 *
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：false
 *
 * 解题思路：
 * 1. 使用快慢指针找到链表的中点
 * 2. 反转后半部分链表
 * 3. 比较前半部分和反转后的后半部分是否相同
 *
 * 时间复杂度：O(n)，其中 n 是链表的长度
 * 空间复杂度：O(1)，只使用了常数空间
 */
fun isPalindrome(head: ListNode?): Boolean {
    // 如果链表为空或只有一个节点，则是回文链表
    if (head?.next == null) return true

    // 找到链表的中点
    fun findMiddle(head: ListNode): ListNode {
        var slow = head
        var fast = head
        while (fast.next != null && fast.next?.next != null) {
            slow = slow.next!!
            fast = fast.next!!.next!!
        }
        return slow
    }

    // 反转链表
    fun reverseList(head: ListNode?): ListNode? {
        tailrec fun reverse(prev: ListNode?, curr: ListNode?): ListNode? {
            return when (curr) {
                null -> prev
                else -> reverse(curr, curr.next.also { curr.next = prev })
            }
        }

        return reverse(null, head)
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

    // 恢复链表原始结构（可选）
    middle.next = reverseList(secondHalfHead)

    return result
}

