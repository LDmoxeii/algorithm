package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * CopyRandomList的单元测试类
 */
public class CopyRandomListTest {

    /**
     * 测试空链表的情况
     */
    @Test
    public void testEmptyList() {
        CopyRandomList solution = new CopyRandomList();
        Node result = solution.copyRandomList(null);
        assertNull(result);
    }

    /**
     * 测试单个节点的情况
     */
    @Test
    public void testSingleNode() {
        Node head = new Node(1);
        head.random = head; // 指向自己

        CopyRandomList solution = new CopyRandomList();
        Node result = solution.copyRandomList(head);

        assertNotNull(result);
        assertEquals(1, result.val);
        assertNotSame(head, result); // 确保是新创建的节点
        assertSame(result, result.random); // random指向自己
    }

    /**
     * 测试示例1: [[7,null],[13,0],[11,4],[10,2],[1,0]]
     */
    @Test
    public void testExample1() {
        // 创建原始链表
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        // 设置next指针
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        // 设置random指针
        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        CopyRandomList solution = new CopyRandomList();
        Node result = solution.copyRandomList(node1);

        // 验证结果
        assertNotNull(result);
        assertNotSame(node1, result); // 确保是新创建的节点

        // 验证第一个节点
        assertEquals(7, result.val);
        assertNull(result.random);

        // 验证第二个节点
        Node copy2 = result.next;
        assertNotNull(copy2);
        assertEquals(13, copy2.val);
        assertSame(result, copy2.random); // random指向第一个节点

        // 验证第三个节点
        Node copy3 = copy2.next;
        assertNotNull(copy3);
        assertEquals(11, copy3.val);

        // 验证第四个节点
        Node copy4 = copy3.next;
        assertNotNull(copy4);
        assertEquals(10, copy4.val);
        assertSame(copy3, copy4.random); // random指向第三个节点

        // 验证第五个节点
        Node copy5 = copy4.next;
        assertNotNull(copy5);
        assertEquals(1, copy5.val);
        assertSame(result, copy5.random); // random指向第一个节点

        // 确保第三个节点的random指向第五个节点
        assertSame(copy5, copy3.random);

        // 确保链表结束
        assertNull(copy5.next);
    }

    /**
     * 测试示例2: [[1,1],[2,1]]
     */
    @Test
    public void testExample2() {
        // 创建原始链表
        Node node1 = new Node(1);
        Node node2 = new Node(2);

        // 设置next指针
        node1.next = node2;

        // 设置random指针 - 都指向第二个节点
        node1.random = node2;
        node2.random = node2;

        CopyRandomList solution = new CopyRandomList();
        Node result = solution.copyRandomList(node1);

        // 验证结果
        assertNotNull(result);
        assertEquals(1, result.val);

        Node copy2 = result.next;
        assertNotNull(copy2);
        assertEquals(2, copy2.val);

        // 验证random指针
        assertSame(copy2, result.random);
        assertSame(copy2, copy2.random);

        // 确保链表结束
        assertNull(copy2.next);
    }

    /**
     * 测试示例3: [[3,null],[3,0],[3,null]]
     */
    @Test
    public void testExample3() {
        // 创建原始链表
        Node node1 = new Node(3);
        Node node2 = new Node(3);
        Node node3 = new Node(3);

        // 设置next指针
        node1.next = node2;
        node2.next = node3;

        // 设置random指针
        node1.random = null;
        node2.random = node1;
        node3.random = null;

        CopyRandomList solution = new CopyRandomList();
        Node result = solution.copyRandomList(node1);

        // 验证结果
        assertNotNull(result);
        assertEquals(3, result.val);
        assertNull(result.random);

        Node copy2 = result.next;
        assertNotNull(copy2);
        assertEquals(3, copy2.val);
        assertSame(result, copy2.random);

        Node copy3 = copy2.next;
        assertNotNull(copy3);
        assertEquals(3, copy3.val);
        assertNull(copy3.random);

        // 确保链表结束
        assertNull(copy3.next);
    }
}
