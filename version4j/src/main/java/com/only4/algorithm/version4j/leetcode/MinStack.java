package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayDeque;

class MinStack {
    private final ArrayDeque<Node> stack;

    static class Node {
        int val;
        int min;

        Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    public MinStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        int currentMin = stack.isEmpty() ? val : Math.min(val, getMin());
        stack.addLast(new Node(val, currentMin));
    }

    public void pop() {
        stack.removeLast();
    }

    public int top() {
        return stack.peekLast().val;
    }

    public int getMin() {
        return stack.peekLast().min;
    }
}
