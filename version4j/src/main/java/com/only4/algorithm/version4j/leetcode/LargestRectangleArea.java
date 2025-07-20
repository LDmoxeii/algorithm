package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayDeque;

public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int result = 0;

        int[] left = new int[heights.length];
        int[] right = new int[heights.length];

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < heights.length; i++) {
            while (!deque.isEmpty() && heights[deque.peekLast()] >= heights[i]) {
                deque.removeLast();
            }
            left[i] = deque.isEmpty() ? -1 : deque.peekLast();
            deque.addLast(i);
        }

        deque = new ArrayDeque<>();

        for (int i = heights.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && heights[deque.peekLast()] >= heights[i]) {
                deque.removeLast();
            }
            right[i] = deque.isEmpty() ? heights.length : deque.peekLast();
            deque.addLast(i);
        }

        for (int i = 0; i < heights.length; i++) {
            int area = (right[i] - left[i] - 1) * heights[i];
            result = Math.max(result, area);
        }

        return result;
    }

    public static void main(String[] args) {
        new LargestRectangleArea().largestRectangleArea(new int[]{1});
    }
}


