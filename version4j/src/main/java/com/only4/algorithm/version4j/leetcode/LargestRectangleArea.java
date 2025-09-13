package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayDeque;

public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;

        int[] leftBoundary = new int[heights.length];
        int[] rightBoundary = new int[heights.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;

        // 计算每个柱子左边第一个比它矮的柱子位置
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peekLast()] >= heights[i]) {
                stack.removeLast();
            }
            leftBoundary[i] = stack.isEmpty() ? -1 : stack.peekLast();
            stack.addLast(i);
        }

        stack.clear();

        // 计算每个柱子右边第一个比它矮的柱子位置
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peekLast()] >= heights[i]) {
                stack.removeLast();
            }
            rightBoundary[i] = stack.isEmpty() ? heights.length : stack.peekLast();
            stack.addLast(i);
        }

        // 计算每个柱子能够形成的最大矩形面积
        for (int i = 0; i < heights.length; i++) {
            int area = (rightBoundary[i] - leftBoundary[i] - 1) * heights[i];
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}


