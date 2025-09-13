package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.ListNode;

import java.util.PriorityQueue;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode list : lists) {
            if (list != null) pq.offer(list);
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            current.next = node;
            current = current.next;

            if (node.next != null) {
                pq.offer(node.next);
            }
        }

        return dummy.next;
    }
}
