package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.ListNode

/**
 * [21. 合并两个有序链表](https://leetcode.com/problems/merge-two-sorted-lists/)
 *
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例 1：
 * 输入：list1 = [1,2,4], list2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 示例 2：
 * 输入：list1 = [], list2 = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：list1 = [], list2 = [0]
 * 输出：[0]
 *
 * 解题思路：使用迭代法，创建一个哑节点(dummy node)作为新链表的起点。
 * 使用两个指针分别指向两个链表的当前节点，比较两个节点的值，将较小的节点添加到新链表中，
 * 并将对应指针向前移动。当其中一个链表遍历完后，将另一个链表的剩余部分直接连接到新链表的末尾。
 *
 * 时间复杂度：O(n+m)，其中n和m分别为两个链表的长度
 * 空间复杂度：O(1)，只使用了常数级别的额外空间
 */
fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    // 处理边界情况
    if (list1 == null) return list2
    if (list2 == null) return list1

    // 创建哑节点作为新链表的起点
    val dummy = ListNode(0)
    var current = dummy
    var p1 = list1
    var p2 = list2

    // 比较两个链表的节点值，将较小的节点添加到新链表
    while (p1 != null && p2 != null) {
        if (p1.`val` < p2.`val`) {
            current.next = p1
            p1 = p1.next
        } else {
            current.next = p2
            p2 = p2.next
        }
        current = current.next!!
    }

    // 连接剩余部分
    current.next = p1 ?: p2

    return dummy.next
}

