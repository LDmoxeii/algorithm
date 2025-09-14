package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.ListNode;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = findFromEnd(dummy, n + 1);
        prev.next = prev.next.next;

        return dummy.next;
    }

    private ListNode findFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;

        // 快指针先前进k步
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        // 快慢指针同时前进，当快指针到达末尾时，慢指针指向倒数第k个节点
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
