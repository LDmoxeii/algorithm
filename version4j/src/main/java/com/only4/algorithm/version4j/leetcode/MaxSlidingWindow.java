package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayDeque;

public class MaxSlidingWindow {


    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        for (int fast = 0; fast < nums.length; fast++) {
            int slow = fast - k + 1;
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[fast]) deque.pollLast();
            deque.offerLast(fast);
            if (deque.peekFirst() < slow) deque.pollFirst();
            if (slow < 0) continue;
            result[slow] = nums[deque.peekFirst()];
        }
        return result;
    }
}
