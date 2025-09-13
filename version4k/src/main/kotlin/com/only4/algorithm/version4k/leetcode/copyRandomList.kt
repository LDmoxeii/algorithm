package com.only4.algorithm.version4k.leetcode

/**
 * 链表节点定义，包含值、指向下一个节点的指针和随机指针
 */
class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}

fun copyRandomList(head: Node?): Node? {
    head ?: return null

    // 步骤1：在每个原节点后创建一个新节点
    var current = head
    while (current != null) {
        val copyNode = Node(current.`val`).apply {
            next = current.next
        }

        val next = current.next
        current.next = copyNode
        current = next
    }

    // 步骤2：处理随机指针
    current = head
    while (current != null) {
        current.next!!.random = current.random?.next
        current = current.next!!.next
    }

    // 步骤3：分离原链表和复制链表
    val dummyHead = Node(0).apply { next = head.next }
    current = head

    while (current != null) {
        val copyNode = current.next
        current.next = copyNode?.next
        copyNode?.next = copyNode?.next?.next
        current = current.next
    }

    return dummyHead.next
}
