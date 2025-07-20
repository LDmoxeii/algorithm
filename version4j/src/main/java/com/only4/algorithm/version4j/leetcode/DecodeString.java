package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayDeque;

public class DecodeString {

    static class Decoder {
        StringBuilder s = new StringBuilder();
        int count;

        public Decoder(int count) {
            this.count = count;
        }

        @Override
        public String toString() {
            return s.toString().repeat(count);
        }
    }

    public String decodeString(String s) {
        ArrayDeque<Decoder> deque = new ArrayDeque<>();
        deque.add(new Decoder(1));
        StringBuilder num = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9') {
                num.append(c);
            } else if (c == '[') {
                String numString = num.toString();
                num = new StringBuilder();
                deque.addLast(new Decoder(Integer.decode(numString)));
            } else if (c == ']') {
                Decoder decoder = deque.removeLast();
                deque.peekLast().s.append(decoder);
            } else {
                deque.peekLast().s.append(c);
            }
        }

        return deque.peekLast().toString();
    }
}
