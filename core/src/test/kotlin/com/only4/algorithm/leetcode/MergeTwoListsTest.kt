package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.ListNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class MergeTwoListsTest {

    /**
     * 将链表转换为列表，便于测试比较
     */
    private fun listNodeToList(head: ListNode?): List<Int> {
        val result = mutableListOf<Int>()
        var current = head
        while (current != null) {
            result.add(current.`val`)
            current = current.next
        }
        return result
    }

    /**
     * 从整数数组创建链表
     */
    private fun createListNode(values: IntArray): ListNode? {
        if (values.isEmpty()) return null

        val head = ListNode(values[0])
        var current = head

        for (i in 1 until values.size) {
            current.next = ListNode(values[i])
            current = current.next!!
        }

        return head
    }

    @Test
    fun testMergeTwoLists() {
        // 测试用例1: list1 = [1,2,4], list2 = [1,3,4]
        val list1 = createListNode(intArrayOf(1, 2, 4))
        val list2 = createListNode(intArrayOf(1, 3, 4))
        val merged1 = mergeTwoLists(list1, list2)
        assertEquals(listOf(1, 1, 2, 3, 4, 4), listNodeToList(merged1))

        // 测试用例2: list1 = [], list2 = []
        val merged2 = mergeTwoLists(null, null)
        assertNull(merged2)

        // 测试用例3: list1 = [], list2 = [0]
        val list3 = createListNode(intArrayOf(0))
        val merged3 = mergeTwoLists(null, list3)
        assertEquals(listOf(0), listNodeToList(merged3))

        // 测试用例4: list1 = [0], list2 = []
        val list4 = createListNode(intArrayOf(0))
        val merged4 = mergeTwoLists(list4, null)
        assertEquals(listOf(0), listNodeToList(merged4))

        // 测试用例5: list1 = [1,3,5], list2 = [2,4,6]
        val list5 = createListNode(intArrayOf(1, 3, 5))
        val list6 = createListNode(intArrayOf(2, 4, 6))
        val merged5 = mergeTwoLists(list5, list6)
        assertEquals(listOf(1, 2, 3, 4, 5, 6), listNodeToList(merged5))

        // 测试用例6: list1和list2长度不同
        val list7 = createListNode(intArrayOf(1, 3, 5, 7, 9))
        val list8 = createListNode(intArrayOf(2, 4))
        val merged6 = mergeTwoLists(list7, list8)
        assertEquals(listOf(1, 2, 3, 4, 5, 7, 9), listNodeToList(merged6))
    }
}
