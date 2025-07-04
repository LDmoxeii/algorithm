package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.ListNode

/**
 * [25. K 个一组翻转链表](https://leetcode.com/problems/reverse-nodes-in-k-group/)
 *
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 *
 * 示例 2：
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 *
 * 提示：
 * - 链表中的节点数目为 n
 * - 1 <= k <= n <= 5000
 * - 0 <= Node.val <= 1000
 *
 * 解题思路：使用迭代方法，先计算链表长度，然后每k个节点一组进行翻转。
 * 1. 创建一个虚拟头节点dummy，方便处理边界情况
 * 2. 计算链表总长度count
 * 3. 遍历链表，每k个节点一组进行翻转
 * 4. 对于每组，使用经典的链表翻转算法进行局部翻转
 * 5. 连接翻转后的子链表
 *
 * 时间复杂度：O(n)，其中n是链表长度，每个节点会被访问两次（计数和翻转）
 * 空间复杂度：O(1)，只使用了常数额外空间
 */
fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
    // 如果链表为空或k=1，无需翻转
    if (head == null || k == 1) return head

    // 创建虚拟头节点
    val dummy = ListNode(0).apply { next = head }

    // 计算链表长度
    var counter = head
    var count = 0
    while (counter != null) {
        count++
        counter = counter.next
    }

    // 前驱节点，初始为虚拟头节点
    var prev = dummy

    // 进行count/k次翻转
    repeat(count / k) {
        // 当前组的第一个节点
        val first = prev.next

        // 翻转k个节点
        var current = first
        var previous: ListNode? = null

        repeat(k) {
            val next = current!!.next
            current.next = previous
            previous = current
            current = next
        }

        // 连接翻转后的子链表
        // first现在是当前组的最后一个节点
        first!!.next = current
        // prev.next指向翻转后的头节点（当前组的最后一个节点）
        prev.next = previous
        // 更新prev为下一组的前驱节点
        prev = first
    }

    return dummy.next
}
