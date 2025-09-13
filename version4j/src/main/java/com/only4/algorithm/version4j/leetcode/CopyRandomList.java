package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.Node;

public class CopyRandomList {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // 步骤1：在每个原节点后创建复制节点
        Node current = head;
        while (current != null) {
            Node copy = new Node(current.val);
            copy.next = current.next;
            current.next = copy;
            current = copy.next;
        }

        // 步骤2：设置复制节点的random指针
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // 步骤3：分离原链表和复制链表
        Node copyHead = head.next;
        current = head;
        while (current != null && current.next != null) {
            Node temp = current.next;
            current.next = current.next.next;
            current = temp;
        }

        return copyHead;
    }
}
