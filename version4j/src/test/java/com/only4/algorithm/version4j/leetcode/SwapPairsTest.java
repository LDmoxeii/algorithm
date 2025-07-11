package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SwapPairsTest {

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
        // 创建链表 [1,2,3,4]
        ListNode head = createLinkedList(new int[]{1, 2, 3, 4});

        SwapPairs solution = new SwapPairs();
        ListNode result = solution.swapPairs(head);

        // 期望结果 [2,1,4,3]
        assertArrayEquals(new int[]{2, 1, 4, 3}, linkedListToArray(result));
    }

    @Test
    public void testEmptyList() {
        // 创建空链表
        ListNode head = null;

        SwapPairs solution = new SwapPairs();
        ListNode result = solution.swapPairs(head);

        // 期望结果 []
        assertNull(result);
    }

    @Test
    public void testSingleNode() {
        // 创建链表 [1]
        ListNode head = createLinkedList(new int[]{1});

        SwapPairs solution = new SwapPairs();
        ListNode result = solution.swapPairs(head);

        // 期望结果 [1]
        assertArrayEquals(new int[]{1}, linkedListToArray(result));
    }

    @Test
    public void testOddLength() {
        // 创建链表 [1,2,3]
        ListNode head = createLinkedList(new int[]{1, 2, 3});

        SwapPairs solution = new SwapPairs();
        ListNode result = solution.swapPairs(head);

        // 期望结果 [2,1,3]
        assertArrayEquals(new int[]{2, 1, 3}, linkedListToArray(result));
    }

    @Test
    public void testLongList() {
        // 创建链表 [1,2,3,4,5,6]
        ListNode head = createLinkedList(new int[]{1, 2, 3, 4, 5, 6});

        SwapPairs solution = new SwapPairs();
        ListNode result = solution.swapPairs(head);

        // 期望结果 [2,1,4,3,6,5]
        assertArrayEquals(new int[]{2, 1, 4, 3, 6, 5}, linkedListToArray(result));
    }
}
