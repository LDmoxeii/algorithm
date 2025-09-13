package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.ListNode;

/**
 * @author zhenyu.jiang
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
