package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.ListNode

/**
 * [148. 排序链表](https://leetcode.com/problems/sort-list/)
 *
 * 给你链表的头节点 head，请将其按升序排列并返回排序后的链表。
 *
 * 示例 1：
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 *
 * 示例 2：
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 *
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 *
 * 提示：
 * - 链表中节点的数目在范围 [0, 5 * 10^4] 内
 * - -10^5 <= Node.val <= 10^5
 *
 * 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 * 解题思路：使用归并排序（自顶向下的递归实现）
 * 1. 通过快慢指针找到链表中点，将链表分为两部分
 * 2. 递归地对两部分进行排序
 * 3. 合并两个有序链表
 *
 * 时间复杂度：O(n log n)，其中n是链表长度，归并排序的时间复杂度
 * 空间复杂度：O(log n)，递归调用的栈空间
 */
fun sortList(head: ListNode?): ListNode? {
    // 边界情况：空链表或只有一个节点的链表，已经是有序的
    head?.next ?: return head

    /**
     * 找到链表的中间节点，并将链表从中间断开，返回后半部分的头节点
     * 使用快慢指针法找中点
     */
    fun findMiddle(head: ListNode): ListNode {
        // 如果只有一个节点，直接返回
        head.next ?: return head

        // 快慢指针初始化
        var slow = head;
        var fast = head as ListNode?

        // 快指针每次走两步，慢指针每次走一步
        while (fast?.next?.next != null) {
            slow = slow.next!!
            fast = fast.next?.next
        }

        // 断开链表，并返回后半部分的头节点
        return slow.next!!.apply { slow.next = null }
    }

    /**
     * 合并两个有序链表
     */
    fun merge(l1: ListNode?, l2: ListNode?): ListNode? {
        // 创建哑节点作为合并链表的头
        val dummy = ListNode(0)
        var current = dummy

        // l1和l2的当前节点
        var left = l1
        var right = l2

        // 比较两个链表的节点值，将较小的节点添加到结果链表
        while (left != null && right != null) {
            if (left.`val` < right.`val`) {
                current.next = left
                left = left.next
            } else {
                current.next = right
                right = right.next
            }
            current = current.next!!
        }

        // 将剩余部分直接连接到结果链表
        current.next = left ?: right

        return dummy.next
    }

    /**
     * 归并排序主函数，对链表 [head, tail) 进行排序
     * 返回排序后的链表头节点
     */
    fun mergeSort(head: ListNode, tail: ListNode): ListNode? {
        // 如果只有一个节点，直接返回
        if (head === tail) return head

        // 递归排序前半部分和后半部分
        val left = mergeSort(head, findMiddle(head))
        val right = mergeSort(tail, findMiddle(tail))

        // 合并两个有序链表
        return merge(left, right)
    }

    // 开始排序
    return mergeSort(head, findMiddle(head))
}
