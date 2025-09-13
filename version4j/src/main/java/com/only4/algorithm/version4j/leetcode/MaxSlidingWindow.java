package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k <= 0) return new int[0];

        // 使用双端队列存储索引，维护单调递减
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];

        for (int right = 0; right < nums.length; right++) {
            // 移除队尾所有小于当前元素的索引，维护单调递减
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[right]) {
                deque.pollLast();
            }

            // 当前索引入队
            deque.offerLast(right);

            // 计算左边界
            int left = right - k + 1;

            // 移除超出窗口范围的索引
            if (deque.peekFirst() < left) {
                deque.pollFirst();
            }

            // 当窗口形成时，记录最大值
            if (left >= 0) {
                result[left] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}
