package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.ListNode;

import java.util.PriorityQueue;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] sortedLists) {
        if (sortedLists.length == 0) return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((firstNode, secondNode) -> firstNode.val - secondNode.val);

        // 将所有链表的头节点加入最小堆
        for (ListNode listHead : sortedLists) {
            if (listHead != null) minHeap.offer(listHead);
        }

        ListNode dummyHead = new ListNode(0);
        ListNode currentNode = dummyHead;

        // 不断从堆中取出最小节点构建结果链表
        while (!minHeap.isEmpty()) {
            ListNode smallestNode = minHeap.poll();
            currentNode.next = smallestNode;
            currentNode = currentNode.next;

            // 如果取出的节点有后继节点，将其加入堆中
            if (smallestNode.next != null) {
                minHeap.offer(smallestNode.next);
            }
        }

        return dummyHead.next;
    }
}
