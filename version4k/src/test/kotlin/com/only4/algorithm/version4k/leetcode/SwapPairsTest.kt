package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.ListNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class SwapPairsTest {

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
    fun testSwapPairs() {
        // 测试用例1: [1,2,3,4] -> [2,1,4,3]
        val list1 = createListNode(intArrayOf(1, 2, 3, 4))
        val result1 = swapPairs(list1)
        assertEquals(listOf(2, 1, 4, 3), listNodeToList(result1))

        // 测试用例2: [] -> []
        val list2 = createListNode(intArrayOf())
        val result2 = swapPairs(list2)
        assertNull(result2)

        // 测试用例3: [1] -> [1]
        val list3 = createListNode(intArrayOf(1))
        val result3 = swapPairs(list3)
        assertEquals(listOf(1), listNodeToList(result3))

        // 测试用例4: [1,2] -> [2,1]
        val list4 = createListNode(intArrayOf(1, 2))
        val result4 = swapPairs(list4)
        assertEquals(listOf(2, 1), listNodeToList(result4))

        // 测试用例5: [1,2,3] -> [2,1,3]
        val list5 = createListNode(intArrayOf(1, 2, 3))
        val result5 = swapPairs(list5)
        assertEquals(listOf(2, 1, 3), listNodeToList(result5))

        // 测试用例6: [1,2,3,4,5] -> [2,1,4,3,5]
        val list6 = createListNode(intArrayOf(1, 2, 3, 4, 5))
        val result6 = swapPairs(list6)
        assertEquals(listOf(2, 1, 4, 3, 5), listNodeToList(result6))
    }
}
