package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.ListNode

/**
 * 2. 两数相加
 *
 * 给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 *
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 * 解题思路：
 * 1. 由于链表是逆序存储的，所以可以直接从头开始遍历两个链表，同时计算对应位置的和
 * 2. 使用一个变量carry记录进位，初始值为0
 * 3. 遍历两个链表，对于每一位计算两个链表对应位置的和加上进位值
 * 4. 计算当前位的值（sum % 10）和新的进位值（sum / 10）
 * 5. 创建一个新节点存储当前位的值，并将其添加到结果链表中
 * 6. 继续遍历直到两个链表都遍历完且没有进位
 * 7. 返回结果链表的头节点
 *
 * 时间复杂度：O(max(m,n))，其中m和n分别为两个链表的长度
 * 空间复杂度：O(max(m,n))，新链表的长度最多为max(m,n) + 1
 *
 * @param l1 第一个非空链表，表示一个非负整数，逆序存储
 * @param l2 第二个非空链表，表示一个非负整数，逆序存储
 * @return 表示两数之和的链表，逆序存储
 */
fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val dummy = ListNode(0);
    var current = dummy;
    var carry = 0

    var node1 = l1;
    var node2 = l2

    while (node1 != null || node2 != null || carry > 0) {
        // 计算当前位的和
        val sum = (node1?.`val` ?: 0) + (node2?.`val` ?: 0) + carry

        // 更新进位值
        carry = sum / 10

        // 创建新节点并移动指针
        current.next = ListNode(sum % 10)
        current = current.next!!

        // 移动输入链表指针
        node1 = node1?.next
        node2 = node2?.next
    }

    return dummy.next
}
