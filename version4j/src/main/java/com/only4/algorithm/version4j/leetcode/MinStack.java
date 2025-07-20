package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayDeque;

class MinStack {

    private final ArrayDeque<Node> deque;

    static class Node {
        int val;
        int min;
    }

    public MinStack() {
        deque = new ArrayDeque<>();
        Node node = new Node();
        node.val = 0;
        node.min = Integer.MAX_VALUE;
        deque.add(node);
    }

    public void push(int val) {
        Node node = new Node();
        node.val = val;
        node.min = Math.min(val, getMin());
        deque.addLast(node);
    }

    public void pop() {
        deque.removeLast();
    }

    public int top() {
        return deque.peekLast().val;
    }

    public int getMin() {
        return deque.peekLast().min;
    }
}
