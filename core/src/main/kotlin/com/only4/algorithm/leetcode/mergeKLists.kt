package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.ListNode
import java.util.*

/**
 * [23. 合并K个升序链表](https://leetcode.com/problems/merge-k-sorted-lists/)
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 解题思路：
 * 使用优先队列（最小堆）来管理当前所有链表的头节点。
 * 1. 首先将所有链表的头节点（非空）加入优先队列
 * 2. 每次从队列中取出值最小的节点加入结果链表
 * 3. 如果被取出的节点有后继节点，则将其后继节点加入队列
 * 4. 重复步骤2和3，直到队列为空
 *
 * 时间复杂度：O(N log k)，其中N是所有链表中的节点总数，k是链表数量
 * 空间复杂度：O(k)，优先队列中最多同时存在k个节点
 */
fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    // 处理边界情况：空数组直接返回null
    if (lists.isEmpty()) return null

    // 使用虚拟头节点简化链表操作
    val dummy = ListNode(-1)
    var current = dummy

    // 创建优先队列（最小堆），按节点值升序排列
    val priorityQueue = PriorityQueue(compareBy<ListNode> { it.`val` })

    // 将所有非空链表的头节点加入优先队列
    lists.filterNotNull().forEach { priorityQueue.add(it) }

    // 不断从优先队列中取出最小节点并处理
    while (priorityQueue.isNotEmpty()) {
        // 取出当前最小值的节点
        val node = priorityQueue.poll()

        // 将节点连接到结果链表
        current.next = node
        current = node

        // 如果当前节点有后继节点，将其加入优先队列
        node.next?.let { priorityQueue.add(it) }
    }

    return dummy.next
}
