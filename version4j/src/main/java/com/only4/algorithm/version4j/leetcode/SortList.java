package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.ListNode;

/**
 * LeetCode 148: Sort List
 * https://leetcode.com/problems/sort-list/
 * <p>
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表。
 * 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * <p>
 * 解题思路：
 * 本题使用归并排序对链表进行排序。归并排序是一种稳定的排序算法，时间复杂度为O(n log n)。
 * 对链表进行归并排序的步骤如下：
 * 1. 使用快慢指针找到链表的中点，将链表分为两部分
 * 2. 递归地对两部分进行排序
 * 3. 合并两个有序链表
 * <p>
 * 时间复杂度：O(n log n)，其中 n 是链表的长度
 * 空间复杂度：O(log n)，递归调用的栈空间
 */
public class SortList {
    /**
     * 对链表进行排序
     *
     * @param head 链表头节点
     * @return 排序后的链表头节点
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // 使用快慢指针找到链表的中点
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 分割链表
        ListNode mid = slow.next;
        slow.next = null;

        // 递归排序左右两部分
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        // 合并两个有序链表
        return mergeTwoLists(left, right);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            ListNode next;
            if (list1.val < list2.val) {
                next = list1.next;
                list1.next = null;
                current.next = list1;

                list1 = next;
            } else {
                next = list2.next;
                list2.next = null;
                current.next = list2;

                list2 = next;
            }
            current = current.next;
        }

        if (list1 != null) current.next = list1;
        if (list2 != null) current.next = list2;

        return dummy.next;
    }
}
