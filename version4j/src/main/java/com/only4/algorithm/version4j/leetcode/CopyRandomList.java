package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.Node;

public class CopyRandomList {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        createCopyNodes(head);
        assignRandomPointers(head);
        return separateLists(head);
    }

    private void createCopyNodes(Node head) {
        Node current = head;
        while (current != null) {
            Node copyNode = new Node(current.val);
            copyNode.next = current.next;
            current.next = copyNode;
            current = copyNode.next;
        }
    }

    private void assignRandomPointers(Node head) {
        Node current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }
    }

    private Node separateLists(Node head) {
        Node copyHead = head.next;
        Node current = head;
        while (current != null && current.next != null) {
            Node temp = current.next;
            current.next = current.next.next;
            current = temp;
        }
        return copyHead;
    }
}
