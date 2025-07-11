package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.ListNode;

/**
 * 234. 回文链表
 * 判断一个单链表是否为回文链表
 * <p>
 * 优化思路：
 * 1. 增加对空链表的处理
 * 2. 使用快慢指针找到链表中点，避免两次遍历
 * 3. 原地反转后半部分链表，减少空间复杂度
 * 4. 比较前半部分和反转后的后半部分
 * 5. 可选：恢复链表原始结构（取决于是否需要保持链表不变）
 *
 * @author zhenyu.jiang
 */
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        // 处理空链表和单节点链表
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

        // 保存后半部分的头节点，用于后续恢复链表（如果需要）
        ListNode secondHalfHead = secondHalf;

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

        // 恢复链表原始结构（可选，取决于是否需要保持链表不变）
        // slow.next = reverseList(secondHalfHead);

        return isPalindrome;
    }

    /**
     * 反转链表
     *
     * @param head 链表头节点
     * @return 反转后的链表头节点
     */
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
