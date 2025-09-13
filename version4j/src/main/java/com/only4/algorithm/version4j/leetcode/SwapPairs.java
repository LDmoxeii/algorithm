package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.ListNode;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        if (head == null || head.next == null) return head;

        ListNode prev = dummy;
        ListNode current = head;

        while (current != null && current.next != null) {
            ListNode next = current.next.next;
            prev.next = current.next;
            current.next.next = current;
            current.next = next;

            prev = current;
            current = next;
        }

        return dummy.next;
    }
}
