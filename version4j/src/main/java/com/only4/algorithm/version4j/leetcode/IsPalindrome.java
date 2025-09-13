package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.ListNode;

/**
 * @author zhenyu.jiang
 */
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // 使用快慢指针找到链表中点
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 反转后半部分链表
        ListNode secondHalf = reverseList(slow.next);
        ListNode secondHalfHead = secondHalf; // 保存用于恢复

        // 比较前半部分和反转后的后半部分
        boolean isPalindrome = true;
        ListNode firstHalf = head;

        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                isPalindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // 可选：恢复链表原始结构
        // slow.next = reverseList(secondHalfHead);

        return isPalindrome;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
