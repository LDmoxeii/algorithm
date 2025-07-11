package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.ListNode;

/**
 * LeetCode 19: Remove Nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * <p>
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 解题思路：
 * 使用双指针（快慢指针）技巧：
 * 1. 创建一个虚拟头节点 dummy，指向链表头，以处理可能需要删除头节点的情况。
 * 2. 让快指针 fast 先走 n 步。
 * 3. 如果 fast 为 null，说明需要删除的是头节点，直接返回 head.next。
 * 4. 否则，让快慢指针同时前进，直到快指针到达链表末尾。
 * 5. 此时慢指针 slow 指向待删除节点的前一个节点，执行删除操作。
 * <p>
 * 时间复杂度：O(n)，其中 n 是链表的长度，只需要遍历一次链表。
 * 空间复杂度：O(1)，只使用了常数级别的额外空间。
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i <= n; i++) {
            if (fast == null) return null;
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
