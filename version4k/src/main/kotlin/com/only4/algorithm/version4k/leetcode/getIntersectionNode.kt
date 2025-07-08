package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.ListNode

/**
 * [160. 相交链表](https://leetcode.com/problems/intersection-of-two-linked-lists/)
 *
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 * 解题思路：
 * 使用双指针法。两个指针分别从链表A和链表B的头部开始遍历。
 * 当一个指针到达链表末尾时，将其重定向到另一个链表的头部继续遍历。
 * 这样，当两个指针相遇时，它们要么在相交点，要么同时为null（表示没有相交点）。
 * 这种方法可以确保两个指针走过相同的距离：链表A的长度 + 链表B的长度。
 *
 * 时间复杂度：O(m+n)，其中m和n分别是两个链表的长度
 * 空间复杂度：O(1)
 */
fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
    var pointerA = headA;
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
