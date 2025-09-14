package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.ListNode
import java.util.*

fun mergeKLists(sortedLists: Array<ListNode?>): ListNode? {
    if (sortedLists.isEmpty()) return null

    val dummyHead = ListNode(0)
    var currentNode = dummyHead

    val minHeap = PriorityQueue(compareBy<ListNode> { it.`val` })

    // 将所有链表的头节点加入最小堆
    sortedLists.filterNotNull().forEach { listHead ->
        minHeap.add(listHead)
    }

    // 不断从堆中取出最小节点构建结果链表
    while (minHeap.isNotEmpty()) {
        val smallestNode = minHeap.poll()
        currentNode.next = smallestNode
        currentNode = smallestNode

        // 如果取出的节点有后继节点，将其加入堆中
        smallestNode.next?.let { nextNode ->
            minHeap.add(nextNode)
        }
    }

    return dummyHead.next
}
