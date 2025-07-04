package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.ListNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class ReverseKGroupTest {

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
    fun testReverseKGroup() {
        // 测试用例1: [1,2,3,4,5], k = 2 -> [2,1,4,3,5]
        val list1 = createListNode(intArrayOf(1, 2, 3, 4, 5))
        val result1 = reverseKGroup(list1, 2)
        assertEquals(listOf(2, 1, 4, 3, 5), listNodeToList(result1))

        // 测试用例2: [1,2,3,4,5], k = 3 -> [3,2,1,4,5]
        val list2 = createListNode(intArrayOf(1, 2, 3, 4, 5))
        val result2 = reverseKGroup(list2, 3)
        assertEquals(listOf(3, 2, 1, 4, 5), listNodeToList(result2))

        // 测试用例3: [], k = 1 -> []
        val list3 = createListNode(intArrayOf())
        val result3 = reverseKGroup(list3, 1)
        assertNull(result3)

        // 测试用例4: [1], k = 1 -> [1]
        val list4 = createListNode(intArrayOf(1))
        val result4 = reverseKGroup(list4, 1)
        assertEquals(listOf(1), listNodeToList(result4))

        // 测试用例5: [1,2], k = 2 -> [2,1]
        val list5 = createListNode(intArrayOf(1, 2))
        val result5 = reverseKGroup(list5, 2)
        assertEquals(listOf(2, 1), listNodeToList(result5))

        // 测试用例6: [1,2,3,4,5,6], k = 3 -> [3,2,1,6,5,4]
        val list6 = createListNode(intArrayOf(1, 2, 3, 4, 5, 6))
        val result6 = reverseKGroup(list6, 3)
        assertEquals(listOf(3, 2, 1, 6, 5, 4), listNodeToList(result6))

        // 测试用例7: [1,2,3,4,5], k = 1 -> [1,2,3,4,5]
        val list7 = createListNode(intArrayOf(1, 2, 3, 4, 5))
        val result7 = reverseKGroup(list7, 1)
        assertEquals(listOf(1, 2, 3, 4, 5), listNodeToList(result7))

        // 测试用例8: [1,2,3,4,5,6,7], k = 2 -> [2,1,4,3,6,5,7]
        val list8 = createListNode(intArrayOf(1, 2, 3, 4, 5, 6, 7))
        val result8 = reverseKGroup(list8, 2)
        assertEquals(listOf(2, 1, 4, 3, 6, 5, 7), listNodeToList(result8))
    }
}
