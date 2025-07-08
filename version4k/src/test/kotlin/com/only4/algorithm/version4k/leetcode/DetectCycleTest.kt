package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.ListNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class DetectCycleTest {

    @Test
    fun testDetectCycle() {
        // 测试用例1：有环链表 [3,2,0,-4]，pos = 1
        val head1 = ListNode(3)
        val node2 = ListNode(2)
        val node3 = ListNode(0)
        val node4 = ListNode(-4)
        head1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node2  // 创建环，尾节点指向第二个节点
        assertEquals(node2, detectCycle(head1))

        // 测试用例2：有环链表 [1,2]，pos = 0
        val head2 = ListNode(1)
        val node22 = ListNode(2)
        head2.next = node22
        node22.next = head2  // 创建环，尾节点指向第一个节点
        assertEquals(head2, detectCycle(head2))

        // 测试用例3：无环链表 [1]
        val head3 = ListNode(1)
        assertNull(detectCycle(head3))

        // 测试用例4：空链表
        assertNull(detectCycle(null))

        // 测试用例5：无环链表 [1,2,3,4,5]
        val head5 = ListNode(1)
        head5.next = ListNode(2)
        head5.next!!.next = ListNode(3)
        head5.next!!.next!!.next = ListNode(4)
        head5.next!!.next!!.next!!.next = ListNode(5)
        assertNull(detectCycle(head5))

        // 测试用例6：有环链表 [1,2,3,4,5]，pos = 2
        val head6 = ListNode(1)
        val node62 = ListNode(2)
        val node63 = ListNode(3)
        val node64 = ListNode(4)
        val node65 = ListNode(5)
        head6.next = node62
        node62.next = node63
        node63.next = node64
        node64.next = node65
        node65.next = node63  // 创建环，尾节点指向第三个节点
        assertEquals(node63, detectCycle(head6))
    }
}
