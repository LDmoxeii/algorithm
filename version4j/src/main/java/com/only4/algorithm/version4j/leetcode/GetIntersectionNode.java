package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.ListNode;

/**
 * @author zhenyu.jiang
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode pointerA = headA;
        ListNode pointerB = headB;

        // 当两个指针不相等时继续遍历
        while (pointerA != pointerB) {
            // 当指针A到达末尾时，重定向到链表B的头部
            pointerA = (pointerA != null) ? pointerA.next : headB;
            // 当指针B到达末尾时，重定向到链表A的头部
            pointerB = (pointerB != null) ? pointerB.next : headA;
        }

        // 返回相交节点（如果不存在则为null）
        return pointerA;
    }
}
