package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.ListNode;

/**
 * @author zhenyu.jiang
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }

        return false;
    }
}
