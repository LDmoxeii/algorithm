package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.ListNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class SortListTest {

    /**
     * 将整数数组转换为链表
     */
    private fun createLinkedList(arr: IntArray): ListNode? {
        if (arr.isEmpty()) return null

        val head = ListNode(arr[0])
        var current = head

        for (i in 1 until arr.size) {
            current.next = ListNode(arr[i])
            current = current.next!!
        }

        return head
    }

    /**
     * 将链表转换为整数数组
     */
    private fun linkedListToArray(head: ListNode?): IntArray {
        val result = mutableListOf<Int>()
        var current = head

        while (current != null) {
            result.add(current.`val`)
            current = current.next
        }

        return result.toIntArray()
    }

    /**
     * 检查链表是否已排序
     */
    private fun isSorted(head: ListNode?): Boolean {
        if (head?.next == null) return true

        var current = head
        while (current?.next != null) {
            if (current.`val` > current.next!!.`val`) {
                return false
            }
            current = current.next
        }

        return true
    }

    @Test
    fun testEmptyList() {
        val head = null
        val sorted = sortList(head)
        assertNull(sorted)
    }

    @Test
    fun testSingleNodeList() {
        val head = createLinkedList(intArrayOf(1))
        val sorted = sortList(head)
        assertEquals(1, sorted?.`val`)
        assertNull(sorted?.next)
    }

    @Test
    fun testAlreadySortedList() {
        val arr = intArrayOf(1, 2, 3, 4, 5)
        val head = createLinkedList(arr)
        val sorted = sortList(head)

        assertEquals(true, isSorted(sorted))
        assertEquals(arr.joinToString(), linkedListToArray(sorted).joinToString())
    }

    @Test
    fun testReverseOrderList() {
        val head = createLinkedList(intArrayOf(5, 4, 3, 2, 1))
        val sorted = sortList(head)

        assertEquals(true, isSorted(sorted))
        assertEquals("1, 2, 3, 4, 5", linkedListToArray(sorted).joinToString())
    }

    @Test
    fun testRandomOrderList() {
        val head = createLinkedList(intArrayOf(4, 2, 1, 3))
        val sorted = sortList(head)

        assertEquals(true, isSorted(sorted))
        assertEquals("1, 2, 3, 4", linkedListToArray(sorted).joinToString())
    }

    @Test
    fun testWithNegativeNumbers() {
        val head = createLinkedList(intArrayOf(-1, 5, 3, 4, 0))
        val sorted = sortList(head)

        assertEquals(true, isSorted(sorted))
        assertEquals("-1, 0, 3, 4, 5", linkedListToArray(sorted).joinToString())
    }

    @Test
    fun testWithDuplicateValues() {
        val head = createLinkedList(intArrayOf(4, 2, 1, 3, 1, 5, 2))
        val sorted = sortList(head)

        assertEquals(true, isSorted(sorted))
        assertEquals("1, 1, 2, 2, 3, 4, 5", linkedListToArray(sorted).joinToString())
    }
}
