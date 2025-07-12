package com.only4.algorithm.version4j.leetcode;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    private final int capacity;
    private final Map<Integer, Node> cache;
    private static final Node head = new Node(); // 虚拟头节点
    private static final Node tail = new Node(); // 虚拟尾节点

    static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        // 无参构造函数用于创建dummy节点
        public Node() {
            this(-1, -1);
        }

        // 将节点从链表中移除
        void removeNode() {
            this.prev.next = this.next;
            this.next.prev = this.prev;
        }

        // 将节点添加到链表末尾
        void addToEnd() {
            this.prev = tail.prev;
            this.next = tail;
            tail.prev.next = this;
            tail.prev = this;
        }

        // 将已存在的节点移动到链表末尾
        void moveToEnd() {
            removeNode();
            addToEnd();
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);

        // 初始化双向链表
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }

        // 将访问的节点移到链表末尾（最近使用）
        node.moveToEnd();
        return node.value;
    }

    public void put(int key, int value) {
        // 如果key已存在，更新值并移到末尾
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            node.moveToEnd();
            return;
        }

        // 如果缓存已满，移除最久未使用的节点（链表头部）
        if (cache.size() >= capacity) {
            Node leastUsed = head.next;
            leastUsed.removeNode();
            cache.remove(leastUsed.key);
        }

        // 创建新节点并添加到末尾
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        newNode.addToEnd();
    }
}
