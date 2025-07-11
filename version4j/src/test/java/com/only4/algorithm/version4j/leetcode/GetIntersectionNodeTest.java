package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * GetIntersectionNode的测试类
 */
public class GetIntersectionNodeTest {

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
     * 创建两个相交的链表
     *
     * @param listA        链表A的值
     * @param listB        链表B的值
     * @param intersectVal 相交节点的值
     * @param skipA        链表A中相交前的节点数
     * @param skipB        链表B中相交前的节点数
     * @return 包含两个链表头节点的数组
     */
    private ListNode[] createIntersectLists(int[] listA, int[] listB, int intersectVal, int skipA, int skipB) {
        // 创建相交部分
        int[] intersectValues = new int[Math.max(listA.length - skipA, listB.length - skipB)];
        intersectValues[0] = intersectVal;
        for (int i = 1; i < intersectValues.length; i++) {
            if (skipA + i < listA.length) {
                intersectValues[i] = listA[skipA + i];
            } else if (skipB + i < listB.length) {
                intersectValues[i] = listB[skipB + i];
            }
        }
        ListNode intersect = createList(intersectValues);

        // 创建链表A
        ListNode headA = null;
        if (skipA > 0) {
            int[] prefixA = new int[skipA];
            for (int i = 0; i < skipA; i++) {
                prefixA[i] = listA[i];
            }
            headA = createList(prefixA);
            ListNode current = headA;
            while (current.next != null) {
                current = current.next;
            }
            current.next = intersect;
        } else {
            headA = intersect;
        }

        // 创建链表B
        ListNode headB = null;
        if (skipB > 0) {
            int[] prefixB = new int[skipB];
            for (int i = 0; i < skipB; i++) {
                prefixB[i] = listB[i];
            }
            headB = createList(prefixB);
            ListNode current = headB;
            while (current.next != null) {
                current = current.next;
            }
            current.next = intersect;
        } else {
            headB = intersect;
        }

        return new ListNode[]{headA, headB};
    }

    @Test
    public void testIntersection1() {
        // 测试用例1: 相交于节点8
        // listA: 4->1->8->4->5
        // listB: 5->6->1->8->4->5
        int[] listA = {4, 1, 8, 4, 5};
        int[] listB = {5, 6, 1, 8, 4, 5};
        int intersectVal = 8;
        int skipA = 2;
        int skipB = 3;

        ListNode[] lists = createIntersectLists(listA, listB, intersectVal, skipA, skipB);

        GetIntersectionNode solution = new GetIntersectionNode();
        ListNode result = solution.getIntersectionNode(lists[0], lists[1]);

        assertNotNull(result);
        assertEquals(intersectVal, result.val);
    }

    @Test
    public void testIntersection2() {
        // 测试用例2: 相交于节点2
        // listA: 1->9->1->2->4
        // listB: 3->2->4
        int[] listA = {1, 9, 1, 2, 4};
        int[] listB = {3, 2, 4};
        int intersectVal = 2;
        int skipA = 3;
        int skipB = 1;

        ListNode[] lists = createIntersectLists(listA, listB, intersectVal, skipA, skipB);

        GetIntersectionNode solution = new GetIntersectionNode();
        ListNode result = solution.getIntersectionNode(lists[0], lists[1]);

        assertNotNull(result);
        assertEquals(intersectVal, result.val);
    }

    @Test
    public void testNoIntersection() {
        // 测试用例3: 没有相交点
        // listA: 2->6->4
        // listB: 1->5
        ListNode headA = createList(new int[]{2, 6, 4});
        ListNode headB = createList(new int[]{1, 5});

        GetIntersectionNode solution = new GetIntersectionNode();
        ListNode result = solution.getIntersectionNode(headA, headB);

        // 算法已修复，现在可以正确处理无交点情况
        assertNull(result);
    }
}
