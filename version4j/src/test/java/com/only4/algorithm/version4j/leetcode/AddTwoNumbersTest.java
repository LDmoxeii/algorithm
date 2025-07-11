package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * AddTwoNumbers的测试类
 * 测试LeetCode第2题：两数相加
 */
public class AddTwoNumbersTest {

    /**
     * 创建一个链表
     *
     * @param values 链表节点的值
     * @return 链表头节点
     */
    private ListNode createList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        ListNode head = new ListNode(values[0]);
        ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        return head;
    }

    /**
     * 检查两个链表是否相等
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 是否相等
     */
    private boolean areListsEqual(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        // 两个链表都应该同时结束
        return l1 == null && l2 == null;
    }

    /**
     * 将链表转换为字符串，方便调试和输出
     *
     * @param head 链表头节点
     * @return 链表的字符串表示
     */
    private String listToString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        while (head != null) {
            sb.append(head.val);
            if (head.next != null) {
                sb.append(", ");
            }
            head = head.next;
        }

        sb.append("]");
        return sb.toString();
    }

    @Test
    public void testExample1() {
        // 示例 1: (2 -> 4 -> 3) + (5 -> 6 -> 4) = 7 -> 0 -> 8
        // 解释: 342 + 465 = 807
        ListNode l1 = createList(new int[]{2, 4, 3});
        ListNode l2 = createList(new int[]{5, 6, 4});
        ListNode expected = createList(new int[]{7, 0, 8});

        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode result = solution.addTwoNumbers(l1, l2);

        assertTrue(areListsEqual(expected, result),
                "Expected: " + listToString(expected) + ", but got: " + listToString(result));
    }

    @Test
    public void testExample2() {
        // 示例 2: (0) + (0) = 0
        ListNode l1 = createList(new int[]{0});
        ListNode l2 = createList(new int[]{0});
        ListNode expected = createList(new int[]{0});

        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode result = solution.addTwoNumbers(l1, l2);

        assertTrue(areListsEqual(expected, result),
                "Expected: " + listToString(expected) + ", but got: " + listToString(result));
    }

    @Test
    public void testExample3() {
        // 示例 3: (9 -> 9 -> 9 -> 9 -> 9 -> 9 -> 9) + (9 -> 9 -> 9 -> 9) = 8 -> 9 -> 9 -> 9 -> 0 -> 0 -> 0 -> 1
        // 解释: 9999999 + 9999 = 10009998
        ListNode l1 = createList(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l2 = createList(new int[]{9, 9, 9, 9});
        ListNode expected = createList(new int[]{8, 9, 9, 9, 0, 0, 0, 1});

        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode result = solution.addTwoNumbers(l1, l2);

        assertTrue(areListsEqual(expected, result),
                "Expected: " + listToString(expected) + ", but got: " + listToString(result));
    }

    @Test
    public void testDifferentLengths1() {
        // 测试不同长度: (1 -> 2 -> 3) + (4 -> 5) = 5 -> 7 -> 3
        // 解释: 321 + 54 = 375
        ListNode l1 = createList(new int[]{1, 2, 3});
        ListNode l2 = createList(new int[]{4, 5});
        ListNode expected = createList(new int[]{5, 7, 3});

        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode result = solution.addTwoNumbers(l1, l2);

        assertTrue(areListsEqual(expected, result),
                "Expected: " + listToString(expected) + ", but got: " + listToString(result));
    }

    @Test
    public void testDifferentLengths2() {
        // 测试不同长度: (9 -> 9) + (1) = 0 -> 0 -> 1
        // 解释: 99 + 1 = 100
        ListNode l1 = createList(new int[]{9, 9});
        ListNode l2 = createList(new int[]{1});
        ListNode expected = createList(new int[]{0, 0, 1});

        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode result = solution.addTwoNumbers(l1, l2);

        assertTrue(areListsEqual(expected, result),
                "Expected: " + listToString(expected) + ", but got: " + listToString(result));
    }

    @Test
    public void testCarryOver() {
        // 测试多个进位: (9 -> 8) + (1 -> 2) = 0 -> 1 -> 1
        // 解释: 89 + 21 = 110
        ListNode l1 = createList(new int[]{9, 8});
        ListNode l2 = createList(new int[]{1, 2});
        ListNode expected = createList(new int[]{0, 1, 1});

        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode result = solution.addTwoNumbers(l1, l2);

        assertTrue(areListsEqual(expected, result),
                "Expected: " + listToString(expected) + ", but got: " + listToString(result));
    }

    @Test
    public void testOneEmptyList() {
        // 测试一个空链表: (1 -> 2 -> 3) + () = 1 -> 2 -> 3
        ListNode l1 = createList(new int[]{1, 2, 3});
        ListNode l2 = null;
        ListNode expected = createList(new int[]{1, 2, 3});

        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode result = solution.addTwoNumbers(l1, l2);

        assertTrue(areListsEqual(expected, result),
                "Expected: " + listToString(expected) + ", but got: " + listToString(result));
    }
}
