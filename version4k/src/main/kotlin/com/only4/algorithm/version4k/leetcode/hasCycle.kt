package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.ListNode

/**
 * [141. 环形链表](https://leetcode.com/problems/linked-list-cycle/)
 *
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。为了表示给定链表中的环，
 * 评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递。
 * 仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 * 解题思路：使用快慢指针（Floyd判圈算法）。
 * 慢指针每次走一步，快指针每次走两步。如果链表中有环，两个指针最终会在环中相遇。
 * 如果没有环，快指针最终会到达链表尾部。
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */
fun hasCycle(head: ListNode?): Boolean {
    // 处理边界情况
    if (head?.next == null) return false

    // 快慢指针初始化
    var slow = head;
    var fast = head

    // 当快指针和快指针的下一个节点都不为空时继续遍历
    while (fast?.next != null) {
        // 慢指针走一步，快指针走两步
        slow = slow?.next
        fast = fast.next?.next

        // 如果两个指针相遇，说明存在环
        if (slow === fast) return true
    }

    // 如果遍历结束没有相遇，说明不存在环
    return false
}
