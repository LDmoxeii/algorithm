package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.ListNode;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // 快指针先前进n+1步
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // 快慢指针同时前进
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 删除倒数第n个节点
        slow.next = slow.next.next;

        return dummy.next;
    }
}
