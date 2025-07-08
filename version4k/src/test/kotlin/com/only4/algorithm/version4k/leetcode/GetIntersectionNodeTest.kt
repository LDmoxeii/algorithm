package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.ListNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class GetIntersectionNodeTest {

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

    // 辅助函数：创建相交链表
    private fun createIntersectingLists(
        listA: IntArray,
        listB: IntArray,
        intersect: IntArray
    ): Pair<ListNode?, ListNode?> {
        // 创建相交部分
        val intersectionList = createLinkedList(intersect)

        // 如果没有相交部分，则直接返回两个独立链表
        if (intersectionList == null) {
            return createLinkedList(listA) to createLinkedList(listB)
        }

        // 创建链表A的非相交部分
        val headA = if (listA.isEmpty()) intersectionList else {
            val listANodes = createLinkedList(listA)!!
            var curr = listANodes
            while (curr.next != null) {
                curr = curr.next!!
            }
            curr.next = intersectionList
            listANodes
        }

        // 创建链表B的非相交部分
        val headB = if (listB.isEmpty()) intersectionList else {
            val listBNodes = createLinkedList(listB)!!
            var curr = listBNodes
            while (curr.next != null) {
                curr = curr.next!!
            }
            curr.next = intersectionList
            listBNodes
        }

        return headA to headB
    }

    @Test
    fun `test example 1 - lists intersect`() {
        // 构建示例：listA = [4,1], listB = [5,6,1], 相交部分 = [8,4,5]
        val (headA, headB) = createIntersectingLists(
            listA = intArrayOf(4, 1),
            listB = intArrayOf(5, 6, 1),
            intersect = intArrayOf(8, 4, 5)
        )

        val intersection = getIntersectionNode(headA, headB)

        // 检查相交节点的值是否为8
        assertEquals(8, intersection?.`val`)
    }

    @Test
    fun `test example 2 - lists intersect at different position`() {
        // 构建示例：listA = [1,9,1], listB = [3], 相交部分 = [2,4]
        val (headA, headB) = createIntersectingLists(
            listA = intArrayOf(1, 9, 1),
            listB = intArrayOf(3),
            intersect = intArrayOf(2, 4)
        )

        val intersection = getIntersectionNode(headA, headB)

        // 检查相交节点的值是否为2
        assertEquals(2, intersection?.`val`)
    }

    @Test
    fun `test no intersection`() {
        // 创建两个不相交的链表
        val headA = createLinkedList(intArrayOf(1, 2, 3))
        val headB = createLinkedList(intArrayOf(4, 5, 6))

        val intersection = getIntersectionNode(headA, headB)

        // 应该返回null，表示没有相交点
        assertNull(intersection)
    }

    @Test
    fun `test identical lists`() {
        // 创建完全相同的两个链表（实际上是同一个对象）
        val list = createLinkedList(intArrayOf(1, 2, 3))

        val intersection = getIntersectionNode(list, list)

        // 应该返回链表的头节点
        assertEquals(1, intersection?.`val`)
    }

    @Test
    fun `test one empty list`() {
        // 一个链表为空
        val headA = createLinkedList(intArrayOf(1, 2, 3))
        val headB = null

        val intersection = getIntersectionNode(headA, headB)

        // 应该返回null，表示没有相交点
        assertNull(intersection)
    }

    @Test
    fun `test both empty lists`() {
        // 两个链表都为空
        val intersection = getIntersectionNode(null, null)

        // 应该返回null，表示没有相交点
        assertNull(intersection)
    }

    @Test
    fun `test intersection at the beginning`() {
        // 链表从一开始就相交
        val common = createLinkedList(intArrayOf(1, 2, 3))

        val intersection = getIntersectionNode(common, common)

        // 应该返回共同的头节点
        assertEquals(1, intersection?.`val`)
    }
}
