package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.ListNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class MergeKListsTest {

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
    fun testEmptyLists() {
        // 空数组测试
        val lists1 = arrayOf<ListNode?>()
        assertNull(mergeKLists(lists1))

        // 只包含null的数组测试
        val lists2 = arrayOf<ListNode?>(null, null)
        assertNull(mergeKLists(lists2))
    }

    @Test
    fun testSingleList() {
        val list = createLinkedList(intArrayOf(1, 3, 5))
        val lists = arrayOf(list)
        val merged = mergeKLists(lists)

        assertEquals("1, 3, 5", linkedListToArray(merged).joinToString())
    }

    @Test
    fun testTwoLists() {
        val list1 = createLinkedList(intArrayOf(1, 4, 5))
        val list2 = createLinkedList(intArrayOf(1, 3, 4))
        val lists = arrayOf(list1, list2)
        val merged = mergeKLists(lists)

        assertEquals(true, isSorted(merged))
        assertEquals("1, 1, 3, 4, 4, 5", linkedListToArray(merged).joinToString())
    }

    @Test
    fun testThreeLists() {
        val list1 = createLinkedList(intArrayOf(1, 4, 5))
        val list2 = createLinkedList(intArrayOf(1, 3, 4))
        val list3 = createLinkedList(intArrayOf(2, 6))
        val lists = arrayOf(list1, list2, list3)
        val merged = mergeKLists(lists)

        assertEquals(true, isSorted(merged))
        assertEquals("1, 1, 2, 3, 4, 4, 5, 6", linkedListToArray(merged).joinToString())
    }

    @Test
    fun testWithNullLists() {
        val list1 = createLinkedList(intArrayOf(1, 4, 5))
        val list2 = null
        val list3 = createLinkedList(intArrayOf(2, 6))
        val lists = arrayOf(list1, list2, list3)
        val merged = mergeKLists(lists)

        assertEquals(true, isSorted(merged))
        assertEquals("1, 2, 4, 5, 6", linkedListToArray(merged).joinToString())
    }

    @Test
    fun testWithNegativeNumbers() {
        val list1 = createLinkedList(intArrayOf(-2, 1, 4))
        val list2 = createLinkedList(intArrayOf(-5, -1, 3, 6))
        val list3 = createLinkedList(intArrayOf(0, 2, 5))
        val lists = arrayOf(list1, list2, list3)
        val merged = mergeKLists(lists)

        assertEquals(true, isSorted(merged))
        assertEquals("-5, -2, -1, 0, 1, 2, 3, 4, 5, 6", linkedListToArray(merged).joinToString())
    }
}
