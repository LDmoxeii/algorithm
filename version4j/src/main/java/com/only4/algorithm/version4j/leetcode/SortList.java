package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.ListNode;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        current.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}
