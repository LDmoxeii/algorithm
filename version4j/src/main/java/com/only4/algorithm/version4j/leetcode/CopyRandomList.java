package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.Node;

/**
 * LeetCode 138: 复制带随机指针的链表 (Copy List with Random Pointer)
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * <p>
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * 构造这个链表的深拷贝。深拷贝应该正好由 n 个全新节点组成，其中每个新节点的值都设为其对应的原节点的值。
 * 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。
 * 复制链表中的指针都不应指向原链表中的节点。
 * <p>
 * 解题思路：
 * 本题采用三步法解决，不使用额外的哈希表：
 * 1. 在原链表的每个节点后插入一个相同值的新节点，形成 A->A'->B->B'->C->C' 的结构。
 * 2. 为新节点的 random 指针赋值，新节点的 random 指向原节点 random 的下一个节点。
 * 3. 将交错的链表分离，得到原链表和复制的链表。
 * <p>
 * 时间复杂度：O(n)，其中 n 是链表的长度。
 * 空间复杂度：O(1)，不使用额外的哈希表，只使用常数级别的额外空间。
 */
public class CopyRandomList {

    /**
     * 复制带随机指针的链表
     *
     * @param head 原链表的头节点
     * @return 复制链表的头节点
     */
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // 步骤1：在每个原节点后创建一个新节点
        insertCopyNodes(head);

        // 步骤2：设置复制节点的random指针
        connectRandomPointers(head);

        // 步骤3：分离原链表和复制的链表
        return separateLinkedLists(head);
    }

    /**
     * 步骤1：在每个原节点后插入一个相同值的新节点
     * 例如：A->B->C 变为 A->A'->B->B'->C->C'
     *
     * @param head 原链表的头节点
     */
    private void insertCopyNodes(Node head) {
        Node current = head;
        while (current != null) {
            Node copy = new Node(current.val);
            Node next = current.next;

            // 插入复制节点
            current.next = copy;
            copy.next = next;

            // 移动到下一个原始节点
            current = next;
        }
    }

    /**
     * 步骤2：设置复制节点的random指针
     * 复制节点的random指向原节点random的下一个节点
     *
     * @param head 原链表的头节点
     */
    private void connectRandomPointers(Node head) {
        Node current = head;
        while (current != null) {
            Node copy = current.next;

            // 设置复制节点的random指针
            if (current.random != null) {
                copy.random = current.random.next;
            }

            // 移动到下一个原始节点
            current = copy.next;
        }
    }

    /**
     * 步骤3：分离原链表和复制的链表
     * 将 A->A'->B->B'->C->C' 分离为 A->B->C 和 A'->B'->C'
     *
     * @param head 原链表的头节点
     * @return 复制链表的头节点
     */
    private Node separateLinkedLists(Node head) {
        Node copyHead = head.next;  // 复制链表的头节点
        Node current = head;
        Node copyCurrent = copyHead;

        while (current != null && copyCurrent != null) {
            // 恢复原链表的next指针
            current.next = copyCurrent.next;

            // 设置复制链表的next指针
            if (copyCurrent.next != null) {
                copyCurrent.next = copyCurrent.next.next;
            }

            // 移动到下一个节点
            current = current.next;
            copyCurrent = copyCurrent.next;
        }

        return copyHead;
    }
}
