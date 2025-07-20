package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayDeque;

public class IsValid {
    public boolean isValid(String s) {
        ArrayDeque<Character> deque = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                deque.addLast(c);
            } else {
                if (c == ')') if (deque.isEmpty() || deque.removeLast() != '(') return false;
                if (c == ']') if (deque.isEmpty() || deque.removeLast() != '[') return false;
                if (c == '}') if (deque.isEmpty() || deque.removeLast() != '{') return false;
            }
        }
        return deque.isEmpty();
    }
}
