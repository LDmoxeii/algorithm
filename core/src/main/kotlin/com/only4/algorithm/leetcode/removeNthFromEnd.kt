package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.ListNode

/**
 * [19. 删除链表的倒数第 N 个节点](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头节点。
 *
 * 示例：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 *
 * 提示：
 * - 链表中结点的数目为 sz
 * - 1 <= sz <= 30
 * - 0 <= Node.val <= 100
 * - 1 <= n <= sz
 *
 * 解题思路：使用双指针（快慢指针）技巧，通过一次遍历完成操作。
 * 1. 创建一个哑节点(dummy)指向链表头，防止删除头节点时的特殊处理
 * 2. 定义一个内部函数findFromEnd，用于找到倒数第k个节点
 * 3. 找到倒数第n+1个节点（即要删除节点的前驱），将其next指向next.next，完成删除
 *
 * 时间复杂度：O(n)，只需遍历链表一次
 * 空间复杂度：O(1)，只使用了常数级别的额外空间
 */
fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    // 创建哑节点，避免删除头节点的特殊处理
    val dummy = ListNode(-1).apply { next = head }

    /**
     * 查找链表倒数第k个节点
     * @param head 链表头节点
     * @param k 倒数位置
     * @return 倒数第k个节点
     */
    fun findFromEnd(head: ListNode, k: Int): ListNode {
        var fast = head as ListNode?
        var slow = head

        // 快指针先前进k步
        repeat(k) {
            fast = fast!!.next
        }

        // 快慢指针同时前进，当快指针到达末尾时，慢指针指向倒数第k个节点
        while (fast != null) {
            slow = slow.next ?: break
            fast = fast.next
        }

        return slow
    }

    // 找到倒数第n+1个节点（要删除节点的前驱）
    val prev = findFromEnd(dummy, n + 1)

    // 删除倒数第n个节点
    prev.next = prev.next?.next

    return dummy.next
}
