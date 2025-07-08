package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.ListNode

/**
 * [142. 环形链表 II](https://leetcode.com/problems/linked-list-cycle-ii/)
 *
 * 给定一个链表，返回链表开始入环的第一个节点。如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改给定的链表。
 *
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 *
 * 解题思路：
 * 1. 使用快慢指针检测链表是否有环。
 * 2. 如果有环，通过数学关系找到环的入口：
 *    - 设头节点到环入口距离为x，环入口到相遇点距离为y，相遇点到环入口距离为z
 *    - 快指针走的距离为 f = x + y + n(y + z)，n为绕环圈数
 *    - 慢指针走的距离为 s = x + y
 *    - 因为快指针速度是慢指针的2倍，所以 f = 2s
 *    - 推导得出：x = (n-1)(y+z) + z，当n=1时，x = z
 *    - 所以从头节点和相遇点同时出发，每次走一步，相遇点即为环的入口
 *
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */
fun detectCycle(head: ListNode?): ListNode? {
    // 处理边界情况
    if (head?.next == null) return null

    // 初始化快慢指针
    var slow = head
    var fast = head

    // 第一阶段：检测是否有环
    while (fast?.next != null) {
        // 慢指针走一步，快指针走两步
        slow = slow?.next
        fast = fast.next?.next

        // 如果快慢指针相遇，说明有环
        if (slow === fast) break
    }

    // 如果fast为空或fast.next为空，说明没有环
    if (fast?.next == null) return null

    // 第二阶段：找环的入口
    // 将slow重新指向头节点
    slow = head

    // 快慢指针同步前进，相交点就是环起点
    while (slow !== fast) {
        slow = slow?.next
        fast = fast?.next
    }

    return slow
}
