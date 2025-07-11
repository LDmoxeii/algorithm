package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.ListNode;

/**
 * @author zhenyu.jiang
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode deltaA = headA;
        ListNode deltaB = headB;
        while (deltaA != deltaB) {
            deltaA = deltaA != null ? deltaA.next : headB;
            deltaB = deltaB != null ? deltaB.next : headA;
        }

        return deltaA;
    }
}
