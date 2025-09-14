package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.ListNode;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int totalLength = getLength(head);
        int groupCount = totalLength / k;

        ListNode prevGroupTail = dummy;
        ListNode currentGroupHead = head;

        // 进行groupCount次反转
        for (int i = 0; i < groupCount; i++) {
            ListNode nextGroupHead = getKthNode(currentGroupHead, k).next;

            // 反转当前组，返回反转后的新头节点
            ListNode reversedGroupHead = reverseKNodes(currentGroupHead, k);

            // 连接反转后的组
            prevGroupTail.next = reversedGroupHead;
            currentGroupHead.next = nextGroupHead;

            // 更新指针，准备处理下一组
            prevGroupTail = currentGroupHead;
            currentGroupHead = nextGroupHead;
        }

        return dummy.next;
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }

    private ListNode getKthNode(ListNode head, int k) {
        ListNode current = head;
        for (int i = 1; i < k && current != null; i++) {
            current = current.next;
        }
        return current;
    }

    private ListNode reverseKNodes(ListNode head, int k) {
        ListNode prev = null;
        ListNode current = head;

        for (int i = 0; i < k && current != null; i++) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev; // 返回反转后的头节点
    }
}
