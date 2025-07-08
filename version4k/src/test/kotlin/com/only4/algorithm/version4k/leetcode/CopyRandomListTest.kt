package com.only4.algorithm.version4k.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotSame
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class CopyRandomListTest {

    /**
     * 检查复制链表是否与原链表相同（值和结构相同，但是不是同一个对象）
     */
    private fun assertDeepCopy(original: Node?, copy: Node?) {
        var originalNode = original
        var copyNode = copy

        while (originalNode != null && copyNode != null) {
            // 检查值是否相同
            assertEquals(originalNode.`val`, copyNode.`val`)

            // 确保不是同一个对象引用
            assertNotSame(originalNode, copyNode)

            // 检查random指针是否正确指向
            if (originalNode.random == null) {
                assertNull(copyNode.random)
            } else {
                // 如果原链表的random指向自己，那么复制链表的random也应该指向自己
                if (originalNode.random === originalNode) {
                    assertEquals(copyNode, copyNode.random)
                } else {
                    // 找到原链表中random指向的节点在链表中的位置
                    var pos = 0
                    var curr = original
                    while (curr !== originalNode.random) {
                        curr = curr!!.next
                        pos++
                    }

                    // 找到复制链表中对应位置的节点
                    curr = copy
                    for (i in 0 until pos) {
                        curr = curr!!.next
                    }

                    // 检查复制链表的random是否指向正确位置
                    assertEquals(curr, copyNode.random)
                }
            }

            originalNode = originalNode.next
            copyNode = copyNode.next
        }

        // 两个链表应该同时结束
        assertNull(originalNode)
        assertNull(copyNode)
    }

    @Test
    fun testEmptyList() {
        val result = copyRandomList(null)
        assertNull(result)
    }

    @Test
    fun testSingleNodeWithoutRandom() {
        val head = Node(1)
        val result = copyRandomList(head)

        assertEquals(1, result!!.`val`)
        assertNull(result.next)
        assertNull(result.random)
        assertNotSame(head, result)
    }

    @Test
    fun testSingleNodeWithSelfRandom() {
        val head = Node(1)
        head.random = head

        val result = copyRandomList(head)

        assertEquals(1, result!!.`val`)
        assertNull(result.next)
        assertEquals(result, result.random) // random指向自己
        assertNotSame(head, result)
    }

    @Test
    fun testMultipleNodesWithRandomPointers() {
        // 创建链表：1 -> 2 -> 3
        val node1 = Node(1)
        val node2 = Node(2)
        val node3 = Node(3)

        node1.next = node2
        node2.next = node3

        // 设置random指针
        node1.random = node3 // 1的random指向3
        node2.random = node1 // 2的random指向1
        node3.random = node2 // 3的random指向2

        val result = copyRandomList(node1)

        // 验证深拷贝是否正确
        assertDeepCopy(node1, result)
    }

    @Test
    fun testLeetCodeExample1() {
        // 创建链表：7 -> 13 -> 11 -> 10 -> 1
        val node1 = Node(7)
        val node2 = Node(13)
        val node3 = Node(11)
        val node4 = Node(10)
        val node5 = Node(1)

        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5

        // 设置random指针
        node2.random = node1 // 13的random指向7
        node3.random = node5 // 11的random指向1
        node4.random = node3 // 10的random指向11
        node5.random = node1 // 1的random指向7

        val result = copyRandomList(node1)

        // 验证深拷贝是否正确
        assertDeepCopy(node1, result)
    }
}
