package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.ListNode
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PartitionTest {

    @Test
    fun `test partition string - single character`() {
        val s = "a"
        val result = partition(s)

        assertEquals(1, result.size)
        assertEquals(listOf("a"), result[0])
    }

    @Test
    fun `test partition string - example 1`() {
        val s = "aab"
        val result = partition(s)

        assertEquals(2, result.size)
        assertTrue(result.contains(listOf("a", "a", "b")))
        assertTrue(result.contains(listOf("aa", "b")))
    }

    @Test
    fun `test partition string - example 2`() {
        val s = "aba"
        val result = partition(s)

        assertEquals(2, result.size)
        assertTrue(result.contains(listOf("a", "b", "a")))
        assertTrue(result.contains(listOf("aba")))
    }

    @Test
    fun `test partition list - null head`() {
        val head: ListNode? = null
        val x = 3

        val result = partition(head, x)

        assertNull(result)
    }

    @Test
    fun `test partition list - single node`() {
        val head = ListNode(1)
        val x = 2

        val result = partition(head, x)

        assertNotNull(result)
        assertEquals(1, result?.`val`)
        assertNull(result?.next)
    }

    @Test
    fun `test partition list - example 1`() {
        // 创建链表 [1,4,3,2,5,2]
        val head = ListNode(1).apply {
            next = ListNode(4).apply {
                next = ListNode(3).apply {
                    next = ListNode(2).apply {
                        next = ListNode(5).apply {
                            next = ListNode(2)
                        }
                    }
                }
            }
        }
        val x = 3

        val result = partition(head, x)

        // 验证结果链表为 [1,2,2,4,3,5]
        assertNotNull(result)

        // 验证小于x的节点在前面
        assertEquals(1, result?.`val`)
        assertEquals(2, result?.next?.`val`)
        assertEquals(2, result?.next?.next?.`val`)

        // 验证大于等于x的节点在后面
        assertEquals(4, result?.next?.next?.next?.`val`)
        assertEquals(3, result?.next?.next?.next?.next?.`val`)
        assertEquals(5, result?.next?.next?.next?.next?.next?.`val`)
        assertNull(result?.next?.next?.next?.next?.next?.next)
    }

    @Test
    fun `test partition list - all nodes less than x`() {
        // 创建链表 [1,2,2]
        val head = ListNode(1).apply {
            next = ListNode(2).apply {
                next = ListNode(2)
            }
        }
        val x = 3

        val result = partition(head, x)

        // 验证结果链表顺序不变 [1,2,2]
        assertNotNull(result)
        assertEquals(1, result?.`val`)
        assertEquals(2, result?.next?.`val`)
        assertEquals(2, result?.next?.next?.`val`)
        assertNull(result?.next?.next?.next)
    }

    @Test
    fun `test partition list - all nodes greater than or equal to x`() {
        // 创建链表 [3,4,5]
        val head = ListNode(3).apply {
            next = ListNode(4).apply {
                next = ListNode(5)
            }
        }
        val x = 3

        val result = partition(head, x)

        // 验证结果链表顺序不变 [3,4,5]
        assertNotNull(result)
        assertEquals(3, result?.`val`)
        assertEquals(4, result?.next?.`val`)
        assertEquals(5, result?.next?.next?.`val`)
        assertNull(result?.next?.next?.next)
    }
}
