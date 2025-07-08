package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.ListNode

/**
 * [24. 两两交换链表中的节点](https://leetcode.com/problems/swap-nodes-in-pairs/)
 *
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 *
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 *
 * 提示：
 * - 链表中节点的数目在范围 [0, 100] 内
 * - 0 <= Node.val <= 100
 *
 * 解题思路：使用递归方法解决此问题。
 * 1. 处理边界情况：当链表为空或只有一个节点时，直接返回原链表
 * 2. 每次处理当前节点和它的下一个节点：
 *    - 保存当前节点(first)、下一个节点(second)和下下个节点(next)
 *    - 递归处理剩余部分的链表
 *    - 重新连接节点，完成两两交换
 *
 * 时间复杂度：O(n)，其中n是链表长度，每个节点只被访问一次
 * 空间复杂度：O(n)，递归栈的空间
 */
fun swapPairs(head: ListNode?): ListNode? {
    // 如果链表为空或只有一个节点，无需交换，直接返回
    if (head?.next == null) return head

    // 定义当前两个需要交换的节点
    val first = head          // 当前节点
    val second = first.next!! // 当前节点的下一个节点
    val next = second.next    // 下一对节点的开始

    // 递归处理剩余链表
    first.next = swapPairs(next)

    // 交换节点连接关系
    second.next = first

    // 返回新的头节点，即原来的第二个节点
    return second
}
