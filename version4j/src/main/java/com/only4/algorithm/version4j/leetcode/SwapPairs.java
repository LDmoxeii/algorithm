package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.ListNode;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        // 递归终止条件：没有节点或只有一个节点
        if (head == null || head.next == null) return head;

        ListNode firstNode = head;
        ListNode secondNode = head.next;
        ListNode remainingNodes = secondNode.next;

        // 递归处理后续节点
        firstNode.next = swapPairs(remainingNodes);

        // 交换当前两个节点
        secondNode.next = firstNode;

        return secondNode;
    }
}
