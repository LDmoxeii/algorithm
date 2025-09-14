package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.ListNode;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode middleNode = findMiddleAndSplit(head);
        ListNode leftSorted = sortList(head);
        ListNode rightSorted = sortList(middleNode);

        return mergeTwoSortedLists(leftSorted, rightSorted);
    }

    private ListNode findMiddleAndSplit(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head.next;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        ListNode middleNode = slowPointer.next;
        slowPointer.next = null; // 分割链表
        return middleNode;
    }

    private ListNode mergeTwoSortedLists(ListNode firstList, ListNode secondList) {
        ListNode dummyHead = new ListNode(0);
        ListNode currentNode = dummyHead;

        while (firstList != null && secondList != null) {
            if (firstList.val <= secondList.val) {
                currentNode.next = firstList;
                firstList = firstList.next;
            } else {
                currentNode.next = secondList;
                secondList = secondList.next;
            }
            currentNode = currentNode.next;
        }

        currentNode.next = (firstList != null) ? firstList : secondList;
        return dummyHead.next;
    }
}
