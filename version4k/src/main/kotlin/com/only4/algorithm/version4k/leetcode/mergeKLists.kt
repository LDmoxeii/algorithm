package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.ListNode
import java.util.*

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    if (lists.isEmpty()) return null

    val dummy = ListNode(0)
    var current = dummy

    val priorityQueue = PriorityQueue(compareBy<ListNode> { it.`val` })

    lists.filterNotNull().forEach { priorityQueue.add(it) }

    while (priorityQueue.isNotEmpty()) {
        val node = priorityQueue.poll()
        current.next = node
        current = node

        node.next?.let { priorityQueue.add(it) }
    }

    return dummy.next
}
