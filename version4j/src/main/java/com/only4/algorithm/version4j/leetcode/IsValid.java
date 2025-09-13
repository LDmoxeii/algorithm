package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayDeque;

public class IsValid {
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.addLast(c);
            } else {
                if (stack.isEmpty()) return false;

                char top = stack.removeLast();
                if ((c == ')' && top != '(') ||
                        (c == ']' && top != '[') ||
                        (c == '}' && top != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
