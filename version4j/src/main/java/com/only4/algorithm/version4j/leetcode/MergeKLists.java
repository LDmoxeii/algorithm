package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode dummy = new ListNode(-1);
        ListNode cursor = dummy;

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(p -> p.val));

        priorityQueue.addAll(Arrays.stream(lists).filter(Objects::nonNull).toList());

        while (!priorityQueue.isEmpty()) {
            ListNode min = priorityQueue.poll();
            if (min.next != null) priorityQueue.add(min.next);

            cursor.next = min;
            cursor = cursor.next;
        }

        return dummy.next;
    }
}
