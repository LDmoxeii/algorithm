package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.ListNode
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class IsPalindromeTest {

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

    @Test
    fun testIsPalindrome() {
        // 测试用例1: [1,2,2,1] -> true
        val list1 = createLinkedList(intArrayOf(1, 2, 2, 1))
        assertTrue(isPalindrome(list1))

        // 测试用例2: [1,2] -> false
        val list2 = createLinkedList(intArrayOf(1, 2))
        assertFalse(isPalindrome(list2))

        // 测试用例3: [] -> true (空链表被视为回文)
        val list3 = createLinkedList(intArrayOf())
        assertTrue(isPalindrome(list3))

        // 测试用例4: [1] -> true (单节点链表被视为回文)
        val list4 = createLinkedList(intArrayOf(1))
        assertTrue(isPalindrome(list4))

        // 测试用例5: [1,2,3,2,1] -> true (奇数长度回文)
        val list5 = createLinkedList(intArrayOf(1, 2, 3, 2, 1))
        assertTrue(isPalindrome(list5))

        // 测试用例6: [1,2,3,4,5] -> false (非回文)
        val list6 = createLinkedList(intArrayOf(1, 2, 3, 4, 5))
        assertFalse(isPalindrome(list6))
    }
}
