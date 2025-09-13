package com.only4.algorithm.version4j.leetcode;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Node head = new Node();
    private final Node tail = new Node();

    static class Node {
        int key, value;
        Node prev, next;

        Node() {
        }

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;

        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToHead(newNode);

            if (cache.size() > capacity) {
                Node last = removeTail();
                cache.remove(last.key);
            }
        }
    }

    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private Node removeTail() {
        Node last = tail.prev;
        removeNode(last);
        return last;
    }
}
