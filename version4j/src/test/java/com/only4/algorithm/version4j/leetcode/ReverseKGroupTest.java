package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ReverseKGroupTest {

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

        ReverseKGroup solution = new ReverseKGroup();
        ListNode result = solution.reverseKGroup(head, 2);

        // 期望结果 [2,1,4,3,5]
        assertArrayEquals(new int[]{2, 1, 4, 3, 5}, linkedListToArray(result));
    }

    @Test
    public void testExample2() {
        // 创建链表 [1,2,3,4,5]
        ListNode head = createLinkedList(new int[]{1, 2, 3, 4, 5});

        ReverseKGroup solution = new ReverseKGroup();
        ListNode result = solution.reverseKGroup(head, 3);

        // 期望结果 [3,2,1,4,5]
        assertArrayEquals(new int[]{3, 2, 1, 4, 5}, linkedListToArray(result));
    }

    @Test
    public void testEmptyList() {
        // 创建空链表
        ListNode head = null;

        ReverseKGroup solution = new ReverseKGroup();
        ListNode result = solution.reverseKGroup(head, 2);

        // 期望结果 []
        assertNull(result);
    }

    @Test
    public void testSingleNode() {
        // 创建链表 [1]
        ListNode head = createLinkedList(new int[]{1});

        ReverseKGroup solution = new ReverseKGroup();
        ListNode result = solution.reverseKGroup(head, 2);

        // 期望结果 [1] (不足k个节点，保持原样)
        assertArrayEquals(new int[]{1}, linkedListToArray(result));
    }

    @Test
    public void testExactMultipleOfK() {
        // 创建链表 [1,2,3,4,5,6]
        ListNode head = createLinkedList(new int[]{1, 2, 3, 4, 5, 6});

        ReverseKGroup solution = new ReverseKGroup();
        ListNode result = solution.reverseKGroup(head, 2);

        // 期望结果 [2,1,4,3,6,5]
        assertArrayEquals(new int[]{2, 1, 4, 3, 6, 5}, linkedListToArray(result));
    }

    @Test
    public void testKEqualsOne() {
        // 创建链表 [1,2,3,4]
        ListNode head = createLinkedList(new int[]{1, 2, 3, 4});

        ReverseKGroup solution = new ReverseKGroup();
        ListNode result = solution.reverseKGroup(head, 1);

        // 期望结果 [1,2,3,4] (k=1时，每个节点自成一组，实际上不变)
        assertArrayEquals(new int[]{1, 2, 3, 4}, linkedListToArray(result));
    }

    @Test
    public void testKEqualsLength() {
        // 创建链表 [1,2,3,4]
        ListNode head = createLinkedList(new int[]{1, 2, 3, 4});

        ReverseKGroup solution = new ReverseKGroup();
        ListNode result = solution.reverseKGroup(head, 4);

        // 期望结果 [4,3,2,1]
        assertArrayEquals(new int[]{4, 3, 2, 1}, linkedListToArray(result));
    }
}
