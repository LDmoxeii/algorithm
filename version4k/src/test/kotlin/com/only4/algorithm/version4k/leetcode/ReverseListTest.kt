package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.ListNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class ReverseListTest {

    /**
     * 将数组转换为链表
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
     * 将链表转换为数组
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

    @Test
    fun testReverseList() {
        // 测试用例1: [1,2,3,4,5] -> [5,4,3,2,1]
        val list1 = createLinkedList(intArrayOf(1, 2, 3, 4, 5))
        val reversed1 = reverseList(list1)
        assertEquals(intArrayOf(5, 4, 3, 2, 1).toList(), linkedListToArray(reversed1).toList())

        // 测试用例2: [1,2] -> [2,1]
        val list2 = createLinkedList(intArrayOf(1, 2))
        val reversed2 = reverseList(list2)
        assertEquals(intArrayOf(2, 1).toList(), linkedListToArray(reversed2).toList())

        // 测试用例3: [] -> []
        val list3 = createLinkedList(intArrayOf())
        val reversed3 = reverseList(list3)
        assertNull(reversed3)

        // 测试用例4: [1] -> [1]
        val list4 = createLinkedList(intArrayOf(1))
        val reversed4 = reverseList(list4)
        assertEquals(intArrayOf(1).toList(), linkedListToArray(reversed4).toList())
    }
}
