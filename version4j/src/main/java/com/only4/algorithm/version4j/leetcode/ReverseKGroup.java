package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.ListNode;

/**
 * LeetCode 25: Reverse Nodes in k-Group
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * <p>
 * 给你链表的头节点 head，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，
 * 那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 解题思路：
 * 1. 计算链表总长度，确定需要翻转的组数
 * 2. 对每组 k 个节点进行翻转
 * 3. 连接各组翻转后的链表
 * <p>
 * 时间复杂度：O(n)，其中 n 是链表的长度
 * 空间复杂度：O(1)，只使用了常数级别的额外空间
 */
public class ReverseKGroup {
    /**
     * 按 k 个一组翻转链表
     *
     * @param head 链表头节点
     * @param k    每组的节点数
     * @return 翻转后的链表头节点
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // 创建虚拟头节点，简化边界情况处理
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 计算链表长度
        int length = getLength(head);

        // 如果链表长度小于2，无需翻转
        if (length < 2) {
            return head;
        }

        // 初始化指针
        ListNode prevGroupTail = dummy;  // 前一组的尾节点
        ListNode currentGroupHead = prevGroupTail.next;  // 当前组的头节点

        // 对每组进行翻转
        for (int i = 0; i < length / k; i++) {
            // 翻转当前组的 k 个节点
            ListNode prev = null;
            ListNode curr = currentGroupHead;

            for (int j = 0; j < k; j++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // 连接翻转后的组
            prevGroupTail.next = prev;  // 前一组的尾连接当前组的新头
            currentGroupHead.next = curr;  // 当前组的旧头（现在是尾）连接下一组的头

            // 更新指针，准备处理下一组
            prevGroupTail = currentGroupHead;
            currentGroupHead = curr;
        }

        return dummy.next;
    }

    /**
     * 计算链表长度
     *
     * @param head 链表头节点
     * @return 链表长度
     */
    private int getLength(ListNode head) {
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            length++;
        }
        return length;
    }
}
