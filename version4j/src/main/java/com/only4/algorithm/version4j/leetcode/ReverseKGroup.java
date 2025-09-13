package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.ListNode;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int length = getLength(head);
        if (length < 2) return head;

        ListNode prevGroupTail = dummy;
        ListNode currentGroupHead = head;

        for (int i = 0; i < length / k; i++) {
            ListNode prev = null;
            ListNode curr = currentGroupHead;

            for (int j = 0; j < k; j++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            prevGroupTail.next = prev;
            currentGroupHead.next = curr;
            prevGroupTail = currentGroupHead;
            currentGroupHead = curr;
        }

        return dummy.next;
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }
}
