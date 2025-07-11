package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RemoveNthFromEndTest {

    /**
     * 辅助方法：创建链表
     *
     * @param values 链表节点值的数组
     * @return 链表头节点
     */
    private ListNode createLinkedList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }

        return dummy.next;
    }

    /**
     * 辅助方法：将链表转换为数组，方便比较
     *
     * @param head 链表头节点
     * @return 链表节点值的数组
     */
    private int[] linkedListToArray(ListNode head) {
        // 计算链表长度
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        // 转换为数组
        int[] result = new int[length];
        current = head;
        for (int i = 0; i < length; i++) {
            result[i] = current.val;
            current = current.next;
        }

        return result;
    }

    @Test
    public void testExample1() {
        // 创建链表 [1,2,3,4,5]
        ListNode head = createLinkedList(new int[]{1, 2, 3, 4, 5});

        RemoveNthFromEnd solution = new RemoveNthFromEnd();
        ListNode result = solution.removeNthFromEnd(head, 2);

        // 期望结果 [1,2,3,5]
        assertArrayEquals(new int[]{1, 2, 3, 5}, linkedListToArray(result));
    }

    @Test
    public void testExample2() {
        // 创建链表 [1]
        ListNode head = createLinkedList(new int[]{1});

        RemoveNthFromEnd solution = new RemoveNthFromEnd();
        ListNode result = solution.removeNthFromEnd(head, 1);

        // 期望结果 []
        assertNull(result);
    }

    @Test
    public void testExample3() {
        // 创建链表 [1,2]
        ListNode head = createLinkedList(new int[]{1, 2});

        RemoveNthFromEnd solution = new RemoveNthFromEnd();
        ListNode result = solution.removeNthFromEnd(head, 1);

        // 期望结果 [1]
        assertArrayEquals(new int[]{1}, linkedListToArray(result));
    }

    @Test
    public void testRemoveFirstNode() {
        // 创建链表 [1,2,3]
        ListNode head = createLinkedList(new int[]{1, 2, 3});

        RemoveNthFromEnd solution = new RemoveNthFromEnd();
        ListNode result = solution.removeNthFromEnd(head, 3);

        // 期望结果 [2,3]
        assertArrayEquals(new int[]{2, 3}, linkedListToArray(result));
    }

    @Test
    public void testRemoveLastNode() {
        // 创建链表 [1,2,3]
        ListNode head = createLinkedList(new int[]{1, 2, 3});

        RemoveNthFromEnd solution = new RemoveNthFromEnd();
        ListNode result = solution.removeNthFromEnd(head, 1);

        // 期望结果 [1,2]
        assertArrayEquals(new int[]{1, 2}, linkedListToArray(result));
    }
}
