package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.ListNode;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        if (head == null || head.next == null) return dummy.next;
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next.next;
            pre.next = cur.next;
            cur.next.next = cur;
            cur.next = next;

            pre = cur;
            cur = next;
        }

        return dummy.next;
    }
}
