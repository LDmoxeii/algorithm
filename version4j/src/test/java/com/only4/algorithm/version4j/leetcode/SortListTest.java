package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * SortList的单元测试类
 * <p>
 * LeetCode 148: Sort List
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */
public class SortListTest {

    /**
     * 辅助方法：创建链表
     *
     * @param values 链表节点值数组
     * @return 链表头节点
     */
    private ListNode createList(int[] values) {
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
     * 辅助方法：将链表转换为数组，方便验证
     *
     * @param head 链表头节点
     * @return 包含链表所有值的数组
     */
    private int[] listToArray(ListNode head) {
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

    /**
     * 测试空链表
     */
    @Test
    public void testEmptyList() {
        SortList solution = new SortList();
        ListNode result = solution.sortList(null);
        assertNull(result);
    }

    /**
     * 测试只有一个节点的链表
     */
    @Test
    public void testSingleNodeList() {
        SortList solution = new SortList();
        ListNode head = new ListNode(5);
        ListNode result = solution.sortList(head);

        assertNotNull(result);
        assertEquals(5, result.val);
        assertNull(result.next);
    }

    /**
     * 测试示例1: [4,2,1,3] -> [1,2,3,4]
     */
    @Test
    public void testExample1() {
        SortList solution = new SortList();
        ListNode head = createList(new int[]{4, 2, 1, 3});
        ListNode result = solution.sortList(head);
        
        int[] expected = {1, 2, 3, 4};
        int[] actual = listToArray(result);

        assertArrayEquals(expected, actual);
    }

    /**
     * 测试示例2: [-1,5,3,4,0] -> [-1,0,3,4,5]
     */
    @Test
    public void testExample2() {
        SortList solution = new SortList();
        ListNode head = createList(new int[]{-1, 5, 3, 4, 0});
        ListNode result = solution.sortList(head);

        int[] expected = {-1, 0, 3, 4, 5};
        int[] actual = listToArray(result);

        assertArrayEquals(expected, actual);
    }

    /**
     * 测试已排序的链表
     */
    @Test
    public void testAlreadySortedList() {
        SortList solution = new SortList();
        ListNode head = createList(new int[]{1, 2, 3, 4, 5});
        ListNode result = solution.sortList(head);

        int[] expected = {1, 2, 3, 4, 5};
        int[] actual = listToArray(result);

        assertArrayEquals(expected, actual);
    }

    /**
     * 测试逆序的链表
     */
    @Test
    public void testReverseOrderList() {
        SortList solution = new SortList();
        ListNode head = createList(new int[]{5, 4, 3, 2, 1});
        ListNode result = solution.sortList(head);

        int[] expected = {1, 2, 3, 4, 5};
        int[] actual = listToArray(result);

        assertArrayEquals(expected, actual);
    }

    /**
     * 测试包含重复元素的链表
     */
    @Test
    public void testDuplicateElements() {
        SortList solution = new SortList();
        ListNode head = createList(new int[]{3, 1, 2, 3, 2, 1});
        ListNode result = solution.sortList(head);

        int[] expected = {1, 1, 2, 2, 3, 3};
        int[] actual = listToArray(result);

        assertArrayEquals(expected, actual);
    }

    /**
     * 测试包含负数的链表
     */
    @Test
    public void testNegativeNumbers() {
        SortList solution = new SortList();
        ListNode head = createList(new int[]{-5, -10, 0, -3, 8, -1});
        ListNode result = solution.sortList(head);

        int[] expected = {-10, -5, -3, -1, 0, 8};
        int[] actual = listToArray(result);

        assertArrayEquals(expected, actual);
    }

    /**
     * 测试较大的链表
     */
    @Test
    public void testLargeList() {
        int[] values = new int[100];
        for (int i = 0; i < 100; i++) {
            values[i] = 100 - i;  // 逆序填充
        }

        SortList solution = new SortList();
        ListNode head = createList(values);
        ListNode result = solution.sortList(head);

        // 验证结果是否有序
        ListNode current = result;
        while (current != null && current.next != null) {
            assertTrue(current.val <= current.next.val);
            current = current.next;
        }
    }
} 
