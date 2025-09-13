package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayDeque;

public class DecodeString {

    static class RepeatItem {
        StringBuilder content = new StringBuilder();
        int count;

        public RepeatItem(int count) {
            this.count = count;
        }

        @Override
        public String toString() {
            return content.toString().repeat(count);
        }
    }

    public String decodeString(String s) {
        ArrayDeque<RepeatItem> stack = new ArrayDeque<>();
        stack.add(new RepeatItem(1));
        StringBuilder number = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                number.append(c);
            } else if (c == '[') {
                int count = Integer.parseInt(number.toString());
                number = new StringBuilder();
                stack.addLast(new RepeatItem(count));
            } else if (c == ']') {
                RepeatItem item = stack.removeLast();
                stack.peekLast().content.append(item.toString());
            } else {
                stack.peekLast().content.append(c);
            }
        }

        return stack.peekLast().toString();
    }
}
