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

    fun createCopyNodes() {
        var current: Node? = head
        while (current != null) {
            val copyNode = Node(current.`val`)
            copyNode.next = current.next
            current.next = copyNode
            current = copyNode.next
        }
    }

    fun assignRandomPointers() {
        var current: Node? = head
        while (current != null) {
            current.next?.random = current.random?.next
            current = current.next?.next
        }
    }

    fun separateLists(): Node? {
        val copyHead = head.next
        var current: Node? = head
        while (current?.next != null) {
            val temp = current.next
            current.next = current.next?.next
            current = temp
        }
        return copyHead
    }

    createCopyNodes()
    assignRandomPointers()
    return separateLists()
}
