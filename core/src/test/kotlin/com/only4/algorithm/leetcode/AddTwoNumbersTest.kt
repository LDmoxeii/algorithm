package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.ListNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AddTwoNumbersTest {

    // 辅助函数：将数组转换为链表
    private fun createLinkedList(values: IntArray): ListNode? {
        if (values.isEmpty()) return null
        val dummy = ListNode(0)
        var current = dummy

        for (value in values) {
            current.next = ListNode(value)
            current = current.next!!
        }

        return dummy.next
    }

    // 辅助函数：将链表转换为数组以便比较
    private fun linkedListToArray(head: ListNode?): IntArray {
        val result = mutableListOf<Int>()
        var current = head

        while (current != null) {
            result.add(current.`val`)
            current = current.next
        }

        return result.toIntArray()
    }

    @Test
    fun `test regular case`() {
        // 2->4->3 (342) + 5->6->4 (465) = 7->0->8 (807)
        val l1 = createLinkedList(intArrayOf(2, 4, 3))
        val l2 = createLinkedList(intArrayOf(5, 6, 4))
        val expected = intArrayOf(7, 0, 8)

        val result = addTwoNumbers(l1, l2)

        assertEquals(expected.toList(), linkedListToArray(result).toList())
    }

    @Test
    fun `test different length lists`() {
        // 9->9 (99) + 1 (1) = 0->0->1 (100)
        val l1 = createLinkedList(intArrayOf(9, 9))
        val l2 = createLinkedList(intArrayOf(1))
        val expected = intArrayOf(0, 0, 1)

        val result = addTwoNumbers(l1, l2)

        assertEquals(expected.toList(), linkedListToArray(result).toList())
    }

    @Test
    fun `test with zero values`() {
        // 0 + 0 = 0
        val l1 = createLinkedList(intArrayOf(0))
        val l2 = createLinkedList(intArrayOf(0))
        val expected = intArrayOf(0)

        val result = addTwoNumbers(l1, l2)

        assertEquals(expected.toList(), linkedListToArray(result).toList())
    }

    @Test
    fun `test with one empty list`() {
        // null + 1->2->3 = 1->2->3
        val l1 = null
        val l2 = createLinkedList(intArrayOf(1, 2, 3))
        val expected = intArrayOf(1, 2, 3)

        val result = addTwoNumbers(l1, l2)

        assertEquals(expected.toList(), linkedListToArray(result).toList())
    }

    @Test
    fun `test both empty lists`() {
        // null + null = null
        val l1 = null
        val l2 = null

        val result = addTwoNumbers(l1, l2)

        assertEquals(0, linkedListToArray(result).size)
    }

    @Test
    fun `test large numbers with multiple carries`() {
        // 9->9->9->9 (9999) + 9->9->9 (999) = 8->9->9->0->1 (10998)
        val l1 = createLinkedList(intArrayOf(9, 9, 9, 9))
        val l2 = createLinkedList(intArrayOf(9, 9, 9))
        val expected = intArrayOf(8, 9, 9, 0, 1)

        val result = addTwoNumbers(l1, l2)

        assertEquals(expected.toList(), linkedListToArray(result).toList())
    }

    @Test
    fun `test with only carry at the end`() {
        // 5 + 5 = 0->1 (10)
        val l1 = createLinkedList(intArrayOf(5))
        val l2 = createLinkedList(intArrayOf(5))
        val expected = intArrayOf(0, 1)

        val result = addTwoNumbers(l1, l2)

        assertEquals(expected.toList(), linkedListToArray(result).toList())
    }

    @Test
    fun `test with maximum digit value`() {
        // 9->9->9 (999) + 1 (1) = 0->0->0->1 (1000)
        val l1 = createLinkedList(intArrayOf(9, 9, 9))
        val l2 = createLinkedList(intArrayOf(1))
        val expected = intArrayOf(0, 0, 0, 1)

        val result = addTwoNumbers(l1, l2)

        assertEquals(expected.toList(), linkedListToArray(result).toList())
    }
}
