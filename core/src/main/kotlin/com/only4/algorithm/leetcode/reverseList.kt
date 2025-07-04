package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.ListNode

/**
 * [206. 反转链表](https://leetcode.com/problems/reverse-linked-list/)
 *
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 *
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 *
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 *
 * 解题思路：使用尾递归方法实现链表反转，保持O(n)时间复杂度和O(1)空间复杂度（尾递归编译器会优化为迭代）。
 * 通过两个指针prev和curr遍历链表，每次迭代将当前节点的next指针指向前一个节点，
 * 同时记录下一个要处理的节点，实现指针反转。
 */
fun reverseList(head: ListNode?): ListNode? {
    tailrec fun reverse(prev: ListNode?, curr: ListNode?): ListNode? {
        return when (curr) {
            null -> prev // 当前节点为空，说明已到链表尾部，返回prev作为新的头结点
            else -> reverse(curr, curr.next.also { curr.next = prev }) // 反转指针并继续递归
        }
    }

    return reverse(null, head)
}
